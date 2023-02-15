package com.example.demo;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


//to scan entity and spring data jpa repo
@DataJpaTest
public class TodoEntityRepoTests {

    @Autowired
    private TodoRepository todoRepository;

    // test case for save todo
    @Test
    public void saveTodo() {
        TodoEntity todoObj = TodoEntity.builder().task("Task 1 with junit").status("In progress").cur_date("15-02-2023").build();
        todoRepository.save(todoObj);

        Assertions.assertNotEquals(0,todoObj.getId());
    }

    @Test
    public  void getToDoTaskTest() {
        TodoEntity todoObj = todoRepository.findById(1).get();

        Assertions.assertEquals(todoObj.getId(),1);
    }

}
