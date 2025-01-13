import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TaskInfo> taskInfos = new ArrayList<>();
        TaskInfo taskInfo = new TaskInfo(12, "fdsafdas", "Medium", "Pending");
        TaskInfo taskInfo1 = new TaskInfo(13, "fdsafd", "High", "Completed");
        TaskInfo taskInfo2 = new TaskInfo(14, "fdsafdasf", "High", "Pending");
        taskInfos.add(taskInfo);
        taskInfos.add(taskInfo1);
        taskInfos.add(taskInfo2);

        TaskManagement taskManagement = new TaskManagement(taskInfos);
        taskManagement.displayAmountTasks();
        taskManagement.displayAmountCompletedOrPendingTasks();
        System.out.println(taskManagement.countPriority(taskInfos, "High"));

    }
}