package com.example.demo2.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<User> getUser(){
        return userService.getUser();
    }

    @GetMapping(path = "/{id}")
    public User getUserbyId(@PathVariable("id") Integer id ) {
        return userService.getUserbyId(id);}

    @PostMapping
    public void registerNewUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @PutMapping(path = "/{id}")
    public User updateUser (@PathVariable ("id") Integer id, @RequestBody User user) {
        User returnedUser = userService.updateUser(id, user);
        return returnedUser;
    }

    @PatchMapping(path = "/{id}")
    public User updateUserEmail (@PathVariable("id") Integer id, @RequestBody User user) {
        User returnedUserService = userService.updateUserEmail(id, user);
        return returnedUserService;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") Integer id ) { userService.deleteUser(id); }

}
