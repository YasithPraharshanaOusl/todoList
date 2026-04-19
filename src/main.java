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

        String date_regex = "^\\d{4}-\\d{1,2}-\\d{1,2}$";    // regular expression for get task time according to a format
        String time_regex = "^\\d{1,2}:\\d{1,2}";           // regular expression for get task time according to a format

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
//                    String taskDate = "";
                    System.out.print("Date [yyyy-mm-dd]:");
                    String taskDate = scanner.nextLine();



//                    String date_regex = "^\\d{4}-\\d{1,2}-\\d{1,2}$";

                    while(((taskDate.matches(date_regex)) && (dateCheck.date_rangeCheck(taskDate)))==false){   // repeat until user enter date according to correct format
                        System.out.println("Invalid date. Please use the correct format.");
                        System.out.print("Date [yyyy-mm-dd]:");
                        taskDate = scanner.nextLine();
                    }

//                    dateCheck.getdate_status(taskDate);

                    System.out.print("Time [hh:mm] :");
                    String taskTime = scanner.nextLine();

//                    String time_regex = "^\\d{1,2}:\\d{1,2}";


                    while (((taskTime.matches(time_regex)) && (dateCheck.time_rangeCheck(taskTime)))==false){  // repeat until user enter date according to correct format
                        System.out.println("Invalid time. Please use the correct format.");
                        System.out.print("Time [hh:mm] :");
                        taskTime = scanner.nextLine();
                    }

                    taskDate = dateCheck.DateCorrect(taskDate);   // call DataCorrect method to correct task data format
                    taskTime = dateCheck.TimeCorrect(taskTime);  // call TimeCorrect method to correct task time format

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
//                        System.out.println("   id     Date       Time      Task");
                        System.out.printf("%-2s %-6s %-12s %-6s %-10s %-10s%n","  ", "ID", " Date", "Time" ,"Status", "Task");



                        // Print rows
                        for (int i = 0; i < tasks.size(); i++) {
//                            System.out.println((i + 1) + ". " + tasks.get(i).taskid + "  " + tasks.get(i).date +dateCheck.getdate_status(tasks.get(i).date)+"  " + tasks.get(i).time + "  " + tasks.get(i).task);
                            System.out.printf("%-2s %-6s %-12s %-6s %-10s %-10s%n",(i + 1) + "." ,tasks.get(i).taskid ,tasks.get(i).date ,tasks.get(i).time , dateCheck.getdate_status(tasks.get(i).date) ,tasks.get(i).task);
                        }   //  use prinf to format output like a table content
                        System.out.println("------------------------------------------\n");
                    }
                break;

                case 3:
                    //Update Task
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks to update!\n");
                    } else {
                        System.out.printf("%-2s %-6s %-12s %-6s %-10s %-10s%n","  ", "ID", " Date", "Time" ,"Status", "Task");

                        // Print rows
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.printf("%-2s %-6s %-12s %-6s %-10s %-10s%n",(i + 1) + "." ,tasks.get(i).taskid ,tasks.get(i).date ,tasks.get(i).time , dateCheck.getdate_status(tasks.get(i).date) ,tasks.get(i).task);
                        }   //  use prinf to format output like a table content

                        System.out.println("------------------------------------------\n");

                        System.out.print("UPDATE | Enter Task id:");
                        String taskid = scanner.nextLine();
                        System.out.print("Select the field [d - date, t - time, c - task] :");
                        String select = scanner.nextLine();

