import kareltherobot.*;
import java.awt.Color;
import java.util.concurrent.Semaphore;

public class MiPrimerRobot implements Directions {

    public static void main(String[] args) {
        World.setDelay(10);
        World.readWorld("Mundo2.kwld");
        World.setVisible(true);

        int streetBlue = 1;
        int avenueBlue = 1;   
        int streetGreen = 15;
        int avenueGreen = 30;   
        
        //Prueba
        int streetPrueba= 1;
        int avenuePrueba= 7;
        TransportRobot esp2 = new TransportRobot(0, streetPrueba, avenuePrueba, East, 0, Color.red);
        new Thread(esp2).start();

        TransportRobot r = new TransportRobot(1, 1, 8, East, 0, Color.blue);
        new Thread(r).start();
    
        //Fin prueba
        // for (int i = 0; i < 28; i++) {     
        //     TransportRobot r = new TransportRobot(i, streetBlue, avenueBlue, East, 0, Color.blue);
        //     new Thread(r).start();
        //     avenueBlue++; 
        //     if (avenueBlue > 7) {
        //         avenueBlue = 1;
        //         streetBlue ++;
        //     }
        // }

        /*for (int i = 0; i < 28; i++) {
            TransportRobot r = new TransportRobot(i+28, streetGreen, avenueGreen, West, 0, Color.green);
            new Thread(r).start();
            avenueGreen--;
            if (avenueGreen < 23) {
                avenueGreen = 30;
                streetGreen--;
            }
            if (streetGreen == 12 && avenueGreen < 28){
                avenueGreen = 23;
            }
        }*/
    }

}
