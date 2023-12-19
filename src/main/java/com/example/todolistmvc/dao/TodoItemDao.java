package com.example.todolistmvc.dao;

import com.example.todolistmvc.entity.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemDao extends JpaRepository<TodoItem,Integer> {
}