//                        System.out.print("Enter New Data:");
//                        String data = scanner.nextLine();


                        String data  = "";

                        switch (select){
                            case "d":
                                System.out.print("Enter New Date: ");
                                data = scanner.nextLine();

//                                System.out.println(dateCheck.rangeCheck(data));
                                while (((data.matches(date_regex)) && (dateCheck.date_rangeCheck(data)))==false ){
                                    System.out.println("Invalid date. Please use the correct format.");
                                    System.out.print("Date [yyyy-mm-dd]:");
                                    data = scanner.nextLine();
                                }

                                break;


                            case "t":

                                System.out.print("Enter New time: ");
                                data = scanner.nextLine();

                                while (((data.matches(time_regex) && dateCheck.time_rangeCheck(data))==false)){
                                    System.out.println("Invalid time. Please use the correct format.");
                                    System.out.print("Time [hh:mm] :");
                                    data = scanner.nextLine();
                                }
                                break;

                            case"c":
                                System.out.print("Enter New Task: ");
                                data=scanner.nextLine();
                                break;

                            default:
                                System.out.println("Not a valid choice");
                        }

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

                        int delete_mode;
                        System.out.println("====================================");
                        System.out.println("||       --- DELETE MENU ---      ||");
                        System.out.println("||  [1] Single Task               ||");                // Delete task menu
                        System.out.println("||  [2] All Due Tasks             ||");
                        System.out.println("||  [3] All Tasks                 ||");
                        System.out.println("||  [4] Back                      ||");
                        System.out.println("||  [5] Exit                      ||");
                        System.out.println("====================================");
                        do {


//                            int delete_mode = Integer.parseInt(scanner.nextLine());
                            System.out.print("[*]Choose (1-5): ");
                            delete_mode = scanner.nextInt();
                            scanner.nextLine();

                            switch (delete_mode){
                                case 1:


                                    System.out.printf("%-6s %-12s %-6s %-10s %-10s%n", "ID", " Date", "Time" ,"Status", "Task");



                                    // Print rows
                                    for (int i = 0; i < tasks.size(); i++) {
//                            System.out.println((i + 1) + ". " + tasks.get(i).taskid + "  " + tasks.get(i).date +dateCheck.getdate_status(tasks.get(i).date)+"  " + tasks.get(i).time + "  " + tasks.get(i).task);
                                        System.out.printf("%-6s %-12s %-6s %-10s %-10s%n",tasks.get(i).taskid ,tasks.get(i).date ,tasks.get(i).time , dateCheck.getdate_status(tasks.get(i).date) ,tasks.get(i).task);
                                    }   //  use prinf to format output like a table content
                                    System.out.println("------------------------------------------\n");




                                    System.out.print("DELETE | Enter Task id :");
                                    String taskid = scanner.nextLine();
                                    fileMananger.deleteData(taskid);
                                    System.out.println("✓ Task Deleted : "+ taskid + "\n");

                                    tasks = fileMananger.readData();
                                    break;

                                case 2:
                                    System.out.println("Are you sure you want to delete all due tasks? (y/n): ");         // confirm want to delete or not
                                    String confimation_due = scanner.nextLine();

                                    for (int i = 0; i < tasks.size(); i++) {

                                        String current_tskid = (tasks.get(i).taskid);
                                        String curennt_date_status = (dateCheck.getdate_status(tasks.get(i).date));

                                        if (curennt_date_status.equals("Due")){
//                                            System.out.println(current_tskid+" "+curennt_date_status);

                                            if (confimation_due.equalsIgnoreCase("y")){
                                                fileMananger.deleteDuetasks(current_tskid);
//                                                tasks = fileMananger.readData();
//                                                System.out.println("✓ All Due Tasks Deleted ");

                                            }else if (confimation_due.equalsIgnoreCase("n")) {
                                                System.out.println("Tasks Not Deleted ");
                                                break;
                                            }else {
                                                System.out.println("Invalid Choice");
                                            }
                                        }
                                    }
                                    if (confimation_due.equalsIgnoreCase("y")){
                                        System.out.println("✓ All Due Tasks Deleted ");
                                        tasks = fileMananger.readData();
                                    }

                                    break;

                                case 3:

                                    System.out.println("Are you sure you want to delete all tasks? (y/n): ");
                                    String confimation = scanner.nextLine();

                                    if (confimation.equalsIgnoreCase("y")){
                                        fileMananger.deleteAllData();
                                        tasks = fileMananger.readData();
                                        System.out.println("✓ All Task Deleted ");

                                    }else if (confimation.equalsIgnoreCase("n")) {
                                        System.out.println("Tasks Not Deleted ");
                                        break;

                                    }else {
                                        System.out.println("Invalid Choice");
                                    }

                                    break;


                                case 4:

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


                                    break;


                                case 5:
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
                        }while (delete_mode!=4);





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
    

