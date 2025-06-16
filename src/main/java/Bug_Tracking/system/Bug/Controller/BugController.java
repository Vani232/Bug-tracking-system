package Bug_Tracking.system.Bug.Controller;

import Bug_Tracking.system.Bug.Entities.Bug;
//import Services.BugService;
import Bug_Tracking.system.Bug.Services.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
//@RequestMapping("/api")
@RequestMapping("/api/bugs") // Make sure all endpoints start with "/api/bugs"
public class BugController {

  @Autowired
  private BugService bugService;

  @Autowired
  public BugController(BugService bugService) {
    this.bugService = bugService;
  }

  // Endpoint to create a new bug
//  @PostMapping("/addBug")
  @PostMapping("/add")
  public ResponseEntity<Bug> createBug(@RequestBody Bug bug) {
    Bug savedBug = bugService.saveBug(bug);
    return new ResponseEntity<>(savedBug, HttpStatus.CREATED);
  }

  // Endpoint to update an existing bug
//  @PutMapping("/updateBug")
  @PutMapping("/updateBug/{id}")  // Correct

  public ResponseEntity<Bug> updateBug(@PathVariable int id, @RequestBody Bug bug) {
    Bug updatedBug = bugService.updateBug(id, bug);
    if (updatedBug != null) {
      return new ResponseEntity<>(updatedBug, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  // Endpoint to retrieve all bugs
  @GetMapping("/bugs")
  public ResponseEntity<List<Bug>> getAllBugs() {
    List<Bug> bugs = bugService.getAllBugs();
    return new ResponseEntity<>(bugs, HttpStatus.OK);
  }

  // Endpoint to delete a bug by ID
  @DeleteMapping("/deleteBug")
  public ResponseEntity<Void> deleteBug(@PathVariable int id) {
    boolean deleted = bugService.deleteBugById(id);
    if (deleted) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}