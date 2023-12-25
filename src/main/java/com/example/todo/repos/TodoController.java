package com.example.todo.repos;
import com.example.todo.MessageRepoJDBC;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import com.example.todo.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
class TodoController {
    @Autowired
    MessageRepoJDBC massageRepoJDBC;

    @GetMapping
    public String home(Model model) {
        List<Message> todo = massageRepoJDBC.getAll();
        System.out.println(todo);
        model.addAttribute("todo", todo);
        return "index";
    }

    @PostMapping(consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String add(@ModelAttribute Message message, Model model) {
        massageRepoJDBC.add(message);
        return "redirect:/";
    }
}
//    @PostMapping (consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public void add(@RequestBody Message message, Model model) {
//
//        massageRepoJDBC.add(message);
//        home(model);
//    }


