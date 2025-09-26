import kareltherobot.*;
import java.awt.Color;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;
    private int street;   // posición actual en la fila
    private int avenue;   // posición actual en la columna
    private boolean pasoPor1123 = false;
    private boolean pasoPor430 = false;
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


    public static boolean estaEnPosicion(TransportRobot robot, int calle, int avenida) {
        return robot.getStreet() == calle && robot.getAvenue() == avenida;
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
            
            if(estaEnPosicion( this, 4, 30)){
                pasoPor430 = true;
                Thread.sleep(100);
            }
            if(estaEnPosicion( this, 11, 23)){
                pasoPor1123 = true;
            }

            if (estaEnPosicion( this, 10, 29)) {
                Thread.sleep(100);
            }
            if(estaEnPosicion( this, 11, 22)){
                pasoPor1123 = false;
                Thread.sleep(100);
            }
            if ((estaEnPosicion( this, 10, 29) && pasoPor1123)) {
                zonaCritica.entrarNorte();
                pasoPor1123 = false;
                
            } else if (estaEnPosicion( this, 4, 30)) {
                Thread.sleep(500);
                zonaCritica.entrarSur();
                
            }
            
            // --- Zona 2 ---
            if (estaEnPosicion( this, 2, 29)) {
                Thread.sleep(500);
                zonaCritica2.entrarNorte();
                
            } else if (estaEnPosicion( this, 1, 25)) {
                Thread.sleep(500);
                zonaCritica2.entrarSur();
                
            }
            // --- Zona 3 ---
            if (estaEnPosicion( this, 2, 21)) {
                Thread.sleep(500);
                zonaCritica3.entrarNorte();
            } else if (estaEnPosicion( this, 1, 15)) {
                Thread.sleep(500);
                zonaCritica3.entrarSur();
            }
            


            // ocupar la celda destino (bloquea hasta que esté libre)
            Thread.sleep(50);

            mapaOcupacion.ocupar(nuevaStreet, nuevaAvenue);
            
            
            // mover físicamente
            move();
            
            // liberar la actual
            mapaOcupacion.liberar(street, avenue);
            
            
            // --- salidas de las zonas críticas ---
            // --- Zona 1 ---

            
            if (estaEnPosicion( this, 10, 30) && pasoPor430) {
                zonaCritica.salirZona("SUR");
                pasoPor430 = false;
            } else if (estaEnPosicion( this, 5, 29) ) {
                zonaCritica.salirZona("NORTE");
            } 

            // --- Zona 2 ---
            if (estaEnPosicion( this, 1, 29)) {
                zonaCritica2.salirZona("SUR");
            } else if (estaEnPosicion( this, 1, 26)) {
                zonaCritica2.salirZona("NORTE");
            }
            // --- Zona 3 ---
            if (estaEnPosicion( this, 1, 21)) {
                zonaCritica3.salirZona("SUR");
                
            } else if (estaEnPosicion( this, 1, 16)) {
                zonaCritica3.salirZona("NORTE");
                Thread.sleep(100);
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
            int robotsabajo = mapaOcupacion.contarRobotsEnFranja(1, 11, 16);
            int robotsarriba = mapaOcupacion.contarRobotsEnFranja(10, 24, 29);
            if (estaEnPosicion( this, 1, 7)) {
                if(robotsabajo >= 4){
                Utils.caminoAzulLargo(this);
                } else {
                Utils.caminoAzulRapido(this);
                }
            } else if (estaEnPosicion( this, 12, 23)) {
                if(robotsarriba >= 5){
                Utils.caminoVerdeLargo(this);
                } else {
                Utils.caminoVerdeRapido(this);
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

}
