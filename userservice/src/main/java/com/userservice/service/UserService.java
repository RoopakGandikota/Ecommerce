package com.userservice.service;

import com.userservice.feignclient.ProdControllerInterface;
import com.userservice.model.User;
import com.userservice.repo.Repo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private Repo repo;

    @Autowired
    private ProdControllerInterface objProdControllerInterface;


    public List<User> getAllUsers() {
    	System.out.println(objProdControllerInterface.helper());
        return repo.findAll();
    }

    public User getUserById(int id) {
        return repo.findById(id).get();
    }

    public String addUser(User user) {
        repo.save(user);
        return "success";
    }

    public String deleteUserById(int id) {
        repo.deleteById(id);
        return "deleted";
    }

    public String updateUserById(int id, User user) {
        Optional<User> user1=repo.findById(id);
        User tempUser=user1.get();
        tempUser.setAddress(user.getAddress());
        tempUser.setEmail(user.getEmail());
        tempUser.setUpdatedAt(user.getUpdatedAt());
        tempUser.setRole(user.getRole());
        tempUser.setPassword(user.getPassword());
        tempUser.setPhonenumber(user.getPhonenumber());
        tempUser.setCreatedAt(user.getCreatedAt());
        tempUser.setUsername(user.getUsername());
        repo.save(tempUser);
        return "Success";
    }

    @PostConstruct
    public void demoDD(){
        repo.save(new User(
                "john_doe",
                "john.doe@example.com",
                "SecurePass123",
                "123 Main Street, New York, NY",
                "+1-555-123-4567",
                "USER",
                LocalDate.of(2025, 8, 1),
                LocalDate.of(2025, 8, 29)
        ));
        User user1 = new User(
                "john_doe",
                "john.doe@example.com",
                "SecurePass123",
                "123 Main Street, New York, NY",
                "+1-555-123-4567",
                "USER",
                LocalDate.of(2025, 8, 1),
                LocalDate.of(2025, 8, 29)
        );

        User user2 = new User(
                "jane_smith",
                "jane.smith@example.com",
                "Passw0rd!",
                "456 Park Avenue, Los Angeles, CA",
                "+1-555-987-6543",
                "ADMIN",
                LocalDate.of(2025, 7, 15),
                LocalDate.of(2025, 8, 20)
        );

        User user3 = new User(
                "alex_kim",
                "alex.kim@example.com",
                "MySecret#456",
                "789 Elm Street, Chicago, IL",
                "+1-555-111-2222",
                "USER",
                LocalDate.of(2025, 6, 10),
                LocalDate.of(2025, 8, 5)
        );

        User user4 = new User(
                "maria_garcia",
                "maria.garcia@example.com",
                "StrongPass789",
                "321 Ocean Drive, Miami, FL",
                "+1-555-333-4444",
                "MODERATOR",
                LocalDate.of(2025, 5, 1),
                LocalDate.of(2025, 8, 25)
        );

        User user5 = new User(
                "david_lee",
                "david.lee@example.com",
                "SafeKey@2025",
                "654 River Road, Seattle, WA",
                "+1-555-555-6666",
                "USER",
                LocalDate.of(2025, 4, 8),
                LocalDate.of(2025, 8, 28)
        );

        repo.save(user1);
        repo.save(user2);
        repo.save(user3);
        repo.save(user4);
        repo.save(user5);
    }
}
