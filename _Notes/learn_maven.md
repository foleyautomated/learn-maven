# Seciton 5: Maven Basics
## Maven Coordinates
![Maven Coordinates](image.png)
![Maven Versions](image-1.png)
![Snapshot Version](image-2.png)

## Maven Repositories
![Maven Repositories](image-3.png)
![Maven Repositories](image-4.png)

Snapshots dont get cached locally--maven will always look for a newer copy of it. Otherwise, it takes it and then never checks for that version again.

[Here's an example of the User Friendly Maven Central Repository GUI](https://mvnrepository.com/artifact/com.google.android.material/compose-theme-adapter-3/1.1.0)

## Maven Wagon
![alt text](image-5.png)
![alt text](image-6.png)

A layer of abstraction created by the Maven Team; but, it's so deep that people often don't need it.
If I ever need to do "something like a proxy"; I can look this up and use it. Otherwise, I'll probably just get on with my life. 

## Maven POM 'Project Object Model'
![alt text](image-7.png)
maven has a maven xsd file which says what is allowed to go into a POM.
This file is called "maven-4.0.0.xsd" and I can look at it if I want to get an idea for what mavan suports in a POM. 🤔

`mvn help:effective-pom` <-- Shows what POM arrises under the hood from the combination of all the children.

## Maven Dependencies
![Maven Dependency Types](image-8.png)
![Dependency Mediation](image-9.png)

Interestingly, in cases where maven detects multiple versions of the same dependency scattered around the dependency tree, it tries to find "the closest" (i.e., the closest to the parent within the tree). Generally, this results in Shallower Dependencies winning out over deeper ones (I think?) but the Maven Guru says things can get funky. Generally, you get the latest version. 

![Dependency Scope](image-10.png)
"Runtime" scope is older--you would "Magically arive in your container and find that many of the artifacts upon which you depend were already waiting for you". Such an approach takes effort, however, and the industry is moving back towards self-contained packages. 

Make sure you don't forget to exclude things like "JUnit" or "Mockito" so that downstream consumers of your package don't need it.

"Import" --> Allows you to just say "Use that pom.xml over there for my project
![Dependency Plugin Commands](image-11.png)
`mvn dependency: tree, go-offline, purge-local-repository, sources`
![How to see dependency scope from the command line](image-12.png)

## Maven Standard Directory Layout
![Standard Maven Directory Layout](image-13.png)
 `src` files are typically organized by *language:* java, kotlin, etc. You can also view the: [Docs for standard Maven Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)

## Maven Build Lifecycles
![Maven Build LifeCycles](image-14.png)
Work done in maven is done by Plugins. Goals are inside Phases, and phases are inside the Lifecycle. 

|-------------------------------|
|Lifecycle                      |  
|     |------------------------ |  
|     |    Phase                |                   
|     |      |------------------|        
|     |      |    Goal          |           
|-----|-------------------------|

![Pre Defined Lifecycles: Clean, default, site](image-15.png)

![The 'clean' lifecycle](image-16.png)
the 'clean' lifecycle has three phases: pre-clean, clean, and post-clean

![Default Lifecycel at a High Level](image-17.png)

![All Phases in the Default Lifecycle](image-18.png)
We have the option to glue actions to each of these phases. Tons of stuff in the Default lifecycle.

![Default LIfecycle for JAR Packaging](image-19.png)

(Less Common)
![Site Build Lifecycle](image-20.png)

## Maven Wrapper
**Considered a Best Practice!**
You can distribute maven with your project using maven wrapper. This allows project-specific Maven artifacts (rather than just using whatever you IDE finds on the OS)

Using this allows your builds to be more portable. 
This might be worth coming back to in the future. 

Bascially, just look this up if you ever need it.  It's just more mvn commands to create. As long as java is installed, the build will run on new machines. 

This is useful for making the project more portable, either as a distributable project, or as a way to make deployments smoother. 

## Maven Archetypes
![Maven Archetypes](image-21.png)
Many of these are out of date. Like "J2EE". 10 years dead. 
[Check out these archetypes if you're curious](https://maven.apache.org/archetypes/index.html)
FYI; 'archetype' is the plugin, and 'generate' is the goal. 

# Section 6: Common Maven Plugins
"Basically, maven is just a thing that runs plugins"

## Overview Maven Lifecycle Plugins

### DEFAULT LIFECYCLE PLUGINS
![Compiler](image-22.png)
![Resources](image-23.png) --> Teacher Never had to touch this
![Surefire](image-24.png) --> Important, seems to mostly handle testing. Also handles POJO tests; has default extensions it looks for. 
 - The jar plugin; probably don't need to worry about this one.
![Deploy](image-25.png)

### 'SITE' LIFECYCEL PLUGINS
Probably not relevant to me. 

## Maven Clean Plugin
Run the regularly, especially while refactoring. This is because all the pre-refactor nonsense is still in the target directory, even after refactors have taken place. Whithout doing this, package will just take what's there (I think)
![Example of using the 'clean' plugin in a pom file](image-27.png)
The above example is great; it shows how a projet can reference the `maven-clean-plugin` and then add a reference to the `<initialize>` phase before deciding to use a clean goal: `<goal>clean</goal>` 


![Maven Cheat Sheet](image-26.png)
