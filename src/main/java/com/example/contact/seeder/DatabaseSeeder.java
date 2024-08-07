package com.example.contact.seeder;

import com.example.contact.entity.Contact;
import com.example.contact.entity.Users;
import com.example.contact.repository.ContactRepository;
import com.example.contact.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DatabaseSeeder implements CommandLineRunner {
    private final UsersRepository usersRepository;
    private final ContactRepository contactRepository;

    public DatabaseSeeder(UsersRepository usersRepository, ContactRepository contactRepository) {
        this.usersRepository = usersRepository;
        this.contactRepository = contactRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Users users = createUser();
        createContact(users);
    }

    private Users createUser(){
        Users users = new Users();
        users.setName("user");
        users.setAge(17);
        usersRepository.save(users);
        return users;
    }

    private void createContact(Users users){
        Contact contact = new Contact();
        contact.setAddress("jl semangka 1 no 14");
        contact.setUser(users);
        contactRepository.save(contact);
    }
}
