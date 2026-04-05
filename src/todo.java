import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class todo { 
    // Global variables
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
    String icon = """
            ********************************************
            * ====   =   ==     =    PROJECT TODO LIST *
            *  ||   | |  |  |  | |   DATE: 2024        *
            *  ||    =   ==     =                      *
            ********************************************
              [*] java programme
              [*] team work
              [*] use array list to store data
              [*] you can add:view:delete:> tasks
              [*] easy to manage your day to day your work
            
            """;
        System.out.println(icon);
        
        int choice;
        
        do {
            // Display menu
            System.out.println("====================================");
            System.out.println("||          --- MENU ---          ||");
            System.out.println("||        [1] Add Task            ||");
            System.out.println("||        [2] View Tasks          ||");
            System.out.println("||        [3] Delete Task         ||");
            System.out.println("||        [4] credit              ||");
            System.out.println("||        [5] Exit                ||");
            System.out.println("====================================");
            System.out.print("[*]Choose (1-4): ");
            
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer
            
            // Handle user choice
            if (choice == 1) {
                // Add task
                System.out.print("Enter task: ");
                String task = scanner.nextLine();

                try{
                    FileWriter myfile = new FileWriter("src/todo.txt");
                    myfile.write(task);
                    myfile.close();
                }catch (IOException e){
                    System.out.println("error");
                    e.printStackTrace();
                }

                tasks.add(task);
                System.out.println("✓ Task added!");
                
            } else if (choice == 2) {
                // View tasks
                System.out.println("\n--- YOUR TASKS ---");
                if (tasks.isEmpty()) {
                    System.out.println("No tasks yet!");
                } else {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                }
                
            } else if (choice == 3) {
                // Delete task
                if (tasks.isEmpty()) {
                    System.out.println("No tasks to delete!");
                } else {
                    System.out.println("\n--- YOUR TASKS ---");
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }
                    System.out.print("Enter task number to delete: ");
                    int num = scanner.nextInt();
                    
                    if (num >= 1 && num <= tasks.size()) {
                        tasks.remove(num - 1);
                        System.out.println("✓ Task deleted!");
                    } else {
                        System.out.println("Invalid number!");
                    }
                }
                
            } else if (choice == 4) {
                // Exit
                System.out.println("credit");
                
            }
            else if (choice == 5) {
                // Exit
                System.out.println("\nGoodbye!");

            } else {
                // Invalid choice
                System.out.println("Invalid choice! Try again.");
            }
            
        } while (choice != 5);
        
        scanner.close();
    }
}
    

