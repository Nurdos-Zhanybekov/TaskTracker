import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TaskInfo> taskInfos = new ArrayList<>();
        TaskInfo taskInfo = new TaskInfo(12, "fdsafdas", "High", "Pending");
        TaskInfo taskInfo1 = new TaskInfo(13, "fdsafd", "High", "Completed");
        taskInfos.add(taskInfo);
        taskInfos.add(taskInfo1);

        TaskManagement taskManagement = new TaskManagement(taskInfos);
        taskManagement.updateStatus(12);
        taskManagement.searchPriority("High");

    }
}