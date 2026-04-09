import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class dateCheck {

    public static String DateCorrect(String Date){
        String[] parts = Date.split("-");               // This method format task date according to yyyy:mm:dd format.

        if (parts[1].length()==1){
            if (parts[2].length()==1){
                Date = parts[0]+"-0"+parts[1]+"-0"+parts[2];
            }else {
                Date = parts[0]+"-0"+parts[1]+"-"+parts[2];
            }

        }else {
            if (parts[2].length()==1){
                Date = parts[0]+"-"+parts[1]+"-0"+parts[2];
            }else {
                Date = parts[0]+"-"+parts[1]+"-"+parts[2];
            }
        }return Date;
    }

    public static boolean date_rangeCheck(String date){
        String[] parts = date.split("-");                           //    This method check task date (month and day) is in correct range.

        if(Integer.parseInt(parts[1]) <= 12 && Integer.parseInt(parts[2]) <= 31){
            return true;

        }else {
            return false;
        }
    }

    public static boolean time_rangeCheck(String time){

        String[] parts = time.split(":");                                  //  This method check time is in 24:00H range

        if (Integer.parseInt(parts[0]) <= 23 && Integer.parseInt(parts[1]) <= 59){
            return true;
        }else{
            return false;
        }

    }

    public static String getdate_status(String Date){

        Date = DateCorrect(Date);                                       //  This method check Task date is due, coming up or today.

        LocalDate date = LocalDate.parse(Date);
        LocalDate today = LocalDate.now();
        LocalTime time = LocalTime.now();

        if (date.isBefore(today)) {
            return "Due";

        } else if (date.isAfter(today)) {
            return "Coming Up";

        } else {
            return "Today";
        }

    }

    public static String TimeCorrect(String time){

        String[] parts = time.split(":");           // This method get task time and format it according to 00:00 format.

        if (parts[0].length()==1){
            if (parts[1].length()==1){
                time = "0"+parts[0]+":0"+parts[1];
            }else {
                time = "0"+parts[0]+":"+parts[1];
            }

        }else {
            time = time;
        }
        return time;
    }

}
