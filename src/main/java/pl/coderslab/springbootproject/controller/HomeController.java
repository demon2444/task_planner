package pl.coderslab.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.service.UserService;
import pl.coderslab.springbootproject.service.UserServiceImpl;

@Controller
@RequestMapping("/")
public class HomeController {

    private UserServiceImpl userServiceImpl;

    @Autowired
    public HomeController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("")
    public String home(){
        return "home";
    }
    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

}
