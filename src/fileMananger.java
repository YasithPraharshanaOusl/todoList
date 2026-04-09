import java.io.*;
import java.util.ArrayList;

public class fileMananger extends ArrayList<dataStructure> {

    public static ArrayList<dataStructure> readData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/todoDB.dat"))) {
            return (ArrayList<dataStructure>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();

        }
    }

    public static void writeData(dataStructure tasks) {
        ArrayList<dataStructure> list = fileMananger.readData();

        list.add(tasks);
        saveToFile(list);
    }

    public static void updateData(String id, String data, String select) {
        ArrayList<dataStructure> list = readData();

        for (int i = 0; i < list.size(); i++) {
            dataStructure d = list.get(i);

            if (d.taskid.equals(id)) {
                switch (select) {
                    case "d":
                        d.date = data;
                        break;
                    case "t":
                        d.time = data;
                        break;
                    case "c":
                        d.task = data;
                        break;
                }
                break;
            }
        }
        saveToFile(list);
    }

    public static void deleteData(String id) {
        ArrayList<dataStructure> list = readData();

        for (int i = 0; i < list.size(); i++) {
            dataStructure currentItem = list.get(i);

            if (currentItem.taskid.equals(id)) {
                list.remove(i);
                break;
            }
        }
        saveToFile(list);
    }


    public static void deleteAllData() {
        ArrayList<dataStructure> list = readData();       //  this method delete all task data and clear ArrayList
        list.clear();

        saveToFile(list);
    }



    public static void deleteDuetasks(String id){
                                                        // this method delete all due status tasks
        ArrayList<dataStructure> list = readData();

        for (int i = 0; i < list.size(); i++) {
            dataStructure currentItem = list.get(i);

            if (currentItem.taskid.equals(id)) {
                list.remove(i);
                break;
            }
        }
        saveToFile(list);

    }



    public static String idGen(){
        //Auto generate the id (use : write() in main.java)

        ArrayList<dataStructure> list = fileMananger.readData();

        if (list.isEmpty()) {
            return "T001";
        }else {
            dataStructure lastid = list.get(list.size() - 1);
            int id = Integer.parseInt(lastid.taskid.substring(1));
            id++;
            return String.format("T%03d", id);
        }
    }

    public static void saveToFile(ArrayList<dataStructure> list) {
        //This function use to save data in the file. (use : write, update, delete in this class file)

        try{
            ObjectOutputStream myfile = new ObjectOutputStream(new FileOutputStream("src/todoDB.dat"));
            myfile.writeObject(list);
            myfile.close();
        }catch (IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
    }

}
