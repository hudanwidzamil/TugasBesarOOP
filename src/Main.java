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
            String command = in.next();
            if (command.equals("exit")) {
                end = true;
            }
            else if (command.equals("show")) {
                p.showMap();
            }
            else if (command.equals("buy")) {
                p.buyPlant(in.nextInt(), in.nextInt(), in.nextInt());
            }
            else if (command.equals("skip")) {
                p.skip();
            }
        }
    }
    
}