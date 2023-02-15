package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class TodoController {

    @Autowired
    TodoService serviceObj;

    @GetMapping("/home")
    public String viewHomePage(Model model){
        List<TodoEntity> list = serviceObj.fetchAll();
        model.addAttribute("toDoList",list);
        return "index";
    }

    @GetMapping("/addToDo")
    public String viewAddToDoPage(Model model){
        TodoEntity dataObj = new TodoEntity();
        model.addAttribute("addToDoObj",dataObj);
        return "new_todoList";
    }

    /*@GetMapping("/all")
    public List<TodoEntity> fetchAllTodo(){
        return serviceObj.fetchAll();
    }

    @PostMapping("/add")
    public void  addNewTask(@RequestBody TodoEntity entity, Model model){
        serviceObj.addNewTask(entity);
    }*/

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("object") TodoEntity object){
        serviceObj.addNewTask(object);
        return "redirect:/home";
    }

    @GetMapping("/editToDo/{id}")
    public String editToDo(@PathVariable (value = "id") int id, Model model){
        TodoEntity entity = serviceObj.getTaskById(id);
        model.addAttribute("editToDoObj",entity);
        return "edit_todoList";
    }

    @GetMapping("/deleteToDo/{id}")
    public String deleteToDo(@PathVariable (value = "id") int id, Model model){
        serviceObj.deleteTaskById(id);
        return "redirect:/home";
    }
}
