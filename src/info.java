public class info {

    public static String Credit(){
        String credit = "";

        credit = """
                ##### TEAM CREDITS #####
                1.Yasith [Admin]
                2.Hiruni [Project Developer]
                3.Sachin [Project Developer]
                4.Githma [Project Developer]
                5.Chamaka [Project Testing & Consultor]
                6.Sayani [Project Documentation Member]
                7.Oshadini [Project Documentation Coordinator]
                """;

        return credit;
    }

    public static String Help (){
        String Help = "";

        Help = """
                ##### HELP MENU #####
                (1) Write tasks - Describe the tasks what we have to do.
                (2) View all tasks - Show the tasks what we have to do next.
                (3) Add new tasks - Update the tasks which newly added.
                (4) Delete tasks - Remove unnecessary tasks.
                (5) Show finish tasks - View completed tasks.
                < Add more options >
                """;
        return Help;
    }

    public static String About (){
        String About = "";

        About = """
                 ###### ABOUT PROJECT ######
                 This application was created by a team of 7 students as a mini project on the OUSL , Fundamentals of Programming course.
                
                 This is a mini project what we have to do in our courses. Such as Assignments, In class assignments, Presentations, Mini projects, day schools, Viva projects, Worksheets, Tutorials, Physical day schools, announcements and etc. And also we can use this application to know what we have to do in our courses. This ' To-do list application ' helps us to be aware of the tasks that need to be done for each course we are studying.
                
                 In addition, this applications allows you to be aware of all the tasks related to the subject area and complete them in a timely manner.It is an easy and user - friendly application.
                """;

        return About;
    }

    public static void animativePrint(String text, int speed) {
        for (int i = 0; i < text.length(); i++) {
            System.out.print(text.charAt(i)); // එක අකුරක් පෙන්වනවා
            try {
                Thread.sleep(speed); // මිලි තත්පර ගණනක් පෝස් කරනවා (Delay)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // පේළිය ඉවර වුණාම අලුත් පේළියකට යනවා
    }
}
