package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class StudentManagementSystemImpl implements StudentManagementsystem{
	
	Scanner scan = new Scanner(System.in);
	
	HashMap<String, Student> db = new HashMap<String, Student>();

	//LinkedList<Student> d1=new LinkedList<>();
	
	@Override
	public void addStudent() {
		
		//logic for adding student record into DB
		
		System.out.println("Enter Id,Name ,Age ,Marks");
		String id =scan.next();
		String name=scan.next();
		int age = scan.nextInt();
		int marks=scan.nextInt();
		
		
		Student std1= new Student(id,name,age,marks);
		db.put(std1.getId(),std1);
		//db.put(std.getId(),new Student(id,name,age,marks));
	   //	db.put(std.getId(),new Student(scan.next(),scan.next());
		//scan.nextInt(),scan.nextInt();
		
		//d1.add(std1);
		System.out.println("STUDENT RECORD ADDED SUCCEDDFULLY");
		
	}

	@Override
	public void updateStudent() {
		// LOGIC FOR UPDATING STUDENT RECORD FROM DB
		System.out.println("Enter Student Id");
		String id=scan.next();
		
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Name\n2: Update Age \n3: Update Marks");
			System.out.println("Enter Choice");
			int choice = scan.nextInt();
			switch(choice) {
			case 1: 
				System.out.println("Enter Name");
				String name= scan.next();
				std.setName(name);
				break;
				
			case 2:
				System.out.println("Enter Age");
				String age=scan.next();
				std.setName(age);
				break;
				
			case 3:
				System.out.println("Enter Marks");
				int marks = scan.nextInt();
				std.setMarks(marks);
				break;
				
			default:
				System.out.println("Invalid choice");
			}
		}
		else {
			System.out.println("Id is Invalid");
		}
	}

	@Override
	public void deleteStudent() {
		// logic for deleting student record from DB
		
		System.out.println("ENTER STUDENT ID");
		String id = scan.next();
		
		if(db.containsKey(id))
		{
			System.out.println("Student record present");
			db.remove(id);
			System.out.println("Student Record Deleted");
		}else {
			System.out.println("Student record not Present");
		}
		
	}

	@Override
	public void deleteAllstudents() {
		// logic for deleting all the student records from DB
		
		db.clear();
		System.out.println("All student Record deleted");
		
	}

	@Override
	public void displayAllstudents() {
	   
		Set<String> s= db.keySet();
		Iterator<String> i = s.iterator();
		while(i.hasNext()) {
			String id=i.next();
			Student std= db.get(id);
			System.out.println("Student Details");
			System.out.println("Id :"+std);
		}
		
	}

	@Override
	public void sortStudent() {
		// logic for sorting all the student records from DB
		ArrayList<Student> l =new ArrayList<Student>();
		Set<String> s= db.keySet();
		Iterator<String> i =s.iterator();
		while(i.hasNext())
		{
			String id = i.next();
			Student std= db.get(id);
			l.add(std);
		}
		System.out.println("Sort Student");
		System.out.println("1:By Id\n2: By Name\n3:By age\n4: By Marks");
		System.out.println("Enter Choice");
		int choice =scan.nextInt();
		
		switch(choice) {
		case 1: 
			System.out.println("Sorting based on ID");
			Collections.sort(l,new SortStudentById());
			for(Student s1 : l) {
				System.out.println(s1);
			}
			break;
			
		case 2:
			System.out.println("Sorting based on Name");
			Collections.sort(l,new SortStudentByName());
			for(Student s1 :l) {
				System.out.println(s1);
			}
			break;
		
		case 3:
			System.out.println("Sorting based on Age");
			Collections.sort(l,new SortStudentByAge());
			for(Student s1: l) {
				System.out.println(s1);
			}
		case 4:
			System.out.println("Sorting based on marks");
			Collections.sort(l,new SortStudentByMarks());
			for(Student s1 :l) {
				System.out.println(s1);
			}
		
		default:
			System.out.println("Invalid Choice");
		}
	}

	@Override
	public void displaystudent() {
		// logic for displaying one student record from DB
		
		System.out.println("Enter Student id");
		String id =scan.next();
		
		if(db.containsKey(id))
		{
			System.out.println("Student Record Available");
			
			Student std=db.get(id);
			
			System.out.println("Student Details");
			System.out.println("Id : "+std.getId());
			System.out.println("Name : "+std.getName());
			System.out.println("Age : "+std.getAge());
			System.out.println("Marks : "+std.getMarks());
			System.out.println("-----------------------------------");
		}else {
			System.out.println("Student record Not Available");
		}
		
	}

}
