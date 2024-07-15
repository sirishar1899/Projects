package com.ToDoList;

import java.util.ArrayList;

public class ToDo_List {
	
    private	ArrayList<String> todoTask;

	public ToDo_List() {
	    todoTask = new ArrayList<String>();
	}
    
    
	public void addTask(String task)
	{
		todoTask.add(task);
	}
	public void removeTask(int index)
	{
		todoTask.remove(index);
	}
	public void printTask()
	{
		System.out.println("Tasks");
		for(int i=0; i<todoTask.size(); i++)
		{
			System.out.println(i+":"+ todoTask.get(i));
		}
	}
	
	
	

}
