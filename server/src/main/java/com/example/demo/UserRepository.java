package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;
import java.util.List;
import java.util.Optional;;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

List<User> findByemail(String email);	

}
