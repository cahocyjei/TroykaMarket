package com.troyka.market.web.controller;

import com.troyka.market.domain.DtoUser;
import com.troyka.market.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoUser>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DtoUser> getUser(@PathVariable("id") int id) {
        return userService.getUser(id).map(user->new ResponseEntity<>(user,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<DtoUser> save(@RequestBody DtoUser dtoUser){
        return new ResponseEntity<>(userService.save(dtoUser),HttpStatus.CREATED);
    }
}
