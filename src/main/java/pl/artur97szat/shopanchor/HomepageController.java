package pl.artur97szat.shopanchor;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller @RequestMapping("/")
public class HomepageController {

    @GetMapping
    public String homepage(){
        return "homepage";
    }

}
