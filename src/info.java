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
                ------ Help -------
                <add help Menu>
                ex:
                Choose [1] - can write the task
                """;
        return Help;
    }

    public static String About (){
        String About = "";

        About = """
                ------ ABOUT -------
                <add about of team & project>
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
