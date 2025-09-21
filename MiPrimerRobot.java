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
        int avenuePrueba= 1;
        //TransportRobot esp = new TransportRobot(70, streetPrueba, avenuePrueba, East, 0, Color.pink);
        // new Thread(esp).start();
        // esp.moveRight();

        streetPrueba= 1;
        avenuePrueba= 10;
        TransportRobot esp2 = new TransportRobot(0, streetPrueba, avenuePrueba, East, 5, Color.red);
        new Thread(esp2).start();
        // for(int i=0; i<6;i++){
        //     System.out.println("Vuelta de rojo #" + i);
        //     esp2.moveRight();
        // }
        TransportRobot r = new TransportRobot(1, 1, 11, East, 0, Color.blue);
        new Thread(r).start();
        // for(int i=0; i<6;i++){
        //     System.out.println("Vuelta de azul #" + i);
        //     esp2.moveRight();
        // }
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

    // ------------------- CAMINOS ---------------------

        // Zona Azul - Camino Rápido 
        public static void caminoAzulRapido(TransportRobot r) {
            //moveRight
            for(int i=0; i<23; i++) r.moveRight();
            //r.turnLeft();

            //moveUp
            for(int i=0; i<11; i++) r.moveUp(); 
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            //moveUp
            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft();

            //moveLeft
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();

            //movedown
            for(int i=0; i<1; i++) r.move();
            r.turnRight();
            
            //moveright
            for(int i=0; i<6; i++) r.move();
            r.turnLeft();

            //movedown
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();

            //moveright
            for(int i=0; i<6; i++) r.move();
            r.turnRight();

            //movedown
            for(int i=0; i<2; i++) r.move();
            r.turnRight();

            //moveright
            for(int i=0; i<1; i++) r.move();
            r.turnRight();

            //moveup
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();

            //moveleft
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();

            //movedown
            for(int i=0; i<1; i++) r.move();
        }


        // Zona Verde - Camino Rápido 
        public static void caminoVerdeRapido(TransportRobot r) {

            //movedown
            for(int i=0; i<2; i++) r.move(); 
            r.turnLeft();

            //moveright
            for(int i=0; i<7; i++) r.move(); 
            r.turnRight();

            //movedown
            for(int i=0; i<5; i++) r.move(); 
            r.turnRight();

            //moveleft
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();

            //movedown
            for(int i=0; i<4; i++) r.move(); 
            r.turnRight();

            //moveleft
            for(int i=0; i<3; i++) r.move(); 
            r.turnRight();

            //moveup
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();

            //moveleft
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();

            //movedown
            for(int i=0; i<1; i++) r.move();
            r.turnRight();

            //moveleft
            for(int i=0; i<5; i++) r.move();
            r.turnRight();

            //moveup
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();

            //moveleft
            for(int i=0; i<7; i++) r.move();
            
            //descargamos
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            //moveup
            for (int i=0; i<1; i++) r.move();
            r.turnRight();

            //moveleft
            for (int i=0; i<2; i++) r.move();
            r.turnLeft();

            //movedown
            for (int i=0; i<7; i++) r.move();
            r.turnLeft();

            //moveright
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            
            //movedown
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
