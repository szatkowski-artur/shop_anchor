package pl.artur97szat.shopanchor.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Secured("ROLE_USER")
@Controller @RequestMapping("/user")
public class UserController {

   @GetMapping
   public String userHomePage(Model model, Principal principal){
        model.addAttribute("username", principal.getName());
       return "user/user-dashboard";
   }

}
