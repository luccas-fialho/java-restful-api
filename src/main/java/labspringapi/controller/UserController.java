package labspringapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import labspringapi.domain.model.User;
import labspringapi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<User> findById(@PathVariable Long id) {
    User user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody User user) {
      userService.createUser(user);
      return ResponseEntity.ok(user);
  }
  
}
