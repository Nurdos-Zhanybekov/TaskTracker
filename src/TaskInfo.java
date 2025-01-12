import java.util.ArrayList;

public class TaskInfo {
    private final int id;
    private String status;
    private final String description;
    private final String priority;
    private static final ArrayList<Integer> completedList = new ArrayList<>();
    private static final ArrayList<Integer> pendingList = new ArrayList<>();
    private static final ArrayList<String> priorityList = new ArrayList<>();
    private static final ArrayList<Integer> allIDs = new ArrayList<>();

    public TaskInfo(int id, String description, String priority, String status){
        this.id = id;
        this.status = status;
        this.description = description;
        this.priority = priority;

        allIDs.add(id);
        priorityList.add(priority);

        if(status.equalsIgnoreCase("Completed")){
            completedList.add(id);
        }else{
            pendingList.add(id);
        }
    }

    public String toString(){
        return "ID: " + id + "\n" +
                "Description: " + description + "\n" +
                "Priority: " + priority + "\n" +
                "Status: " + status;
    }

    public void getDetails(){
        System.out.println(this);
    }

    public String getStatus(){
        return status;
    }

    public int getId(){
        return id;
    }

    public String getPriority(){
        return priority;
    }

    public ArrayList<Integer> getCompletedList(){
        return completedList;
    }

    public ArrayList<Integer> getPendingList(){
        return pendingList;
    }

    public ArrayList<Integer> getAllIDs(){
        return allIDs;
    }

    public ArrayList<String> getPriorityList(){
        return priorityList;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
