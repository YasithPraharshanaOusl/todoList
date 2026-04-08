import java.util.ArrayList;
import java.util.Scanner;

public class main {
    // Global variables
    static ArrayList<dataStructure> tasks = fileMananger.readData();
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
              [*] you can add:view:update:delete:> tasks
              [*] easy to manage your day to day your work
              [*] choose the about[5] for more information
            
            """;
        System.out.println(icon);
        
        int choice;

        // Display menu
        System.out.println("====================================");
        System.out.println("||          --- MENU ---          ||");
        System.out.println("||        [1] Add Task            ||");
        System.out.println("||        [2] View Tasks          ||");
        System.out.println("||        [3] Update Tasks        ||");
        System.out.println("||        [4] Delete Task         ||");
        System.out.println("||        [5] Help                ||");
        System.out.println("||        [6] Credits             ||");
        System.out.println("||        [7] About               ||");
        System.out.println("||        [8] Exit                ||");
        System.out.println("====================================");
        
        do {

            System.out.print("[*]Choose (1-8): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer


            // Handle user choice
            switch (choice) {
                case 1 :
                    // Add task
                    System.out.print("ADD | Enter task: ");
                    String task = scanner.nextLine();
                    System.out.print("Date [yyyy-mm-dd]:");
                    String taskDate = scanner.nextLine();
                    System.out.print("Time [hh:mm] :");
                    String taskTime = scanner.nextLine();

                    tasks.add(new dataStructure(fileMananger.idGen(),task,taskDate,taskTime));
                    fileMananger.writeData(new dataStructure(fileMananger.idGen(),task,taskDate,taskTime));


                    System.out.println("✓ Task added!\n");
                break;
                
                case 2:
                    // View tasks
                    System.out.println("\n--- YOUR TASKS ---");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet!\n");
                    } else {
                        System.out.println("   id     Date        Time      Task");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i).taskid + "  " + tasks.get(i).date + "  " + tasks.get(i).time + "  " + tasks.get(i).task);
                        }
                        System.out.println("------------------------------------------\n");
                    }
                break;

                case 3:
                    //Update Task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to update!\n");
                    } else {
                        System.out.println("\n   id     Date        Time      Task");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i).taskid + "  " + tasks.get(i).date + "  " + tasks.get(i).time + "  " + tasks.get(i).task);
                        }
                        System.out.println("------------------------------------------\n");

                        System.out.print("UPDATE | Enter Task id:");
                        String taskid = scanner.nextLine();
                        System.out.print("Select the field [d - date, t - time, c - task] :");
                        String select = scanner.nextLine();
                        System.out.print("Enter Task rename:");
                        String data = scanner.nextLine();
                        fileMananger.updateData(taskid, data, select);
                        tasks = fileMananger.readData();

                        System.out.println("✓ Task Updated ['"+ taskid + "']\n");
                    }

                break;
                
                case 4:
                    // Delete task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to delete!\n");
                    } else {
                        System.out.print("DELETE | Enter Task id :");
                        String taskid = scanner.nextLine();
                        fileMananger.deleteData(taskid);
                        System.out.println("✓ Task Deleted : "+ taskid + "\n");

                        tasks = fileMananger.readData();
                    }
                break;
                
                case 5:
                    // Exit
                    System.out.println("\n");
                    System.out.println(info.Help());
                    System.out.println("\n");
                break;

                case 6:
                    // Exit
                    System.out.println("\n------ CREDITS -------");
                    info.animativePrint(info.Credit(),100);
                    System.out.println("\n");
                    break;

                case 7:
                    // Exit
                    System.out.println("\n");
                    System.out.println(info.About());
                    break;
                

                case 8:
                    // Exit
                    System.out.println("\nGoodbye!");

                    info.animativePrint("...",330);
                    System.out.println("\nShutDown :-)");

                    System.exit(0);
                    break;

                default:
                    // Invalid choice
                    System.out.println("Invalid choice! Try again.");
            }
            
        } while (choice != 8);
        
        scanner.close();
    }
}
    

