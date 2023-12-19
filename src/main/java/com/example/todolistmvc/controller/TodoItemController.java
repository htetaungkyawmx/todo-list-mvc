package com.example.todolistmvc.controller;

import com.example.todolistmvc.dao.TodoItemDao;
import com.example.todolistmvc.entity.TodoItem;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class TodoItemController {
    private final TodoItemDao todoItemDao;
    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("todoItem",new TodoItem());
        model.addAttribute("todoItems",
                todoItemDao.findAll());
        return "index";
    }
    @PostMapping("/save-todo")
    public String saveTodoItem(@Valid TodoItem todoItem, BindingResult result){
        if(result.hasErrors()){
            return "index";
        }
        todoItemDao.save(todoItem);
        return "redirect:/";
    }
}
