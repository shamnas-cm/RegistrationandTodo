package reg.ResgistrationApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reg.ResgistrationApp.model.User;
import reg.ResgistrationApp.repositary.UserRepositary;
import reg.ResgistrationApp.util.UserDto;

@Service
public class UserService {
   @Autowired
	UserRepositary urepo;

public User saveUser(UserDto udto) {
	User user=new User();
	user.setEmail(udto.getEmail());
	user.setFirstName(udto.getFirstName());
	user.setLastName(udto.getLastName());
	user.setGender(udto.getGender());
	user.setMobileno(udto.getMobileno());
	user.setPassword(udto.getPassword());
	
	User save = urepo.save(user);
	return save;
	
}

public User login(String email, String password) {
	User findByEmailAndPassword = urepo.findByEmailAndPassword(email, password);
    System.out.println(email+" "+password);
	return findByEmailAndPassword;
	
}
	
   
   
}
