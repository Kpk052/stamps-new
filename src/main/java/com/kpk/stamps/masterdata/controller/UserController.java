package com.kpk.stamps.masterdata.controller;


import com.kpk.stamps.masterdata.dto.UserDTO;
import com.kpk.stamps.masterdata.entity.User;
import com.kpk.stamps.masterdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/master")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/v1/users/{departmentId}")
    public ResponseEntity<User> createUser(@PathVariable Long userId, @RequestBody UserDTO userDTO){
        User user=userService.createUser(userId,userDTO);

        return ResponseEntity.ok(user);
    }

    @GetMapping("/v1/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> users=userService.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @GetMapping("/v1/users/byDepartment/{departmentId}")
    public ResponseEntity<List<User>> getAllUsersByDepartment(@PathVariable Long departmentId){
        List<User> users=userService.getAllUsersByDepartment(departmentId);

        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }


    @PutMapping("/v1/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId,@RequestBody UserDTO userDTO){
        User user= userService.updateUser(userId,userDTO);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/v1/users/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
