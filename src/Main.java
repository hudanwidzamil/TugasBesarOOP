import java.lang.ref.Cleaner;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
    public final static void clearscreen(){
        for(int clear = 0; clear < 10; clear++)
        {
            System.out.println("\b") ;
        }
    }
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
                System.out.println("position: x[1,9], y[1,4]");
                System.out.println("input: <type> <x pos> <y pos>");
                p.buyPlant(in.nextInt(), in.nextInt()-1, in.nextInt()-1);
                
            }
            else if (command.equals("skip")) {
                p.skip();
            }

            if (p.getWin() == false) {
                System.out.println("You lose.");
                end = true;
            }
            
            p.addTurn();
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
            clearscreen();
        }
    }
    
}