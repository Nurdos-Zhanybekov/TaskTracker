import java.util.ArrayList;
import java.util.List;

public class TaskManagement {
    private final ArrayList<TaskInfo> taskInfoList;
    private static int countTasks;
    private static int countCompletedTasks;
    private static int countPendingTasks;

    public TaskManagement(ArrayList<TaskInfo> taskInfoList){
        this.taskInfoList = taskInfoList;
    }

    public void updateStatus(int id){
        for(TaskInfo taskInfo : taskInfoList) {
            if (taskInfo.getStatus().equalsIgnoreCase("Pending") && id == taskInfo.getId()) {
                taskInfo.setStatus("Completed");
                taskInfo.getCompletedList().add(taskInfo.getId());
                taskInfo.getPendingList().remove((Integer) taskInfo.getId());
            }else if(taskInfo.getStatus().equalsIgnoreCase("Completed") && id == taskInfo.getId()) {
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
                if (i == id && i == taskInfo.getId()) {
                    taskInfoList.remove(taskInfo);
                    break;
                }
            }
        }
    }

    public void prioritySort(){
        for(TaskInfo taskInfo : taskInfoList){
            for(String priority : taskInfo.getPriorityList()){
                if(priority.equalsIgnoreCase("High") && priority.equalsIgnoreCase(taskInfo.getPriority())){
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }

        for(TaskInfo taskInfo : taskInfoList) {
            for (String priority : taskInfo.getPriorityList()) {
                if (priority.equalsIgnoreCase("Medium") && priority.equalsIgnoreCase(taskInfo.getPriority())) {
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }

        for(TaskInfo taskInfo : taskInfoList) {
            for (String priority : taskInfo.getPriorityList()) {
                if (priority.equalsIgnoreCase("Low") && priority.equalsIgnoreCase(taskInfo.getPriority())) {
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }
    }

    public void statusSort(){
        for(TaskInfo taskInfo : taskInfoList){
            for(int i : taskInfo.getPendingList()){
                if(i == taskInfo.getId()){
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }

        for(TaskInfo taskInfo : taskInfoList){
            for(int i : taskInfo.getCompletedList()){
                if(i == taskInfo.getId()){
                    taskInfo.getDetails();
                    System.out.println();
                    break;
                }
            }
        }
    }

    public void displayAmountTasks(){
        for(TaskInfo taskInfo : taskInfoList){
            countTasks++;
        }

        System.out.println("Amount of Tasks: " + countTasks);
    }

    public void displayAmountCompletedOrPendingTasks(){
        for(TaskInfo taskInfo : taskInfoList){
            for(int i : taskInfo.getCompletedList()){
                if(i == taskInfo.getId()){
                    countCompletedTasks++;
                    break;
                }
            }
        }

        for(TaskInfo taskInfo : taskInfoList){
            for(int i : taskInfo.getPendingList()){
                if(i == taskInfo.getId()){
                    countPendingTasks++;
                    break;
                }
            }
        }

        System.out.println("Amount of Completed Tasks: " + countCompletedTasks);
        System.out.println("Amount of Pending Tasks: " + countPendingTasks);
    }

    public int countPriority(List<TaskInfo> taskInfos, String priority){
        if(taskInfos.isEmpty()) return 0;

        TaskInfo firstTaskInfo = taskInfos.getFirst();
        int count = firstTaskInfo.getPriority().equalsIgnoreCase(priority) ? 1 : 0;
        return count + countPriority(taskInfos.subList(1, taskInfos.size()), priority);
    }
}
