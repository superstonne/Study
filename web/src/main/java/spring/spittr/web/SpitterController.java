package spring.spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.spittr.Spitter;
import spring.spittr.data.SpitterRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    SpitterRepository spitterRepository;


    public SpitterController() {
    }

    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "registerForm";
    }

    @PostMapping("/register")
    public String register(@Valid Spitter spitter, Errors errors) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @GetMapping("/{username}")
    public String showSpitterProfile(@PathVariable String username, Model model) {
        model.addAttribute("spitter", spitterRepository.findByUserName(username));
        return "profile";
    }
}
