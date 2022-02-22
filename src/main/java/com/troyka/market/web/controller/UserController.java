package com.troyka.market.web.controller;

import com.troyka.market.domain.DtoUser;
import com.troyka.market.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<DtoUser>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }


}
