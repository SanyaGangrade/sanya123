package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.User;
import com.example.demo.UserRepository;


@CrossOrigin(origins = "http://localhost:4200")  // This means that this class is a Controller
@RestController
@RequestMapping("/signUp") // This means URL's start with /demo (after Application path)
@Controller    // This means that this class is a Controller





public class MainController {
	@Autowired // This means to get the bean called userRepository
	           // Which is auto-generated by Spring, we will use it to handle the data
	
	UserRepository userRepository;

	@GetMapping(path="/add")
	public List<User> getAllCustomers() {
		System.out.println("Get all users...");

		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);

		return users;
}
	/*private UserRepository userRepository;*/

	/*@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String name
			, @RequestParam String email ,@RequestParam String password) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setName(name);
		n.setEmail(email);
		n.setPAssword(password);
		userRepository.save(n);
		return "Saved";
	}*/
	@PostMapping(value = "/users/create")
	public User postUser(@RequestBody User user) {

	    User user1 =userRepository.save(new User(user.getName(),user.getEmail(),user.getId(),user.getPassword()));
		return user1;
	}
	
	@DeleteMapping("/users/delete")
	public ResponseEntity<String> deleteAllCustomers() {
		System.out.println("Delete All Customers...");

		userRepository.deleteAll();

		return new ResponseEntity<>("All customers have been deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "users/email/{email}")
	public List<User> findByemail(@PathVariable String email) {

		List<User>users = userRepository.findByemail(email);
		return users;
	}

	/*@PutMapping("/users/{email}")
	public ResponseEntity<User> updateUser(@PathVariable("email") String email, @RequestBody User user) {
		System.out.println("Update user with email = " + email + "...");

		List<User> userData =  userRepository.findByemail(email);

		if (((Object) userData).isPresent()) {
			User user1 = userData.get(0);
			user1.setName(user.getName());
			user1.setEmail(user.getEmail());
			
			return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}*/


	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepository.findAll();
	}
}

