import java.util.ArrayList;
import java.util.List;

public class Team {
  
    public static int counter = 0;
    private int teamID;
    private int leader;
    private List<Integer> members = new ArrayList<>();

    private int projectNumber;
    private int taskNumber;

    public Team(){
        this.teamID = ++counter;
        this.leader = 0;
        this.members = null;
        this.projectNumber = 0;
        this.taskNumber = 0;
    }

    public Team(int leader, List<Integer> members, int projectN, int taskN){
        this.teamID = ++counter;
        this.leader = leader;
        this.members = members;
        this.projectNumber = projectN;
        this.taskNumber = taskN;

    }

    public int getLeader() {
        return leader;
    }
    public List<Integer> getMembers() {
        return members;
    }
    public int getProjectNumber() {
        return projectNumber;
    }
    public int getTaskNumber() {
        return taskNumber;
    }

    public void setLeader(int leader) {
        this.leader = leader;
    }

    public void assignToProject(int projectN){
        this.projectNumber = projectN;

    }

    public void assignToTask(int taskN){
        this.taskNumber = taskN;

    }

}
