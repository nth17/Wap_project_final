package com.ethioProject.Bean;

import java.time.LocalDate;

public class Task {
	private int TaskId;
	private String TaskName;
	private String TaskDescription;
	
	private Priority TaskPriority;
	private String Catagory;
	private boolean Completed;
	private LocalDate DueDate;
	private User CurrentDeveloper;
	private Team CurrentTeam;
	public int getTaskId() {
		return TaskId;
	}
	public void setTaskId(int taskId) {
		TaskId = taskId;
	}
	public String getTaskName() {
		return TaskName;
	}
	public void setTaskName(String taskName) {
		TaskName = taskName;
	}
	public String getTaskDescription() {
		return TaskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		TaskDescription = taskDescription;
	}
	public Priority getTaskPriority() {
		return TaskPriority;
	}
	public void setTaskPriority(Priority taskPriority) {
		TaskPriority = taskPriority;
	}
	public String getCatagory() {
		return Catagory;
	}
	public void setCatagory(String catagory) {
		Catagory = catagory;
	}
	public boolean isCompleted() {
		return Completed;
	}
	public void setCompleted(boolean completed) {
		Completed = completed;
	}
	public LocalDate getDueDate() {
		return DueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		DueDate = dueDate;
	}
	public User getCurrentDeveloper() {
		return CurrentDeveloper;
	}
	public void setCurrentDeveloper(User currentDeveloper) {
		CurrentDeveloper = currentDeveloper;
	}
	public Team getCurrentTeam() {
		return CurrentTeam;
	}
	public void setCurrentTeam(Team currentTeam) {
		CurrentTeam = currentTeam;
	}
	
	
}
