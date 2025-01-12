import java.util.ArrayList;

public class TaskManagement {
    private final ArrayList<TaskInfo> taskInfoList;

    public TaskManagement(ArrayList<TaskInfo> taskInfoList){
        this.taskInfoList = taskInfoList;
    }

    public void updateStatus(int id){
        for(TaskInfo taskInfo : taskInfoList) {
            if (taskInfo.getStatus().equalsIgnoreCase("Pending")) {
                taskInfo.setStatus("Completed");
                taskInfo.getCompletedList().add(taskInfo.getId());
                taskInfo.getPendingList().remove((Integer) taskInfo.getId());
            }else if(taskInfo.getStatus().equalsIgnoreCase("Completed")) {
                taskInfo.setStatus("Pending");
                taskInfo.getCompletedList().remove((Integer) taskInfo.getId());
                taskInfo.getPendingList().add(taskInfo.getId());
            }
        }
    }

    public void searchID(int id){
        for(TaskInfo taskInfo : taskInfoList) {
            for (int i : taskInfo.getAllIDs()) {
                if (i == taskInfo.getId() && i == id) {
                    taskInfo.getDetails();
                    break;
                }
            }
        }
    }

    public void searchPriority(String priority){
        for(TaskInfo taskInfo : taskInfoList) {
            for (String priority1 : taskInfo.getPriorityList()) {
                if (priority1.equalsIgnoreCase(priority) && priority.equalsIgnoreCase(taskInfo.getPriority())) {
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }
    }

    public void deleteTask(int id){
        for(TaskInfo taskInfo : taskInfoList) {
            for (int i : taskInfo.getAllIDs()) {
                if (i == id) {
                    taskInfo.getAllIDs().remove(i);
                }
            }
        }
    }
}
