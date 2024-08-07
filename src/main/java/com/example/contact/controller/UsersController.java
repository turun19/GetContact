package com.example.contact.controller;

import com.example.contact.dto.BaseResponse;
import com.example.contact.dto.GetUserResponse;
import com.example.contact.entity.Contact;
import com.example.contact.entity.Users;
import com.example.contact.service.UserService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsersController {
    @Autowired
    UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<BaseResponse<GetUserResponse>> getUserContact(@PathVariable Long id){
        try{
            return ResponseEntity.ok(BaseResponse.success(userService.getUserResponse(id), "Success"));
        }catch (Exception e){
            return ResponseEntity.ok(BaseResponse.failure(404, "User not found"));
        }
    }

    @GetMapping("/")
    public ResponseEntity<BaseResponse<List<Users>>> getUser(){
        try{
            return ResponseEntity.ok(BaseResponse.success(userService.getUser(), "Success"));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(BaseResponse.failure(404, "User Belum Dibuat"));
        }
    }

    @GetMapping("/contact")
    public ResponseEntity<BaseResponse<List<Contact>>> getContact(){
        return ResponseEntity.ok(BaseResponse.success(userService.getContact(), "Success"));
    }
}
