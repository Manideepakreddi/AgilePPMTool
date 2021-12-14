package hcl.repositories;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcl.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}