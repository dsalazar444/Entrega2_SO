import kareltherobot.*;
import java.awt.Color;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;
    private int street;   // posición actual en la fila
    private int avenue;   // posición actual en la columna

    public TransportRobot(int id, int street, int avenue, Direction dir, int beepers, Color color) {
        super(street, avenue, dir, beepers, color);
        this.id = id;
        this.passengers = 0;
        this.street = street;
        this.avenue = avenue;
        World.setupThread(this);

        // ocupar posición inicial en el mapa
        try {
            mapaOcupacion.ocupar(street, avenue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // getters opcionales
    public int getStreet() { return street; }
    public int getAvenue() { return avenue; }


    public static boolean estaEnPosicion(KJRTest Posicion, UrRobot robot, int calle, int avenida) {
        try {
            Posicion.assertOnStreet(robot, calle);
            Posicion.assertOnAvenue(robot, avenida);
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }
    public void moverConControl() {
        try {
            int nuevaStreet = street;
            int nuevaAvenue = avenue;

            if (facingNorth()) {
                nuevaStreet++;
            } else if (facingSouth()) {
                nuevaStreet--;
            } else if (facingEast()) {
                nuevaAvenue++;
            } else if (facingWest()) {
                nuevaAvenue--;
            }

            // ocupar la celda destino (bloquea hasta que esté libre)
            mapaOcupacion.ocupar(nuevaStreet, nuevaAvenue);

            
            // mover físicamente
            move();
            
            // liberar la actual
            mapaOcupacion.liberar(street, avenue);

            // actualizar coordenadas
            street = nuevaStreet;
            avenue = nuevaAvenue;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void elegirCaminoSegunPosicion() {
        if (nextToABeeper()) {
            java.util.Random rand = new java.util.Random();
            KJRTest Posicion = new KJRTest();
            if (estaEnPosicion(Posicion, this, 1, 7)) {
                if (rand.nextBoolean()) {
                    Utils.caminoAzulRapido(this);
                } else {
                    Utils.caminoAzulLargo(this);
                }
            } else if (estaEnPosicion(Posicion, this, 12, 23)) {
                if (rand.nextBoolean()) {
                    Utils.caminoVerdeRapido(this);
                } else {
                    Utils.caminoVerdeLargo(this);
                }
            }
        }
    }

    @Override
    public void run() {
        Utils.arranqueAzul(this);
        Utils.arranqueVerde(this);
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
