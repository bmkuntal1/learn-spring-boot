package com.bmkuntal.springbootjsp.controllers;

import com.bmkuntal.springbootjsp.models.Todo;
import com.bmkuntal.springbootjsp.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;

@Controller
@SessionAttributes("username")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping("todo-list")
    public String todoList(ModelMap model) {
        model.addAttribute("todos", todoService.findAll());
        return "todo-list";
    }

    @RequestMapping("todo-detail")
    public String todoList(@RequestParam Long id, ModelMap model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todo-list";
    }

    @RequestMapping("todo-add")
    public String todoAdd(ModelMap model) {
        var username=model.getAttribute("username").toString();
        model.put("todo", new Todo(11L, username, "Default Desc", LocalDate.now(), false));
        return "todo-add";
    }

//    @RequestMapping(value = "todo-add", method = RequestMethod.POST)
//    public String todoAdd(@RequestParam String description, @RequestParam LocalDate targetDate, ModelMap model) {
//        var username = model.getAttribute("username");
//        todoService.add(new Todo(10L, username.toString(), description, targetDate, false));
//
//        return "redirect:todo-list";
//    }


    @RequestMapping(value = "todo-add", method = RequestMethod.POST)
    public String todoAdd(ModelMap model, @Valid Todo todo) {
        todo.setUsername(model.getAttribute("username").toString());
        todo.setId(11l);
        todoService.add(todo);
        return "redirect:todo-list";
    }

    @RequestMapping("todo-update")
    public String todoUpdate(@RequestParam Long id, ModelMap model) {
        model.addAttribute("todo", todoService.findById(id));
        return "todo-update";
    }

    @RequestMapping(value = "todo-update", method = RequestMethod.POST)
    public String todoUpdate(ModelMap model,@Valid Todo todo) {
        todoService.update(todo);
        return "redirect:todo-list";
    }

    @RequestMapping(value = "todo-delete")
    public String todoDelete(@RequestParam long id) {
        todoService.delete(id);
        return "redirect:todo-list";
    }
}
