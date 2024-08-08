package learn.springframework.controllers;

import guru.springframework.domain.UserCommand;
import learn.multi.module.User;

public class UserController {
  User saveUser(UserCommand command) {
    return new User();
  }
}
