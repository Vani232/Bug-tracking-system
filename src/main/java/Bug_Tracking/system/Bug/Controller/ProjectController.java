package Bug_Tracking.system.Bug.Controller;

import Bug_Tracking.system.Bug.Entities.Project;
//import Services.ProjectService;
import Bug_Tracking.system.Bug.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping("/all")
    public List<Project> getAllProjectsApi() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectByIdApi(@PathVariable int id) {
        Project project = projectService.getProjectById(id);
        if (project != null) {
            return ResponseEntity.ok(project);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Project> createProjectApi(@RequestBody Project project) {
        Project createdProject = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProjectApi(@PathVariable int id, @RequestBody Project project) {
        Project updatedProject = projectService.updateProject(id, project);
        if (updatedProject != null) {
            return ResponseEntity.ok(updatedProject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProjectApi(@PathVariable int id) {
        boolean deleted = projectService.deleteProjectById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
