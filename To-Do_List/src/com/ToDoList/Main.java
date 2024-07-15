package com.ToDoList;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ToDo_List list = new ToDo_List();

		while(true) {

			System.out.println("Enter To: (add/remove/print/exit:)");
			String command = sc.nextLine();

			if (command.equalsIgnoreCase("add")) {
				System.out.println("Enter the Task");
				String task = sc.nextLine();
				list.addTask(task);
			} else if (command.equalsIgnoreCase("remove")) {
				System.out.println("enter the index to remove");
				int index = sc.nextInt();
				sc.nextLine();
				list.removeTask(index);
			} else if (command.equalsIgnoreCase("print")) {
				list.printTask();
			} else if (command.equalsIgnoreCase("exit")) {
				break;
			} else {
				System.out.println("Invalid command");
			}
		}

	}

}
