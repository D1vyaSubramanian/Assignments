package org.student;

import org.department.Department;

public class Student extends Department{
	
	public void studentName() {
		System.out.println("The student name is Divya");
	}
	public void studentDept() {
		System.out.println("The student department is ECE");
	}
	public void studentID() {
		System.out.println("The student ID is 11ECR032");
	}
	public static void main(String[] args) {
		Student obj=new Student();
		System.out.println("\nPrinting College Details:");
		obj.collegecode();
		obj.collegeName();
		obj.collegeRank();
		System.out.println("\nPrinting Department details:");
		obj.deptName();
		System.out.println("\nPrinting Student Details:");
		obj.studentDept();
		obj.studentID();
		obj.studentName();
	}

}
