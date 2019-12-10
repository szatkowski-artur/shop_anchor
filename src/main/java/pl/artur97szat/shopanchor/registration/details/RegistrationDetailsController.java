package pl.artur97szat.shopanchor.registration.details;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
//@Secured("ROLE_USER")
@Controller @RequestMapping("registration/details")
public class RegistrationDetailsController {

    private final RegistrationDetailsService registrationDetailsService;

    public RegistrationDetailsController(RegistrationDetailsService registrationDetailsService) {
        this.registrationDetailsService = registrationDetailsService;
    }

    @ModelAttribute("genders")
    List<String> genders(){
        return Arrays.asList("MALE","FEMALE") ;
    }

    @ModelAttribute("countries")
    List<String> countries(){
        return Arrays.asList("POLAND", "GERMANY", "CZECH", "GREAT BRITAIN");
    }

    @GetMapping
    public String registrationDetailsForm(Long id, Model model){
        model.addAttribute("userDetailsDTO", new DetailsRegistrationDataDTO());
        model.addAttribute("owner", id);
        registrationDetailsService.confirmUser(id);
        return "registration/register-details-form";
    }

    @PostMapping
    public String precessRegistrationDetailsForm(@ModelAttribute("userDetailsDTO")@Valid DetailsRegistrationDataDTO userDetails, BindingResult result){
        if (result.hasErrors()){
            return "registration/register-details-form";
        }
        registrationDetailsService.addUserDetails(userDetails);
        return "redirect:/";
    }


}
