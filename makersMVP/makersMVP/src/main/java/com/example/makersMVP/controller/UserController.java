package com.example.makersMVP.controller;

import com.example.makersMVP.domain.User;
import com.example.makersMVP.dto.UserCollectionDTO;
import com.example.makersMVP.dto.UserDTO;
import com.example.makersMVP.exceptions.BadRequestException;
import com.example.makersMVP.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/new")
    public ResponseEntity<User> registerUser(@RequestBody UserDTO userDTO) throws BadRequestException {
        return ResponseEntity.ok(userService.registerUser(userDTO));
    }

    @PostMapping("/get")
    public ResponseEntity<User> findUser(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.findUserByUserEmail(userDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody UserDTO userDTO) throws Exception {
        return ResponseEntity.ok(userService.login(userDTO));
    }

    @PutMapping("/addFav")
    public ResponseEntity<User> addFav(@RequestBody UserCollectionDTO userCollectionDTO) throws Exception {
        return ResponseEntity.ok(userService.addFavCollection(userCollectionDTO));
    }

    @PutMapping("/delFav")
    public ResponseEntity<User> deleteFav(@RequestBody UserCollectionDTO userCollectionDTO) throws Exception {
        return ResponseEntity.ok(userService.unsetFav(userCollectionDTO));
    }

}
