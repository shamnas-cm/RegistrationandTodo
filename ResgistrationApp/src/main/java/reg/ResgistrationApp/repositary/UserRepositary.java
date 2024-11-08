package reg.ResgistrationApp.repositary;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import reg.ResgistrationApp.model.User;

public interface UserRepositary extends CrudRepository<User, Integer> {
	User findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
