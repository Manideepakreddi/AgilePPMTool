package hcl.repositories;

 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hcl.domain.ProjectTask;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {
}