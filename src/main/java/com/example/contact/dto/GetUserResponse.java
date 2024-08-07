package com.example.contact.dto;

import com.example.contact.entity.Contact;
import lombok.Data;

import java.util.List;

@Data
public class GetUserResponse {
    private Long id;
    private String name;
    private Integer age;
    private List<ContactResponse> contact;
}
