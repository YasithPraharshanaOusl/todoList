import java.io.Serializable;

public class dataStructure implements Serializable {
    String taskid;
    String task;    // ID එකක්
    String date;         // නම
    String time;            // වයස

    public dataStructure(String taskid, String task, String date, String time) {

        this.taskid = taskid;
        this.task = task;
        this.date = date;
        this.time = time;
    }
}