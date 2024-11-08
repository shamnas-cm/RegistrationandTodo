package reg.ResgistrationApp.repositary;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import reg.ResgistrationApp.model.Todo;

@Repository
public interface TodoRepositary extends JpaRepository<Todo, Long>{

	List<Todo> findByStatus(String status);

	List<Todo> findByStatusNot(String string);

}
