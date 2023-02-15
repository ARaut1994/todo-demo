package com.example.demo;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TodoServiceTests {

    @Autowired
    private TodoService todoService;

    @MockBean
    private TodoRepository todoRepository;

    @Test
    void testSaveToDoTask() {
        TodoEntity todoEntity = new TodoEntity().builder().task("task 1 test service layer").status("In progress").cur_date("15-02-2023").build();
        Mockito.when(todoRepository.save(todoEntity)).thenReturn(todoEntity);
        TodoEntity result = todoService.addNewTask(todoEntity);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("task 1 test service layer", result.getTask());
    }

    @Test
    void testGetToDoById() {
        TodoEntity todoEntity = new TodoEntity().builder().task("task 1 test service layer").status("In progress").cur_date("15-02-2023").build();
        Mockito.when(todoRepository.findById(1)).thenReturn(Optional.of(todoEntity));
        TodoEntity result = todoService.getTaskById(1);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("task 1 test service layer", result.getTask());
    }
}
