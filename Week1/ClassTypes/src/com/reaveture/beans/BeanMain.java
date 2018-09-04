package com.reaveture.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.revature.compare.Student;
import com.revature.compare.StudentComparator;

public class BeanMain{

	public static void main(String[] args) {
		
		List<Bean> beanList= new ArrayList <Bean>();
		
		beanList.addAll(Arrays.asList(
				new Bean[] { 
							new Bean(2,"Black","Bush"),
							new Bean(1,"Pinto","Hentz"),
							new Bean(23,"Garbarnzo","Loco"),
							new Bean(67,"Pork'n Bean","Jimbo")
							}));

		for(Bean b: beanList)
		{
			System.out.println(b);
			
		}
		System.out.println("================================");
		System.out.println("Sort by Id: ");
		Collections.sort(beanList);
		for(Bean b: beanList)
		{
			System.out.println(b);
			
		}
		System.out.println("================================");
		Collections.sort(beanList, new BeanNameCompare());
		System.out.println("Sort by Name: ");
		for(Bean b: beanList)
		{
			System.out.println(b);
			
		}
		System.out.println("================================");
		Collections.sort(beanList, (arg0,arg1)
				->{ return arg0.getMake().compareTo(arg1.getMake());}
				);
		System.out.println("Sort by by Id Lambda: ");
		for(Bean s: beanList)
		{
			System.out.println(s);
			
		}
	}

	

}
