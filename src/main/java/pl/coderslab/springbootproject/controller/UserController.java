package pl.coderslab.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.springbootproject.model.User;
import pl.coderslab.springbootproject.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/show/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        User user = userService.findUserById(id);
        model.addAttribute(user);
        return user.toString();
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        } else {
            userService.saveUser(user);
            return "allUsers";
        }
    }

    @GetMapping("/all")
    public String showAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute @Valid User user, BindingResult result){
        /*if() {

        }*/
        return "";
    }

}
