package com.niit.todochecklistmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.todochecklistmanagement.model.Todo;
import com.niit.todochecklistmanagement.repository.TodoRepository;

@Controller
public class TodoListCrudController {

	@Autowired
	private TodoRepository todoRepository;
	
	@RequestMapping("/todo")
	public String todoPage(Model model)
	{
	
		model.addAttribute("todo",new Todo());
		return "todo";
	}
	
	
	@RequestMapping(value="/addTask",method=RequestMethod.POST)
	public String addTask(@ModelAttribute Todo todo,Model model)
	{
		if(todo.getTodoId().equals(""))
		{
	todoRepository.addTask(todo);
	List<Todo>taskList=todoRepository.getAllTodoList();
	model.addAttribute("taskList",taskList);
		}
		else
		{
			
			todoRepository.updateTask(todo);
		}
	return "todo";
	}
	
	
	@RequestMapping("/updateTask/{todoId}")
		public String updateTask(@PathVariable() String todoId,Model model){
		model.addAttribute("todo",todoRepository.getTodoById(todoId));
		model.addAttribute("taskList",todoRepository.getAllTodoList());
		
		return "todo";
	}
	
	
	@RequestMapping("/deleteTask/{todoId}")
	public String deleteTask(@PathVariable("todoId") String todoId,Model model)
		{
			todoRepository.deleteTask(todoId);
			
		return "redirect:/todo";
		}
	
	
	@RequestMapping("/status/{st}")
	public String statusTask(@ModelAttribute("st") Todo todo,Model model)
	{
	model.addAttribute("statusList",todoRepository.getAllTodoListByStatus(todo.getStatus()));
	return "todo";
	}
	
	
	
	
}
