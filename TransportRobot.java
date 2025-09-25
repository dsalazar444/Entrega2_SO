import kareltherobot.*;
import java.awt.Color;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;
    private int street;   // posición actual en la fila
    private int avenue;   // posición actual en la columna
    private static final ZonasCriticas zonaCritica = new ZonasCriticas();
    private static final ZonasCriticas zonaCritica2 = new ZonasCriticas();
    private static final ZonasCriticas zonaCritica3 = new ZonasCriticas();

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
            
            // --- salidas de las zonas críticas ---
            // --- Zona 1 ---
            KJRTest Posicion = new KJRTest();
            if (estaEnPosicion(Posicion, this, 10, 29)) {
                zonaCritica.entrarNorte();
            } else if (estaEnPosicion(Posicion, this, 4, 30)) {
                zonaCritica.entrarSur();
            }
            // --- Zona 2 ---
            if (estaEnPosicion(Posicion, this, 2, 29)) {
                zonaCritica2.entrarNorte();
            } else if (estaEnPosicion(Posicion, this, 1, 25)) {
                zonaCritica2.entrarSur();
            }
            // --- Zona 3 ---
            if (estaEnPosicion(Posicion, this, 2, 21)) {
                zonaCritica3.entrarNorte();
            } else if (estaEnPosicion(Posicion, this, 1, 15)) {
                zonaCritica3.entrarSur();
            }


            // ocupar la celda destino (bloquea hasta que esté libre)
            mapaOcupacion.ocupar(nuevaStreet, nuevaAvenue);

            
            // mover físicamente
            move();
            
            // liberar la actual
            mapaOcupacion.liberar(street, avenue);
            
            
            // --- salidas de las zonas críticas ---
            // --- Zona 1 ---
            if (estaEnPosicion(Posicion, this, 10, 30)) {
                zonaCritica.salirZona("SUR");
            } else if (estaEnPosicion(Posicion, this, 5, 29)) {
                zonaCritica.salirZona("NORTE");
            } else if (estaEnPosicion(Posicion, this, 11, 30)) {
                zonaCritica.salirZona("NORTE");
            }

            // --- Zona 2 ---
            if (estaEnPosicion(Posicion, this, 1, 29)) {
                zonaCritica2.salirZona("SUR");
            } else if (estaEnPosicion(Posicion, this, 1, 26)) {
                zonaCritica2.salirZona("NORTE");
            }
            // --- Zona 3 ---
            if (estaEnPosicion(Posicion, this, 1, 21)) {
                zonaCritica3.salirZona("SUR");
                
                int turno3sur = zonaCritica3.getTurno3sur();
                String turno3= zonaCritica3.getTurno();
                if(turno3.equals("SUR")){
                    zonaCritica3.setTurno3sur(turno3sur + 1);
                }
                if (turno3sur % 4 == 0 && ((turno3sur / 4) % 2 == 1)) {
                    zonaCritica3.setTurno("SUR");
                }
            System.out.println("Turno Zona 3: " + turno3sur);
            } else if (estaEnPosicion(Posicion, this, 1, 16)) {
                zonaCritica3.salirZona("NORTE");
            }
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
                Utils.caminoAzulRapido(this);
            } else if (estaEnPosicion(Posicion, this, 12, 23)) {
                Utils.caminoVerdeRapido(this);
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
