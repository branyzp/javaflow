package dev.branyzp.flow.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// A repository in Java Spring Boot terms is a component responsible for handling data access logic
// A repository typically provides CRUD operations for working with data from a database
// By extending JpaRepository, the UserRepository inherits CRUD operation methods such as save, findById, delete etc

// anything related to storage/retrieval goes here e.g. findById, findByEmail, saveUser etc
// this works closely with the service layer as the service layer will provide one-up functions that utilize the repository behind the hood to perform data retrieval and access actions
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   Optional<User> findByEmail(String email);


}
