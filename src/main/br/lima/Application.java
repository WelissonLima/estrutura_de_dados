package main.br.lima;

import java.util.List;
import java.util.Scanner;

import main.br.lima.model.Queue;
import main.br.lima.model.Stack;

public class Application {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int option = 0;
		
		System.out.println("****************************************");
		System.out.println("**********                    **********");
		System.out.println("**********        MENU        **********");
		System.out.println("**********                    **********");
		System.out.println("****************************************");
		System.out.println("**********       OPTIONS      **********");
		System.out.println("**********      1 - STACK     **********");
		System.out.println("**********      2 - QUEUE     **********");
		System.out.println("****************************************");

		System.out.print("\n Option: ");
		option = scanner.nextInt();
		
		while (option != 1 && option != 2) {
			System.out.print("\n Option: ");
			option = scanner.nextInt();			
		}
		
		if(option == 1) {
			stack();
		}else {
			queue();
		}
	}
	
	private static void stack() {
		Integer option = 0, size = 0;
		
		System.out.println();
		System.out.println("****************************************");
		System.out.println("**********                    **********");
		System.out.println("**********       STACK        **********");
		System.out.println("**********                    **********");
		System.out.println("****************************************");
		
		System.out.print("\n Stack size: ");
		size = scanner.nextInt();
		scanner.nextLine();
		
		Stack<Object> stack = new Stack<Object>(size);		

		options();

		while (true) {
			System.out.print("\n Option: ");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 0: {
					System.out.println("\n\tEXITNG...");
					return;
				}
				case 1: {
					String input = "";
					
					System.out.print("\n\tAdd Element: ");
					input = scanner.nextLine();
					
					try {
						stack.offer(input);						
						System.out.println("\n\tStatus operation: Success");
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					
					break;
				}
				case 2: {
					try {
						Object output = stack.pop();
						System.out.println("\n\tElement pop: " + output);
						System.out.println("\tStatus operation: Success");						
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					break;
				}
				case 3: {
					try {
						Object output = stack.peek();
						System.out.println("\n\tElement peek: " + output);
						System.out.println("\tStatus operation: Success");		
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					break;
				}
				case 4: {
					System.out.println("\n\tStack size: " + stack.size());
					break;
				}
				case 5: {
					List<Object> listElements = stack.getElements();
					
					if(listElements.isEmpty()) {
						System.out.println("\n\tStack : []");
					} else {
						System.out.print("\n\tStack : [ ");
						
						for (int i=0; i<listElements.size(); i++) {
							System.out.print(listElements.get(i));
							
							if(i+1 != listElements.size()) {
								System.out.print(", ");
							}else {
								System.out.println(" ]");
							}
						}
					}
					
					break;
				}
				case 6: {
					System.out.println("\n\tStack is empty: " + stack.empty());
					break;
				}
				default:{
					System.out.println("\n\tInvalid option!");
					break;
				}
			}
		}
	}
	
	private static void queue() {
		Integer option = 0, size = 0;
		
		System.out.println();
		System.out.println("****************************************");
		System.out.println("**********                    **********");
		System.out.println("**********       QUEUE        **********");
		System.out.println("**********                    **********");
		System.out.println("****************************************");
		
		System.out.print("\n Queue size: ");
		size = scanner.nextInt();
		scanner.nextLine();
		
		Queue<Object> queue = new Queue<Object>(size);		

		options();
		
		while (true) {
			System.out.print("\n Option: ");
			option = scanner.nextInt();
			scanner.nextLine();
			
			switch (option) {
				case 0:{
					System.out.println("\n\tEXITNG...");
					return;
				}
				case 1: {
					String input = "";
					
					System.out.print("\n\tAdd Element: ");
					input = scanner.nextLine();
					
					try {
						queue.offer(input);						
						System.out.println("\n\tStatus operation: Success");
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					
					break;
				}
				case 2: {
					try {
						Object output = queue.pop();
						System.out.println("\n\tElement pop: " + output);
						System.out.println("\tStatus operation: Success");						
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					break;
				}
				case 3: {
					try {
						Object output = queue.peek();
						System.out.println("\n\tElement peek: " + output);
						System.out.println("\tStatus operation: Success");		
					} catch (Exception e) {
						System.out.println("\n\tStatus operation: " + e.getMessage());
					}
					break;
				}
				case 4: {
					System.out.println("\n\tQueue size: " + queue.size());
					break;
				}
				case 5: {
					List<Object> listElements = queue.getElements();
					
					if(listElements.isEmpty()) {
						System.out.println("\n\tQueue : []");
					} else {
						System.out.print("\n\tQueue : [ ");
						
						for (int i=0; i<listElements.size(); i++) {
							System.out.print(listElements.get(i));
							
							if(i+1 != listElements.size()) {
								System.out.print(", ");
							}else {
								System.out.println(" ]");
							}
						}
					}
					
					break;
				}
				case 6: {
					System.out.println("\n\tQueue is empty: " + queue.empty());
					break;
				}
				default:{
					System.out.println("\n\tInvalid option!");
					break;
				}
			}
		}
	}

	private static void options() {
		System.out.println();
		System.out.println("****************************************");
		System.out.println("**********      OPTIONS       **********");
		System.out.println("**********      1 - ADD       **********");
		System.out.println("**********      2 - POP       **********");
		System.out.println("**********      3 - PEEK      **********");
		System.out.println("**********      4 - SIZE      **********");
		System.out.println("**********      5 - SHOW      **********");
		System.out.println("**********      6 - isEmpty   **********");
		System.out.println("**********      0 - EXIT      **********");
		System.out.println("****************************************");
		System.out.println();
	}
}
