import kareltherobot.*;

public class Utils {
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
    public static void arranqueVerde(TransportRobot r) {
        KJRTest Posicion = new KJRTest();
        if (TransportRobot.estaEnPosicion(Posicion, r, 13, 23)) {
            for(int i=0; i<1; i++) r.move(); 
        }
    }
    public static void arranqueAzul(TransportRobot r) {
        KJRTest Posicion = new KJRTest();
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 6)) {
            for(int i=0; i<1; i++) r.move(); 
        }
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 5)) {
            for(int i=0; i<2; i++) r.move(); 
        }
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 4)) {
            for(int i=0; i<3; i++) r.move(); 
        }
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 3)) {
            for(int i=0; i<4; i++) r.move(); 
        }
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 2)) {
            for(int i=0; i<5; i++) r.move(); 
        }
        if (TransportRobot.estaEnPosicion(Posicion, r, 1, 1)) {
            for(int i=0; i<6; i++) r.move(); 
        }
    }
}
