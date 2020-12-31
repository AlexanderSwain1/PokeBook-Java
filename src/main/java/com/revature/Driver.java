package com.revature;

public class Driver {
	public static void main(String[] args) {
		try {
			  Class.forName("org.postgresql.Driver");
			  System.out.println("yes");
			  //on classpath
			} catch(ClassNotFoundException e) {
				System.out.println("no");
			  //not on classpath
			}
	}
}
