import java.util.ArrayList;

public class TaskManagement {
    private TaskInfo taskInfo;

    public TaskManagement(TaskInfo taskInfo){
        this.taskInfo = taskInfo;
    }

    public void updateStatus(){
        if(taskInfo.getStatus().equalsIgnoreCase("pending")){
            taskInfo.setStatus("Completed");
            taskInfo.getCompletedList().add(taskInfo.getId());
            taskInfo.getPendingList().remove(taskInfo.getId());
        }else{
            taskInfo.setStatus("Pending");
            taskInfo.getCompletedList().remove(taskInfo.getId());
            taskInfo.getPendingList().add(taskInfo.getId());
        }
    }

    public void searchID(int id){
        for(int i : taskInfo.getAllIDs()){
            if(i == id){
                taskInfo.getDetails();
                break;
            }
        }
    }

    public void searchPriority(String priority){
        for(String priority1 : taskInfo.getPriorityList()) {
            if(priority1.equalsIgnoreCase(priority)){
                taskInfo.getDetails();
            }
        }
    }

    public void deleteTask(int id){
        for(int i : taskInfo.getAllIDs()){
            if(i == id){
                taskInfo.getAllIDs().remove(i);
            }
        }
    }
}
