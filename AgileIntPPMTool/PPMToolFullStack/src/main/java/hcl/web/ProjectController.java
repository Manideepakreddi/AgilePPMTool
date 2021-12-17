package hcl.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import hcl.domain.Project;
import hcl.services.MapValidationErrorService;
import hcl.services.ProjectService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

   @Autowired
   private ProjectService projectService;

   @Autowired
   private MapValidationErrorService mapValidationErrorService;


   @PostMapping("")
   public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result, Principal principal){

       ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
       if(errorMap!=null) return errorMap;

       Project project1 = projectService.saveOrUpdateProject(project, principal.getName());
       return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
   }


   @GetMapping("/{projectId}")
   public ResponseEntity<?> getProjectById(@PathVariable String projectId){

       Project project = projectService.findProjectByIdentifier(projectId);

       return new ResponseEntity<Project>(project, HttpStatus.OK);
   }


   @GetMapping("/all")
   public Iterable<Project> getAllProjects(){return projectService.findAllProjects();}


   @DeleteMapping("/{projectId}")
   public ResponseEntity<?> deleteProject(@PathVariable String projectId){
       projectService.deleteProjectByIdentifier(projectId);

       return new ResponseEntity<String>("Project with ID: '"+projectId+"' was deleted", HttpStatus.OK);
   }
}