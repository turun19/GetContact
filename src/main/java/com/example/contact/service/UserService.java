package com.example.contact.service;

import com.example.contact.dto.ContactResponse;
import com.example.contact.dto.GetUserResponse;
import com.example.contact.entity.Contact;
import com.example.contact.entity.Users;
import com.example.contact.repository.ContactRepository;
import com.example.contact.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    ContactRepository contactRepository;

    public GetUserResponse getUserResponse(Long userId) {
        Users user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        GetUserResponse response = new GetUserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setAge(user.getAge());

        List<ContactResponse> contactResponses = contactRepository.findByUserId(userId).stream()
                .map(contact -> {
                    ContactResponse contactResponse = new ContactResponse();
                    contactResponse.setId(contact.getId());
                    contactResponse.setAddress(contact.getAddress());
                    return contactResponse;
                })
                .collect(Collectors.toList());

        response.setContact(contactResponses);
        return response;
    }

    public List<Users> getUser(){
        return usersRepository.findAllByOrderByIdDesc();
    }

    public List<Contact> getContact(){
        return contactRepository.findAll();
    }
}
