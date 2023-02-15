package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    TodoRepository repoObj;

    public List<TodoEntity> fetchAll() {
        return repoObj.findAll();
    }

    public TodoEntity addNewTask(TodoEntity entity) {
        TodoEntity todoEntity = repoObj.save(entity);
        return todoEntity;
    }

    public TodoEntity getTaskById(int id) {
        Optional<TodoEntity> optional = repoObj.findById(id);
        TodoEntity todoEntity = null;
        if(optional.isPresent()){
            todoEntity = optional.get();
            return todoEntity;
        }
        else {
            throw new RuntimeException("Task not present for id ::" + id);
        }
    }

    public void deleteTaskById(int id) {
        repoObj.deleteAllById(Collections.singleton(id));
    }
}
