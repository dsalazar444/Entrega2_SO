import kareltherobot.*;

public class Utils {
   // ------------------- CAMINOS ---------------------

        // Zona Azul - Camino Rápido 
        public static void caminoAzulRapido(TransportRobot r) {
            for(int i=0; i<23; i++) r.moverConControl(); 
            r.turnLeft();
            for(int i=0; i<11; i++) r.moverConControl(); 
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for(int i=0; i<4; i++) r.moverConControl(); 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
        }
        // Zona Verde - Camino Rápido 
        public static void caminoVerdeRapido(TransportRobot r) {
            for(int i=0; i<2; i++) r.moverConControl(); 
            r.turnLeft();
            for(int i=0; i<7; i++) r.moverConControl(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<4; i++) r.moverConControl(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.moverConControl(); 
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<7; i++) r.moverConControl();
            
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<7; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }

        // Zona Azul - Camino Largo 
        public static void caminoAzulLargo(TransportRobot r) {
            for(int i=0; i<4; i++) r.moverConControl(); 
            r.turnLeft(); 
            for(int i=0; i<10; i++) r.moverConControl(); 
            r.turnLeft();
            for(int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<8; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            
            for(int i=0; i<5; i++) r.moverConControl();
            
            r.turnLeft();
            for(int i=0; i<7; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<10; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            while(r.anyBeepersInBeeperBag()) r.putBeeper();

            for(int i=0; i<4; i++) r.moverConControl(); 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
        }
        // Zona Verde - Camino Largo 
        public static void caminoVerdeLargo(TransportRobot r) {
            r.moverConControl();
            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            

            for (int i=0; i<3; i++) r.moverConControl();
            r.turnLeft(); 
            r.turnLeft();
            r.turnLeft();
            for (int i=0; i<8; i++) r.moverConControl();

            r.turnLeft();
            for (int i=0; i<2; i++) r.moverConControl();

            r.turnLeft();
            for (int i=0; i<4; i++) r.moverConControl();

            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<17; i++) r.moverConControl();

            r.turnLeft();
            for (int i=0; i<5; i++) r.moverConControl();
            
            r.turnLeft();
            for (int i=0; i<9; i++) r.moverConControl();
            r.turnLeft(); 
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<8; i++) r.moverConControl();

            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            r.moverConControl();
            

            while(r.anyBeepersInBeeperBag()) r.putBeeper();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<7; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
    }
    public static void arranqueVerde(TransportRobot r) {
        if (TransportRobot.estaEnPosicion( r, 13, 23)) {
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 24)) {
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 25)) {
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 26)) {
            for(int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 27)) {
            for(int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 28)) {
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 12, 28)) {
            r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 12, 29)) {
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 13, 29)) {
            r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 29)) {
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 28)) {
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 27)) {
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 26)) {
            for(int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 25)) {
            for(int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 24)) {
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 23)) {
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 23)) {
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 24)) {
            for(int i=0; i<1; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 25)) {
            for(int i=0; i<2; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 26)) {
            for(int i=0; i<3; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 27)) {
            for(int i=0; i<4; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 28)) {
            for(int i=0; i<5; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 29)) {
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 16, 29)) {
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 16, 30)) {
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 15, 30)) {
            
            for(int i=0; i<1; i++) r.moverConControl(); 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 14, 30)) {
            
            for(int i=0; i<2; i++) r.moverConControl(); 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
 
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
    }
    public static void arranqueAzul(TransportRobot r) {
        if (TransportRobot.estaEnPosicion( r, 1, 6)) {
            for(int i=0; i<1; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 1, 5)) {
            for(int i=0; i<2; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 1, 4)) {
            for(int i=0; i<3; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 1, 3)) {
            for(int i=0; i<4; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 1, 2)) {
            for(int i=0; i<5; i++) r.moverConControl(); 
        }
        if (TransportRobot.estaEnPosicion( r, 1, 1)) {
            for(int i=0; i<6; i++) r.moverConControl(); 
        }
         if (TransportRobot.estaEnPosicion( r, 2, 1)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
         if (TransportRobot.estaEnPosicion( r, 2, 2)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
         if (TransportRobot.estaEnPosicion( r, 2, 3)) {
            for (int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
         if (TransportRobot.estaEnPosicion( r, 2, 4)) {
            for (int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
         if (TransportRobot.estaEnPosicion( r, 2, 5)) {
            for (int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
         if (TransportRobot.estaEnPosicion( r, 2, 6)) {
            for (int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 2, 7)) {
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 7)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 6)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 5)) {
            for (int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 4)) {
            for (int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3,3)) {
            for (int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 2)) {
            for (int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 3, 1)) {
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 1)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 2)) {
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 3)) {
            for (int i=0; i<2; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 4)) {
            for (int i=0; i<3; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 5)) {
            for (int i=0; i<4; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 6)) {
            for (int i=0; i<5; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
        if (TransportRobot.estaEnPosicion( r, 4, 7)) {
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            r.turnLeft(); 
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<1; i++) r.moverConControl();
            r.turnLeft();
            for (int i=0; i<6; i++) r.moverConControl();
        }
    }
}
