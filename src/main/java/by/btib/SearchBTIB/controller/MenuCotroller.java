package by.btib.SearchBTIB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuCotroller {
    @GetMapping("index")
    String index() {
        return "index";
    }
}
