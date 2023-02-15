package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import java.text.DateFormat;


@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoEntity {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String task;
    @Column
    private String status;
    @Column
    private String cur_date;
}
