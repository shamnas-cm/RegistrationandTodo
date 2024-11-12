package reg.ResgistrationApp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reg.ResgistrationApp.model.User;
import reg.ResgistrationApp.service.UserService;
import reg.ResgistrationApp.util.LoginRequest;
import reg.ResgistrationApp.util.UserDto;
@CrossOrigin(origins = "https://shamnasproject.netlify.app")
@RestController
public class RegistrationController {
   @Autowired
	UserService service;
	
   @PostMapping("/save")
	public ResponseEntity<User> registerUser(@RequestBody UserDto udto){
		User saveUser = service.saveUser(udto);
		return new ResponseEntity<User>(saveUser,HttpStatus.CREATED);
	}
   
   @PostMapping("/login")
   public ResponseEntity<User> login(@RequestBody LoginRequest req){
	   String email = req.getEmail();
	   String password = req.getPassword();
	   User user=service.login(email,password);
	   System.out.println(user);
	   return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
   }
   
   
}
