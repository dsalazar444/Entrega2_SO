import kareltherobot.*;
import java.awt.Color;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;

    public void turnRight(){
        for(int i=0; i<3; i++){
            turnLeft();
        }
    }

    public TransportRobot(int id, int street, int avenue, Direction dir, int beepers, Color color) {
        super(street, avenue, dir, beepers, color);
        this.id = id;
        this.passengers = 0;
        World.setupThread(this);
    }

     public static boolean estaEnPosicion(KJRTest Posicion,UrRobot robot, int calle, int avenida) {
        try {
            Posicion.assertOnStreet(robot,calle);   // Falla si no está en esa calle
            Posicion.assertOnAvenue(robot,avenida); // Falla si no está en esa avenida
            return true; // Si no falló, está en esa posición
            } catch (AssertionError e) {
            return false; // Si alguna falla, no está en esa posición
            }
    }
    private void elegirCaminoSegunPosicion() {
        if (nextToABeeper()) {
            java.util.Random rand = new java.util.Random();
            KJRTest Posicion = new KJRTest();
            if (estaEnPosicion(Posicion, this, 1, 7)) {
                if (rand.nextBoolean()) {
                    MiPrimerRobot.caminoAzulRapido(this);
                } else {
                    MiPrimerRobot.caminoAzulLargo(this);
                }
            } else if (estaEnPosicion(Posicion, this, 12, 23)) {
                if (rand.nextBoolean()) {
                    MiPrimerRobot.caminoVerdeRapido(this);
                } else {
                    MiPrimerRobot.caminoVerdeLargo(this);
                }
            }
        }
    }

    @Override
    public void run() {
        while (true) {
            if (anyBeepersInBeeperBag() || loadPassengers()) {
                elegirCaminoSegunPosicion();
                int count = 0;
                while (count < 4) {
                    pickBeeper();
                    count++;
                }
            } else {
                turnOff();
                break;
            }
        }
    }

    private boolean loadPassengers() {
        while (passengers < 4 && nextToABeeper()) {
            pickBeeper();
            passengers++;
        }
        return passengers > 0;
    }

    private void unloadPassengers() {
        while (passengers > 0) {
            putBeeper();
            passengers--;
        }
    }

    private void moveToDestination() {
        // lógica de las rutas (rápida o larga)
    }

    private void moveBackToOrigin() {
        // la lógica de regreso (Otra ruta distinta a la inicial para que no estorbe (?))
    }
}