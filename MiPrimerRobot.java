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

        for (int i = 0; i < 28; i++) {     
            TransportRobot r = new TransportRobot(i, streetBlue, avenueBlue, East, 0, Color.blue);
            new Thread(r).start();
            avenueBlue++; 
            if (avenueBlue > 7) {
                avenueBlue = 1;
                streetBlue ++;
            }
        }

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

    // ------------------- CAMINOS ---------------------

        // Zona Azul - Camino Rápido 
        public static void caminoAzulRapido(TransportRobot r) {
            for(int i=0; i<23; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<11; i++) r.move(); 
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
    
            for(int i=0; i<6; i++) r.move();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
            r.turnRight();
            for(int i=0; i<2; i++) r.move();
            r.turnRight();
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
        }
        // Zona Verde - Camino Rápido 
        public static void caminoVerdeRapido(TransportRobot r) {
            for(int i=0; i<2; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<7; i++) r.move(); 
            r.turnRight();
            for(int i=0; i<5; i++) r.move(); 
            r.turnRight();
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<4; i++) r.move(); 
            r.turnRight();
            for(int i=0; i<3; i++) r.move(); 
            r.turnRight();
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
            for(int i=0; i<5; i++) r.move();
            r.turnRight();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<7; i++) r.move();
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for (int i=0; i<1; i++) r.move();
            r.turnRight();
            for (int i=0; i<2; i++) r.move();
            r.turnLeft();
            for (int i=0; i<7; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
            r.turnRight();
            for (int i=0; i<1; i++) r.move();
            r.turnRight();
            for (int i=0; i<6; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
        }

        // Zona Azul - Camino Largo 
        public static void caminoAzulLargo(TransportRobot r) {
            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft(); 
            for(int i=0; i<10; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<3; i++) r.move();
            r.turnRight();
            for(int i=0; i<3; i++) r.move();
            r.turnRight();
            for(int i=0; i<8; i++) r.move();
            r.turnRight();
            for(int i=0; i<4; i++) r.move();
            r.turnRight();
            for(int i=0; i<3; i++) r.move();
            r.turnLeft();
            
            for(int i=0; i<5; i++) r.move();
            
            r.turnLeft();
            for(int i=0; i<7; i++) r.move();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnRight();
            for(int i=0; i<10; i++) r.move();
            r.turnLeft();
            for(int i=0; i<2; i++) r.move();
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
            for(int i=0; i<6; i++) r.move();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
            r.turnRight();
            for(int i=0; i<2; i++) r.move();
            r.turnRight();
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
        }
        // Zona Verde - Camino Largo 
        public static void caminoVerdeLargo(TransportRobot r) {
            r.move();
            r.turnRight();
            

            for (int i=0; i<3; i++) r.move();
            r.turnRight();

            for (int i=0; i<8; i++) r.move();

            r.turnLeft();
            for (int i=0; i<2; i++) r.move();

            r.turnLeft();
            for (int i=0; i<4; i++) r.move();

            r.turnRight();
            for (int i=0; i<17; i++) r.move();

            r.turnLeft();
            for (int i=0; i<5; i++) r.move();
            
            r.turnLeft();
            for (int i=0; i<9; i++) r.move();
            r.turnRight();
            for (int i=0; i<8; i++) r.move();

            r.turnRight();
            for (int i=0; i<1; i++) r.move();
            

            while(r.anyBeepersInBeeperBag()) r.putBeeper();
            for (int i=0; i<1; i++) r.move();
            r.turnRight();
            for (int i=0; i<2; i++) r.move();
            r.turnLeft();
            for (int i=0; i<7; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
            r.turnRight();
            for (int i=0; i<1; i++) r.move();
            r.turnRight();
            for (int i=0; i<6; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
    }

}
