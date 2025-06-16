package Bug_Tracking.system.Bug.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String homePage(){
        return "index";
    }
}
//package Bug_Tracking.system.Bug.Controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class HomeController {
//
//    @GetMapping("/")
//    public String homePage() {
//        return "index"; // loads index.jsp
//    }
//
//    @PostMapping("/register")
//    public String handleRegister(@RequestParam String username,
//                                 @RequestParam String password,
//                                 @RequestParam String email,
//                                 Model model) {
//
//        // Here you can add logic to save the user (or just simulate for now)
//        model.addAttribute("message", "You have successfully registered, " + username + "!");
//
//        return "success"; // This will render success.jsp
//    }
//}

