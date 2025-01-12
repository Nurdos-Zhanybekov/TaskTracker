import java.util.ArrayList;

public class TaskInfo {
    private final int id;
    private String status;
    private final String description;
    private final String priority;
    private static ArrayList<Integer> lowPriority;
    private static ArrayList<Integer> mediumPriority;
    private static ArrayList<Integer> highPriority;
    private static ArrayList<Integer> completedList;
    private static ArrayList<Integer> pendingList;
    private static ArrayList<String> priorityList;
    private static ArrayList<Integer> allIDs;

    public TaskInfo(int id, String description, String priority, String status){
        this.id = id;
        this.status = status;
        this.description = description;
        this.priority = priority;
        lowPriority = new ArrayList<>();
        mediumPriority = new ArrayList<>();
        highPriority = new ArrayList<>();
        completedList = new ArrayList<>();
        pendingList = new ArrayList<>();
        priorityList = new ArrayList<>();
        allIDs = new ArrayList<>();

        allIDs.add(id);
        priorityList.add(priority);

        if(priority.equalsIgnoreCase("Low")){
            lowPriority.add(id);
        }else if(priority.equalsIgnoreCase("Medium")){
            mediumPriority.add(id);
        }else{
            highPriority.add(id);
        }

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

    public ArrayList<Integer> getLowPriority(){
        return lowPriority;
    }

    public ArrayList<Integer> getMediumPriority(){
        return mediumPriority;
    }

    public ArrayList<Integer> getHighPriority(){
        return highPriority;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
