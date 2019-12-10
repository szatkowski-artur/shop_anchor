package pl.artur97szat.shopanchor.registration.first;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.registration.details.DetailsRegistrationDataDTO;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("registrationDataDTO", new FirstRegistrationDataDTO());
        return "registration/register-form";
    }

    @PostMapping
    public String processFirstRegistration(@ModelAttribute("registrationDataDTO") @Valid FirstRegistrationDataDTO registrationData, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/register-form";
        }
        registrationService.RegisterUser(registrationData);
        return "registration/first-register-info";
    }


}
