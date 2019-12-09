package pl.artur97szat.shopanchor.registration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String registrationForm(Model model) {
        model.addAttribute("registrationData", new RegistrationDataDTO());
        return "registration/register-form";
    }

    @PostMapping
    public String processRegistration(@ModelAttribute("registrationData") @Valid RegistrationDataDTO registrationData, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/register-form";
        }

        registrationService.RegisterUser(registrationData);
        return "redirect: /";
    }

}
