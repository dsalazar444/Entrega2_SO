import kareltherobot.*;
import java.awt.Color;
import java.util.concurrent.Semaphore;

public class MiPrimerRobot implements Directions {
    public static void main(String[] args) {
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

        for (int i = 0; i < 28; i++) {
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
        }
    }
}

// CLASES ADICIONALES

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;

    public TransportRobot(int id, int street, int avenue, Direction dir, int beepers, Color color) {
        super(street, avenue, dir, beepers, color);
        this.id = id;
        this.passengers = 0;
        World.setupThread(this);
    }

    @Override
    public void run() {
        while (true) {
            if (anyBeepersInBeeperBag() || loadPassengers()) {
                moveToDestination();
                unloadPassengers();
                moveBackToOrigin();
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

class TrafficController {
    private static Semaphore blueSection = new Semaphore(4, true);
    private static Semaphore greenSection = new Semaphore(6, true);

    public static void enterBlue() throws InterruptedException {
        blueSection.acquire();
    }

    public static void leaveBlue() {
        blueSection.release();
    }

    public static void enterGreen() throws InterruptedException {
        greenSection.acquire();
    }

    public static void leaveGreen() {
        greenSection.release();
    }
}
