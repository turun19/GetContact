package com.example.contact.repository;

import com.example.contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ConcurrentModificationException;
import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query("select c from Contact c where c.user.id = :id order by c.id asc")
    List<Contact> findByUserId(Long id);
}
