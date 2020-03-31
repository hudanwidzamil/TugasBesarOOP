import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public static void main(String[] args) {
        boolean end = false;

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to PvZ!");
        System.out.println("Type 'exit' to quit.");

        Player p = new Player();

        while (! end) {
            p.showMap();
            System.out.println("Command available:");
            System.out.println("buy, skip, exit");
            String command = in.next();
            if (command.equals("exit")) {
                end = true;
            }
            else if (command.equals("buy")) {
                System.out.println("plant type: 1. peashooter, 2. fumeshroom");
                System.out.println("position: x[1,7], y[1,4]");
                p.buyPlant(in.nextInt(), in.nextInt()-1, in.nextInt()-1);
                
            }
            else if (command.equals("skip")) {
                p.skip();
            }
            p.addTurn();
        }
    }
    
}