package com;

import java.util.Comparator;

public class SortStudentByAge implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getAge() - o2.getAge();
	}

}
