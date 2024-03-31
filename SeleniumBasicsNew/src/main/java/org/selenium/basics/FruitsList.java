package org.selenium.basics;

import java.util.ArrayList;

public class FruitsList 
{
	public void fruitsList()
	{
		ArrayList<String> al=new ArrayList<String>();
		al.add("Apple");
		al.add("Orange");
		al.add("Melon");
		al.add("Cherry");
		al.add("Mango");
		System.out.println(al);
	}
	public static void main(String[] args) 
	{
		FruitsList fn = new FruitsList();
		fn.fruitsList();
	}
}
