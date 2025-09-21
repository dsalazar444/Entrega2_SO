import kareltherobot.*;
import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.String;

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

    public String getDirection(){
        String dir="Default";
        if (facingEast()){
            dir="East";
        }
        if(facingNorth()){
            dir="North";
        }
        if(facingWest()){
            dir="West";
        }
        if(facingSouth()){
            dir="South";
        }
        return dir;
    }
    //De momento, sigo logica de moveRight, moveLeft (avanzamos en columna),
    //moveUp, moveDown (avanzamos en fila), para
    //evitar ambiguedad de moveLeft pero dependiendo de donde estemos mirando.
    
    public void moveRight() {
        // while(!facingEast()){ 
        //     System.out.println("Debug - dirección actual: " + getDirection());
        //     turnLeft(); 
        // }
        // System.out.println("Salí del while, dirección final: " + getDirection());

        //System.out.println("Robot " + id + ": Intentando moveRight desde (" + getStreet() + ", " + getAvenue() + ")");
    
        int actualAvenue = getAvenue();
        int nextAvenue = actualAvenue + 1;
    
        //System.out.println("Robot " + id + ": Posición actual: " + actualAvenue + ", Posición siguiente: " + nextAvenue);
    
        // SYNCHRONIZED: Solo un robot puede acceder a esta sección a la vez
        synchronized(TrafficController.map) {
            //System.out.println("Robot " + id + ": Entró al bloque synchronized.");
    
            if (nextAvenue >= TrafficController.map[0].length) {
                System.out.println("Robot " + id + ": ERROR - nextAvenue (" + nextAvenue + ") está fuera de los límites del mapa.");
                return; // Salir para evitar ArrayIndexOutOfBoundsException
            }
    
            //System.out.println("Robot " + id + ": Verificando mapa en [" + getStreet() + "][" + nextAvenue + "]. Valor: " + TrafficController.map[getStreet()][nextAvenue]);
    
            if(TrafficController.map[getStreet()][nextAvenue] == 0){
                //System.out.println("Robot " + id + ": La posición está libre. Procediendo a mover.");
                // Primero reservamos la posición en el mapa
                TrafficController.map[getStreet()][actualAvenue] = 0;
                TrafficController.map[getStreet()][nextAvenue] = 1;
                //System.out.println("Robot " + id + ": Mapa actualizado. Posición anterior [" + getStreet() + "][" + actualAvenue + "] = 0, Nueva [" + getStreet() + "][" + nextAvenue + "] = 1");
    
                // Luego hacemos el movimiento físico
                move();
                // Actualizar nuestras coordenadas después del movimiento
                this.avenue = nextAvenue;
                //System.out.println("Robot " + id + ": Movimiento completado. Nueva posición interna: " + this.avenue);
            } else {

                //System.out.println("Robot " + id + ": La posición [" + getStreet() + "][" + nextAvenue + "] está OCUPADA. No se puede mover.");
            }
            //System.out.println("Verficiamos estado de posicion anterior ["+getStreet() + ","+ actualAvenue+ "]: " +TrafficController.map[getStreet()][actualAvenue] + "y de posicion actual ["+getStreet()+","+ nextAvenue+"]:" +TrafficController.map[getStreet()][nextAvenue]);
        } // ← Aquí se libera automáticamente el bloqueo
        //System.out.println("Robot " + id + ": Salió del bloque synchronized.");
    }

    public void moveLeft(){
        // while(!facingWest()){ 
        //     System.out.println("Debug - dirección actual: " + getDirection());
        //     turnLeft(); 
        // }
        // System.out.println("Salí del while, dirección final: " + getDirection());

    
        synchronized(TrafficController.map) {
            int actualAvenue = getAvenue();
            int nextAvenue = actualAvenue - 1;
            if(TrafficController.map[getStreet()][nextAvenue] == 0){
                TrafficController.map[getStreet()][actualAvenue] = 0;
                TrafficController.map[getStreet()][nextAvenue] = 1;
                move();
                this.avenue = nextAvenue;
            }
        }
    }

    public void moveUp(){
        // 1. Orientarse hacia el Norte
        // while(!facingNorth()){
        //     System.out.println("no estoy mirando al norte (arriba) ");
        //     turnLeft();
        // }

         // 2. Moverse de forma segura
        synchronized(TrafficController.map) {
            int actualStreet = getStreet();
            int nextStreet = actualStreet + 1;
            if(TrafficController.map[nextStreet][getAvenue()] == 0){
                TrafficController.map[actualStreet][getAvenue()] = 0;
                TrafficController.map[nextStreet][getAvenue()] = 1;
                move();
                this.street = nextStreet;
            }
        }
    }

    public void moveDown(){
        // 1. Orientarse hacia el Sur
        // while (!facingSouth()) {
        //     System.out.println("no estoy mirando al sur (abajo) ");
        //     turnLeft();
        // }
    
        synchronized(TrafficController.map) {
            int actualStreet = getStreet();
            int nextStreet = actualStreet - 1;
            if(TrafficController.map[nextStreet][getAvenue()] == 0){
                TrafficController.map[actualStreet][getAvenue()] = 0;
                TrafficController.map[nextStreet][getAvenue()] = 1;
                move();
                this.street = nextStreet;
            }
        }
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
                    caminoAzulRapido();
                } else {
                    caminoAzulLargo();
                }
            } else if (estaEnPosicion(Posicion, this, 12, 23)) {
                if (rand.nextBoolean()) {
                    caminoVerdeRapido();
                } else {
                    caminoVerdeLargo();
                }
            }
        }
    }

    @Override
    public void run(){
        //caminoAzulRapido();
        // while (!facingSouth()) {
        //     System.out.println("no estoy mirando al sur (abajo) ");
        //     turnLeft();
        //     System.out.println(facingSouth());
        // }
        // System.out.println("sali");
        caminoAzulRapido();
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

    // ------------------- CAMINOS ---------------------

    public void caminoAzulRapido() {
        //moveRight
        System.out.println("robot"+id+"Empiezo, Ya llamo a moveRigth,");
        for(int i=0; i<23; i++) moveRight();
        turnLeft();

         
        System.out.println("robot"+id+"Ya llamo a moveUp");
        //moveUp
        for(int i=0; i<11; i++) moveUp();   
        
        while(anyBeepersInBeeperBag()) putBeeper();

        //moveUp
        System.out.println("robot"+id+ "Ya llamo a moveUp again");
        for(int i=0; i<4; i++) moveUp(); 
        turnLeft();

        //moveLeft
        System.out.println("robot"+id+"Ya llamo a Left");
        for(int i=0; i<1; i++) moveLeft();
        turnLeft();

        //movedown
        System.out.println("robot"+id+"Ya llamo a down");
        for(int i=0; i<1; i++) moveDown();
        turnRight();
        
        
        System.out.println("robot"+id+"Ya llamo a left");
        for(int i=0; i<6; i++){
            moveLeft();
            System.out.println(i);
        } 
        turnLeft();

        //movedown
        System.out.println("robot"+id+"Ya llamo a down");
        for(int i=0; i<1; i++) moveDown();
        turnLeft();

        //moveright
        System.out.println("robot"+id+"Ya llamo a right");
        for(int i=0; i<6; i++) moveRight();
        turnRight();

        //movedown
        System.out.println("robot"+id+"Ya llamo a down");
        for(int i=0; i<2; i++) moveDown();
        turnRight();

    
        for(int i=0; i<1; i++) moveLeft();
        turnRight();

        //moveup
        for(int i=0; i<1; i++) moveUp();
        turnLeft();

        //moveleft
        for(int i=0; i<5; i++) moveLeft();
        turnLeft();

        //movedown
        for(int i=0; i<1; i++) moveDown();
    }


        // Zona Verde - Camino Rápido 
    public void caminoVerdeRapido() {

        //movedown
        for(int i=0; i<2; i++) move(); 
        //turnLeft();

        //moveright
        for(int i=0; i<7; i++) move(); 
        //turnRight();

        //movedown
        for(int i=0; i<5; i++) move(); 
        //turnRight();

        //moveleft
        for(int i=0; i<1; i++) move(); 
        //turnLeft();

        //movedown
        for(int i=0; i<4; i++) move(); 
        //turnRight();

        //moveleft
        for(int i=0; i<3; i++) move(); 
        //turnRight();

        //moveup
        for(int i=0; i<1; i++) move(); 
        //turnLeft();

        //moveleft
        for(int i=0; i<5; i++) move();
        //turnLeft();

        //movedown
        for(int i=0; i<1; i++) move();
        //turnRight();

        //moveleft
        for(int i=0; i<5; i++) move();
        //turnRight();

        //moveup
        for(int i=0; i<1; i++) move();
        //turnLeft();

        //moveleft
        for(int i=0; i<7; i++) move();
        
        //descargamos
        while(anyBeepersInBeeperBag()) putBeeper();

        //moveup
        for (int i=0; i<1; i++) move();
        //turnRight();

        //moveleft
        for (int i=0; i<2; i++) move();
        //turnLeft();

        //movedown
        for (int i=0; i<7; i++) move();
        //turnLeft();

        //moveright
        for (int i=0; i<1; i++) move();
        //turnLeft();
        
        //movedown
        for (int i=0; i<6; i++) move();
        //turnRight();
        for (int i=0; i<1; i++) move();
        //turnRight();
        for (int i=0; i<6; i++) move();
        //turnLeft();
        for (int i=0; i<1; i++) move();
        //turnLeft();
        for (int i=0; i<6; i++) move();
    }

    // Zona Azul - Camino Largo 
    public void caminoAzulLargo() {
        for(int i=0; i<4; i++) move(); 
        //turnLeft(); 
        for(int i=0; i<10; i++) move(); 
        //turnLeft();
        for(int i=0; i<3; i++) move();
        //turnRight();
        for(int i=0; i<3; i++) move();
        //turnRight();
        for(int i=0; i<8; i++) move();
        //turnRight();
        for(int i=0; i<4; i++) move();
        //turnRight();
        for(int i=0; i<3; i++) move();
        //turnLeft();
        
        for(int i=0; i<5; i++) move();
        
        //turnLeft();
        for(int i=0; i<7; i++) move();
        //turnLeft();
        for(int i=0; i<5; i++) move();
        //turnRight();
        for(int i=0; i<10; i++) move();
        //turnLeft();
        for(int i=0; i<2; i++) move();
        while(anyBeepersInBeeperBag()) putBeeper();

        for(int i=0; i<4; i++) move(); 
        //turnLeft();
        for(int i=0; i<1; i++) move();
        //turnLeft();
        for(int i=0; i<1; i++) move();
        //turnRight();
        for(int i=0; i<6; i++) move();

        //turnLeft();
        for(int i=0; i<1; i++) move();
        //turnLeft();
        for(int i=0; i<6; i++) move();
        //turnRight();
        for(int i=0; i<2; i++) move();
        //turnRight();
        for(int i=0; i<1; i++) move();
        //turnRight();
        for(int i=0; i<1; i++) move();
        //turnLeft();
        for(int i=0; i<5; i++) move();
        //turnLeft();
        for(int i=0; i<1; i++) move();
    }
    // Zona Verde - Camino Largo 
    public void caminoVerdeLargo() {
        move();
        //turnRight();
        

        for (int i=0; i<3; i++) move();
        //turnRight();

        for (int i=0; i<8; i++) move();

        //turnLeft();
        for (int i=0; i<2; i++) move();

        //turnLeft();
        for (int i=0; i<4; i++) move();

        //turnRight();
        for (int i=0; i<17; i++) move();

        //turnLeft();
        for (int i=0; i<5; i++) move();
        
        //turnLeft();
        for (int i=0; i<9; i++) move();
        //turnRight();
        for (int i=0; i<8; i++) move();

        //turnRight();
        for (int i=0; i<1; i++) move();
        

        while(anyBeepersInBeeperBag()) putBeeper();
        for (int i=0; i<1; i++) move();
        //turnRight();
        for (int i=0; i<2; i++) move();
        //turnLeft();
        for (int i=0; i<7; i++) move();
        //turnLeft();
        for (int i=0; i<1; i++) move();
        //turnLeft();
        for (int i=0; i<6; i++) move();
        //turnRight();
        for (int i=0; i<1; i++) move();
        //turnRight();
        for (int i=0; i<6; i++) move();
        //turnLeft();
        for (int i=0; i<1; i++) move();
        //turnLeft();
        for (int i=0; i<6; i++) move();
    }
}