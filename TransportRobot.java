import kareltherobot.*;
import java.awt.Color;
import java.lang.reflect.Field;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    private int id;
    // Mantenemos nuestras coordenadas sincronizadas con Karel
    private int avenue;
    private int street;
    //Lo definimos como estatico para que todos los robots puedan acceder al
    //mismo tf (y su mapa).
    public static TrafficController tf;
    

    public void turnRight(){
        for(int i=0; i<3; i++){
            turnLeft();
        }
    }

    public int getAvenue(){
        return this.avenue;
    }

    public int getStreet(){
        return this.street;
    }
    //De momento, sigo logica de moveRight, moveLeft (avanzamos en columna),
    //moveUp, moveDown (avanzamos en fila), para
    //evitar ambiguedad de moveLeft pero dependiendo de donde estemos mirando.
    
    public void moveRight() {
        // 1. Orientarse hacia el Este
        while(!facingEast()){
            turnLeft();
        }
        
        System.out.println("Robot " + id + ": Intentando moveRight desde (" + getStreet() + ", " + getAvenue() + ")");
    
        int actualAvenue = getAvenue();
        int nextAvenue = actualAvenue + 1;
    
        System.out.println("Robot " + id + ": Posición actual: " + actualAvenue + ", Posición siguiente: " + nextAvenue);
    
        // SYNCHRONIZED: Solo un robot puede acceder a esta sección a la vez
        synchronized(TrafficController.map) {
            System.out.println("Robot " + id + ": Entró al bloque synchronized.");
    
            if (nextAvenue >= TrafficController.map[0].length) {
                System.out.println("Robot " + id + ": ERROR - nextAvenue (" + nextAvenue + ") está fuera de los límites del mapa.");
                return; // Salir para evitar ArrayIndexOutOfBoundsException
            }
    
            System.out.println("Robot " + id + ": Verificando mapa en [" + getStreet() + "][" + nextAvenue + "]. Valor: " + TrafficController.map[getStreet()][nextAvenue]);
    
            if(TrafficController.map[getStreet()][nextAvenue] == 0){
                System.out.println("Robot " + id + ": La posición está libre. Procediendo a mover.");
                // Primero reservamos la posición en el mapa
                TrafficController.map[getStreet()][actualAvenue] = 0;
                TrafficController.map[getStreet()][nextAvenue] = 1;
                System.out.println("Robot " + id + ": Mapa actualizado. Posición anterior [" + getStreet() + "][" + actualAvenue + "] = 0, Nueva [" + getStreet() + "][" + nextAvenue + "] = 1");
    
                // Luego hacemos el movimiento físico
                move();
                // Actualizar nuestras coordenadas después del movimiento
                this.avenue = nextAvenue;
                System.out.println("Robot " + id + ": Movimiento completado. Nueva posición interna: " + this.avenue);
            } else {
                System.out.println("Robot " + id + ": La posición [" + getStreet() + "][" + nextAvenue + "] está OCUPADA. No se puede mover.");
            }
            System.out.println("Verficiamos estado de posicion anterior ["+getStreet() + ","+ actualAvenue+ "]: " +TrafficController.map[getStreet()][actualAvenue] + "y de posicion actual ["+getStreet()+","+ nextAvenue+"]:" +TrafficController.map[getStreet()][nextAvenue]);
        } // ← Aquí se libera automáticamente el bloqueo
        System.out.println("Robot " + id + ": Salió del bloque synchronized.");
    }

    public void moveLeft(){
        // 1. Orientarse hacia el Oeste
        while(!facingWest()){
            turnLeft();
        }

        System.out.println("Robot " + id + ": Intentando moveLeft desde (" + getStreet() + ", " + getAvenue() + ")");
        
        // SYNCHRONIZED: Solo un robot puede acceder a esta sección a la vez
        synchronized(TrafficController.map) {
            System.out.println("Robot " + id + ": Entró al bloque synchronized (moveLeft).");
            int actualAvenue = getAvenue();
            int nextAvenue = actualAvenue - 1;

            if (nextAvenue < 0) {
                System.out.println("Robot " + id + ": ERROR - nextAvenue (" + nextAvenue + ") está fuera de los límites del mapa.");
                return;
            }

            System.out.println("Robot " + id + ": Verificando mapa en [" + getStreet() + "][" + nextAvenue + "]. Valor: " + TrafficController.map[getStreet()][nextAvenue]);

            if(TrafficController.map[getStreet()][nextAvenue] == 0){
                System.out.println("Robot " + id + ": La posición está libre. Procediendo a mover.");
                TrafficController.map[getStreet()][actualAvenue] = 0;
                TrafficController.map[getStreet()][nextAvenue] = 1;
                
                move();
                this.avenue = nextAvenue; // Actualizar coordenadas
                System.out.println("Robot " + id + ": Movimiento completado. Nueva posición interna: " + this.avenue);
            } else {
                System.out.println("Robot " + id + ": La posición [" + getStreet() + "][" + nextAvenue + "] está OCUPADA. No se puede mover.");
            }
        }
        System.out.println("Robot " + id + ": Salió del bloque synchronized (moveLeft).");
    }

    public void moveUp(){
        // 1. Orientarse hacia el Norte
        while(!facingNorth()){
            turnLeft();
        }

        System.out.println("Robot " + id + ": Intentando moveUp desde (" + getStreet() + ", " + getAvenue() + ")");

         // 2. Moverse de forma segura
        synchronized(TrafficController.map) {
            System.out.println("Robot " + id + ": Entró al bloque synchronized (moveUp).");
            int actualStreet = getStreet();
            int nextStreet = actualStreet - 1; // En Karel, 'arriba' es disminuir el número de la calle

            if (nextStreet < 0) {
                System.out.println("Robot " + id + ": ERROR - nextStreet (" + nextStreet + ") está fuera de los límites del mapa.");
                return;
            }
            
            System.out.println("Robot " + id + ": Verificando mapa en [" + nextStreet + "][" + getAvenue() + "]. Valor: " + TrafficController.map[nextStreet][getAvenue()]);

            if(TrafficController.map[nextStreet][getAvenue()] == 0){
                System.out.println("Robot " + id + ": La posición está libre. Procediendo a mover.");
                TrafficController.map[actualStreet][getAvenue()] = 0;
                TrafficController.map[nextStreet][getAvenue()] = 1;
                move();
                this.street = nextStreet;
                System.out.println("Robot " + id + ": Movimiento completado. Nueva posición interna: " + this.street);
            } else {
                 System.out.println("Robot " + id + ": La posición [" + nextStreet + "][" + getAvenue() + "] está OCUPADA. No se puede mover.");
            }
        }
        System.out.println("Robot " + id + ": Salió del bloque synchronized (moveUp).");
    }

    public void moveDown(){
        // 1. Orientarse hacia el Sur
        while(!facingSouth()){
            turnLeft();
        }

        System.out.println("Robot " + id + ": Intentando moveDown desde (" + getStreet() + ", " + getAvenue() + ")");

        synchronized(TrafficController.map) {
            System.out.println("Robot " + id + ": Entró al bloque synchronized (moveDown).");
            int actualStreet = getStreet();
            int nextStreet = actualStreet + 1; // En Karel, 'abajo' es aumentar el número de la calle

            if (nextStreet >= TrafficController.map.length) {
                System.out.println("Robot " + id + ": ERROR - nextStreet (" + nextStreet + ") está fuera de los límites del mapa.");
                return;
            }

            System.out.println("Robot " + id + ": Verificando mapa en [" + nextStreet + "][" + getAvenue() + "]. Valor: " + TrafficController.map[nextStreet][getAvenue()]);

            if(TrafficController.map[nextStreet][getAvenue()] == 0){
                System.out.println("Robot " + id + ": La posición está libre. Procediendo a mover.");
                TrafficController.map[actualStreet][getAvenue()] = 0;
                TrafficController.map[nextStreet][getAvenue()] = 1;
                move();
                this.street = nextStreet; // Actualizar coordenadas
                System.out.println("Robot " + id + ": Movimiento completado. Nueva posición interna: " + this.street);
            } else {
                System.out.println("Robot " + id + ": La posición [" + nextStreet + "][" + getAvenue() + "] está OCUPADA. No se puede mover.");
            }
        }
        System.out.println("Robot " + id + ": Salió del bloque synchronized (moveDown).");
    }
    

    public TransportRobot(int id, int street, int avenue, Direction dir, int beepers, Color color) {
        super(street, avenue, dir, beepers, color);
        this.id = id;
        this.passengers = 0;
        // Inicializar nuestras coordenadas con las mismas que recibe Karel
        this.avenue = avenue;
        this.street = street;
        World.setupThread(this);
        //Marcamos como ocupada la posición en la que se crean.
        synchronized (TrafficController.map) {
            TrafficController.map[getStreet()][getAvenue()] = 1;
        }
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
    public void run(){
        MiPrimerRobot.caminoAzulRapido(this);
    }
    // public void run() {
    //     while (true) {
    //         if (anyBeepersInBeeperBag() || loadPassengers()) {
    //             elegirCaminoSegunPosicion();
    //             int count = 0;
    //             while (count < 4) {
    //                 pickBeeper();
    //                 count++;
    //             }
    //         } else {
    //             turnOff();
    //             break;
    //         }
    //     }
    // }

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