package pl.artur97szat.shopanchor.registration.details;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.artur97szat.shopanchor.registration.registrationCode.RegistrationCodeService;
import pl.artur97szat.shopanchor.userDetails.Gender;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

//@Secured("ROLE_USER")
@Controller
@RequestMapping("register/details")
@Slf4j
public class RegistrationDetailsController {

    private final RegistrationDetailsService registrationDetailsService;
    private final RegistrationCodeService registrationCodeService;

    public RegistrationDetailsController(RegistrationDetailsService registrationDetailsService, RegistrationCodeService registrationCodeService) {
        this.registrationDetailsService = registrationDetailsService;
        this.registrationCodeService = registrationCodeService;
    }

    @ModelAttribute("genders")
    List<Gender> genders() {
        return Arrays.asList(Gender.values());
    }

    @ModelAttribute("countries")
    List<String> countries() {
        return Arrays.asList("POLAND", "GERMANY", "CZECH", "GREAT BRITAIN");
    }

    @GetMapping
    public String registrationDetailsForm(String registrationCode, Model model) {
        Long id = registrationCodeService.getUsersId(registrationCode);
        model.addAttribute("userDetailsDTO", new DetailsRegistrationDataDTO());
        model.addAttribute("owner", id);
        registrationDetailsService.confirmUser(id);
        registrationCodeService.deleteRegistrationCode(registrationCode);
        return "registration/register-details-form";
    }

    @PostMapping
    public String precessRegistrationDetailsForm(@ModelAttribute("userDetailsDTO") @Valid DetailsRegistrationDataDTO userDetails, BindingResult result) {
        if (result.hasErrors()) {
            return "registration/register-details-form";
        }
        log.error(userDetails.getCity());
        registrationDetailsService.addUserDetails(userDetails);
        return "redirect:/";
    }


}
