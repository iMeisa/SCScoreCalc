import java.util.Scanner;

public class ScoreCalc {

    public static Scanner scanner = new Scanner(System.in);
    public static int matchNumber;
    public static String teamBlue;
    public static String teamRed;
    public static int BOn;
    public static int order;
    public static int bluePoints = 0;
    public static int redPoints = 0;
    public static String blueBan;
    public static String redBan;

    public static void main(String[] args) {

//        boolean finishMatch = false;

        System.out.println("Welcome to Speed Cup Score Calculator");

        setup();

        pickBan();

        ScoreCount();

        printResults();

//        while (!finishMatch) {
//            System.out.print("\nWhat would you like to do?" +
//                    "\n1. Setup" +
//                    "\n2. Pick Bans" +
//                    "\n3. Start The Match" +
//                    "\n\n> ");
//            int choice = scanner.nextInt();
//
//            switch (choice) {
//                case 1:
//                    setup();
//                    break;
//                case 2:
//                    pickBan();
//                    break;
//                case 3:
//                    ScoreCount();
//                    printResults();
//                    finishMatch = true;
//                    break;
//            }
//
//        }
    }

    public static void setup() {
        System.out.print("\nMatch ##?\n> ");
        matchNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.print("\nWhat is the name of the blue team?\n> ");
        teamBlue = scanner.nextLine();

        System.out.print("\nWhat is the name of the red team?\n> ");
        teamRed = scanner.nextLine();

        System.out.print("\nBest of how many?\n> ");
        BOn = scanner.nextInt();
        scanner.nextLine();
        System.out.println("BO" + BOn + " = " + ((BOn / 2) + 1) + " points to win");
    }

    public static void pickBan() {

        System.out.print("\nWhich team won the roll?\n1. Blue  2. Red\n> ");
        order = scanner.nextInt();
        scanner.nextLine();

        if(order % 2 != 0) {
            System.out.print("\nTeam Red bans!\n\nWhat is Team Red's ban?\n> ");
            redBan = scanner.nextLine();

            System.out.print("\nTeam Blue bans!\n\nWhat is Team Blue's ban?\n> ");
            blueBan = scanner.nextLine();
        } else {
            System.out.print("\nTeam Blue bans!\n\nWhat is Team Blue's ban?\n> ");
            blueBan = scanner.nextLine();

            System.out.print("\nTeam Red bans!\n\nWhat is Team Red's ban?\n> ");
            redBan = scanner.nextLine();
        }
    }

    public static void ScoreCount() {

        while (bluePoints < ((BOn / 2) + 1) && redPoints < ((BOn / 2) + 1)) {

            if(order % 2 != 0) {
                System.out.println("\nTeam Blue's pick!");
            } else {
                System.out.println("\nTeam Red's pick!");
            }
            order++;

            System.out.print("\nTeam Blue's accuracy\n> ");
            double blueAcc = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("\nTeam Red's accuracy\n> ");
            double redAcc = ((scanner.nextDouble() * 5) / 4);
            scanner.nextLine();

            System.out.println("red acc " + redAcc);

            if (blueAcc > redAcc) {
                bluePoints++;
            } else {
                redPoints++;
            }

            System.out.println("\n" + teamBlue + " " + bluePoints + " | " + redPoints + " " + teamRed);
        }

        if(bluePoints > redPoints) {
            System.out.println("\n" + teamBlue + " wins!");
        } else {
            System.out.println("\n" + teamRed + " wins!");
        }
    }

    public static void printResults() {
        System.out.print("\nMatch link\n> ");
        String matchLink = scanner.nextLine();

        System.out.println("\nResults:" +
                "\n\n__**Quarterfinals**__" + //change this for different weeks
                "\n**Match " + matchNumber + ":** " + matchLink +
                "\n\nResults: " + teamBlue + " **" + bluePoints + " | " + redPoints + "** " + teamRed +
                "\n\n**Bans:**" +
                "\n" + teamBlue + ": **" + blueBan + "**" +
                "\n" + teamRed + ": **" + redBan + "**");
    }


}
