package com.niit.todochecklistmanagement.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.niit.todochecklistmanagement.model.Todo;

@Repository
@Transactional
public class TodoRepositoryImpl implements TodoRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addTask(Todo todo) {
		Session session=sessionFactory.getCurrentSession();
	    try{
		session.save(todo);
		return true;
	    }
	    catch(HibernateException e)
	    {
		return false;
	    }
	
	
	}

	public boolean deleteTask(String todoId) {
		Session sg=sessionFactory.getCurrentSession();
		
		sg.delete(getTodoById(todoId));
		return true;
	
	}

	public boolean updateTask(Todo todo) {
		
		Session session=sessionFactory.getCurrentSession();
	    try{
		session.update(todo);
		return true;
	    }
	    catch(HibernateException e)
	    {
		return false;
	    }
	
	}

	public List<Todo> getAllTodoList() {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Todo").list();
		} catch (HibernateException e) {
			
			e.printStackTrace();
			throw e;
		}

	}

	public Todo getTodoById(String todoId) {
		try {
			Query query=sessionFactory.getCurrentSession().createQuery("from Todo where todoId=:todoId");
			Todo task=(Todo)query.setParameter("todoId", todoId).getSingleResult();
			return task;
		}
			catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
		
	
	
	
	}

	public List<Todo> getAllTodoListByStatus(String status) {
		try {
			return sessionFactory.getCurrentSession().createQuery("from Todo where status=:st").setParameter("st",status).list();
			
		} catch (HibernateException e) {
			
			e.printStackTrace();
			throw e;
		}
}
	
	
	
	
	
	
	
	

}
