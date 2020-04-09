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
    public final static void introscreen(){
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("------___________--------------------------________________-------");
        System.out.println("-----|    ___    |------------------------|__________      |------");
        System.out.println("-----|   |   |   |-----------------------------------|    |-------");
        System.out.println("-----|   |___|   |---------------------------------_|   _|--------");
        System.out.println("-----|    _______|------------------------------__|  __|----------");
        System.out.println("-----|   |--------------____-----____--------__|  __|-------------");
        System.out.println("-----|   |--------------|  |_____|  |------_|  __|----------------");
        System.out.println("-----|   |----------------|  |_|  |-------|   |____________-------");
        System.out.println("-----|___|-----------------|_____|--------|________________|------");
        System.out.println("------------------------------------------------------------------");
        System.out.println("+-----------------------------------------------------------------+");
        System.out.println("                             2020                                 ");
        
    }
    public final static void outroscreen(){
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("                           THE END                                ");
        System.out.println();
        System.out.println("                  Thank you for playing this                      ");
        System.out.println("                      Quarantine Content                          ");
        System.out.println("                             2020                                 ");
        
    }

    public static void main(String[] args) {
        boolean end = false;

        Scanner in = new Scanner(System.in);
        
        introscreen();
        System.out.println("Welcome to PvZ!");
        //wait 1s
        try{
            Thread.sleep(1000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        
        clearscreen();

        Player p = new Player();
        while (! end) {
            p.showMap();
            System.out.println("Command available:");
            System.out.println("BUY, SKIP, EXIT(and other input means exit too)");
            String command = in.next();
            if (command.equals("BUY")) {
                System.out.println("plant type: 1. peashooter, 2. fumeshroom");
                System.out.println("position: x[1,9], y[1,4]");
                System.out.println("input: <type> <x pos> <y pos>");
                p.buyPlant(in.nextInt(), in.nextInt()-1, in.nextInt()-1);
            }
            else if (command.equals("SKIP")) {
                p.skip();
            }else{
                end = true;
            }

            if (p.getWin() == false) {
                System.out.println("You lose.");
                end = true;
            }
            p.addTurn();
            //wait 1s
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }

            clearscreen();
        }
        outroscreen();
    }
    
}