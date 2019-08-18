package com.niit.todochecklistmanagement.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.niit.todochecklistmanagement.model.Todo;

public interface TodoRepository {

	
	boolean addTask(Todo todo );
	boolean deleteTask(String todoId);
	boolean updateTask(Todo todo);
	List<Todo>getAllTodoList();
	List<Todo>getAllTodoListByStatus(String status);
	Todo getTodoById(String todoId);
}
