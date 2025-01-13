import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<TaskInfo> taskInfos = new ArrayList<>();
        TaskManagement taskManagement = new TaskManagement(taskInfos);

        boolean exit = false;

        while(!exit){
            System.out.println("1. Add Task");
            System.out.println("2. Update Task Status");
            System.out.println("3. Search Task by ID");
            System.out.println("4. Search Tasks by priority");
            System.out.println("5. Delete Task");
            System.out.println("6. Sort by priority");
            System.out.println("7. Sort by status");
            System.out.println("8. Display Amount of Tasks");
            System.out.println("9. Display Amount of Completed and Pending Tasks");
            System.out.println("10. Display Amount of Tasks of specific priority");

            int choose = scanner.nextInt();
            scanner.nextLine();

            String enterPriority;

            switch(choose){
                case 1:
                    System.out.print("Enter ID: ");
                    int enterId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Description: ");
                    String enterDescription = scanner.nextLine();
                    System.out.println("Enter priority: ");
                    enterPriority = scanner.nextLine();
                    System.out.println("Enter status: ");
                    String enterStatus = scanner.nextLine();

                    taskInfos.add(new TaskInfo(enterId, enterDescription, enterPriority, enterStatus));
                    scanner.nextLine();
                    break;

                case 2:
                    System.out.println("Enter Task ID");
                    int enterId1 = scanner.nextInt();
                    taskManagement.updateStatus(enterId1);
                    System.out.println("Status Changed Successfully");
                    scanner.nextLine();
                    break;

                case 3:
                    System.out.println("Enter Task ID: ");
                    int enterId2 = scanner.nextInt();
                    taskManagement.searchID(enterId2);
                    scanner.nextLine();
                    break;

                case 4:
                    System.out.println("Enter priority of task: ");
                    enterPriority = scanner.nextLine();
                    taskManagement.searchPriority(enterPriority);
                    scanner.nextLine();
                    break;

                case 5:
                    System.out.println("Enter Task ID: ");
                    int enterId3 = scanner.nextInt();
                    taskManagement.deleteTask(enterId3);
                    System.out.println("Task Deleted Successfully");
                    scanner.nextLine();
                    break;

                case 6:
                    System.out.println("Tasks sorted by priority");
                    taskManagement.prioritySort();
                    scanner.nextLine();
                    break;

                case 7:
                    System.out.println("Tasks sorted by status");
                    taskManagement.statusSort();
                    scanner.nextLine();
                    break;

                case 8:
                    taskManagement.displayAmountTasks();
                    scanner.nextLine();
                    break;

                case 9:
                    taskManagement.displayAmountCompletedOrPendingTasks();
                    scanner.nextLine();
                    break;

                case 10:
                    System.out.println("Enter task priority: ");
                    enterPriority = scanner.nextLine();
                    int tasksAmount = taskManagement.countPriority(taskInfos, enterPriority);
                    System.out.println("Amount of " + enterPriority + " tasks: " + tasksAmount);
                    scanner.nextLine();
                    break;

                case 11:
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid Input");
                    scanner.nextLine();
            }
        }

    }
}