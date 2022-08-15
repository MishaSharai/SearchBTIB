package by.btib.SearchBTIB.controller;

import by.btib.SearchBTIB.model.User;
import by.btib.SearchBTIB.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("users")
    String users(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping("users")
    String create(@RequestParam Map<String, String> params, User user) {
        user.setLogin(params.get("login"));
        user.setPassword(params.get("password1"));
        user.setRole(params.get("role"));
        user.setName(params.get("name"));
        userRepository.save(user);
        return "redirect:users";
    }

    @GetMapping("users/delete")
    String delete(int id) {
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
