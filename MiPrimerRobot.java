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
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
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
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.move(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<7; i++) r.move();
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<2; i++) r.move();
            r.turnLeft();
            for (int i=0; i<7; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
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
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<8; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<4; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.move();
            r.turnLeft();
            
            for(int i=0; i<5; i++) r.move();
            
            r.turnLeft();
            for(int i=0; i<7; i++) r.move();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<10; i++) r.move();
            r.turnLeft();
            for(int i=0; i<2; i++) r.move();
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for(int i=0; i<4; i++) r.move(); 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<6; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
            r.turnLeft();
            for(int i=0; i<5; i++) r.move();
            r.turnLeft();
            for(int i=0; i<1; i++) r.move();
        }
        // Zona Verde - Camino Largo 
        public static void caminoVerdeLargo(TransportRobot r) {
            r.move();
            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            

            for (int i=0; i<3; i++) r.move();
            r.turnLeft(); 
            r.turnLeft();
            r.turnLeft();
            for (int i=0; i<8; i++) r.move();

            r.turnLeft();
            for (int i=0; i<2; i++) r.move();

            r.turnLeft();
            for (int i=0; i<4; i++) r.move();

            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<17; i++) r.move();

            r.turnLeft();
            for (int i=0; i<5; i++) r.move();
            
            r.turnLeft();
            for (int i=0; i<9; i++) r.move();
            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<8; i++) r.move();

            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            

            while(r.anyBeepersInBeeperBag()) r.putBeeper();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<2; i++) r.move();
            r.turnLeft();
            for (int i=0; i<7; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();
            r.turnLeft();
            for (int i=0; i<1; i++) r.move();
            r.turnLeft();
            for (int i=0; i<6; i++) r.move();

    }

}

// class TrafficController {
//     private static Semaphore blueSection = new Semaphore(4, true);
//     private static Semaphore greenSection = new Semaphore(6, true);

//     public static void enterBlue() throws InterruptedException {
//         blueSection.acquire();
//     }

//     public static void leaveBlue() {
//         blueSection.release();
//     }

//     public static void enterGreen() throws InterruptedException {
//         greenSection.acquire();
//     }

//     public static void leaveGreen() {
//         greenSection.release();
//     }
// }

// class TransportRobot extends Robot implements Runnable {
//     private int passengers;
//     private int id;

//     public TransportRobot(int id, int street, int avenue, Direction dir, int beepers, Color color) {
//         super(street, avenue, dir, beepers, color);
//         this.id = id;
//         this.passengers = 0;
//         World.setupThread(this);
//     }

//      public static boolean estaEnPosicion(KJRTest Posicion,UrRobot robot, int calle, int avenida) {
//         try {
//             Posicion.assertOnStreet(robot,calle);   // Falla si no está en esa calle
//             Posicion.assertOnAvenue(robot,avenida); // Falla si no está en esa avenida
//             return true; // Si no falló, está en esa posición
//             } catch (AssertionError e) {
//             return false; // Si alguna falla, no está en esa posición
//             }
//     }
//     private void elegirCaminoSegunPosicion() {
//         if (nextToABeeper()) {
//             java.util.Random rand = new java.util.Random();
//             KJRTest Posicion = new KJRTest();
//             if (estaEnPosicion(Posicion, this, 1, 7)) {
//                 if (rand.nextBoolean()) {
//                     MiPrimerRobot.caminoAzulRapido(this);
//                 } else {
//                     MiPrimerRobot.caminoAzulLargo(this);
//                 }
//             } else if (estaEnPosicion(Posicion, this, 12, 23)) {
//                 if (rand.nextBoolean()) {
//                     MiPrimerRobot.caminoVerdeRapido(this);
//                 } else {
//                     MiPrimerRobot.caminoVerdeLargo(this);
//                 }
//             }
//         }
//     }

//     @Override
//     public void run() {
//         while (true) {
//             if (anyBeepersInBeeperBag() || loadPassengers()) {
//                 elegirCaminoSegunPosicion();
//                 int count = 0;
//                 while (count < 4) {
//                     pickBeeper();
//                     count++;
//                 }
//             } else {
//                 turnOff();
//                 break;
//             }
//         }
//     }

//     private boolean loadPassengers() {
//         while (passengers < 4 && nextToABeeper()) {
//             pickBeeper();
//             passengers++;
//         }
//         return passengers > 0;
//     }

//     private void unloadPassengers() {
//         while (passengers > 0) {
//             putBeeper();
//             passengers--;
//         }
//     }

//     private void moveToDestination() {
//         // lógica de las rutas (rápida o larga)
//     }

//     private void moveBackToOrigin() {
//         // la lógica de regreso (Otra ruta distinta a la inicial para que no estorbe (?))
//     }
// }