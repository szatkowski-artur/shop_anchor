package pl.artur97szat.shopanchor.user;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Secured("ROLE_USER")
@Controller @RequestMapping("/user")
public class UserController {

   @GetMapping
   public String userHomePage(){
       return "user/user-dashboard";
   }

}
