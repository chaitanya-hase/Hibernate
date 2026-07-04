package com.Hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentInfo")
public class Student {
	
	@jakarta.persistence.Id
	private int Id;
	private String Name;
	private int marks;
	
	public Student() {
		
	}
	
    public Student(int Id, String Name, int marks) {
        this.Id = Id;
        this.Name = Name;
        this.marks = marks;
    }
    
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", Name=" + Name + ", marks=" + marks + "]";
	}

	
	
	
	
	
}
