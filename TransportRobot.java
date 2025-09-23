import kareltherobot.*;
import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.String;

class TransportRobot extends Robot implements Runnable {
    private int passengers;
    public int id;
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

    public void setStreet(int street){
        this.street = street;
    }

    public void setAvenue(int avenue){
        this.avenue = avenue;
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
        int actualAvenue = getAvenue();
        int actualStreet = getStreet();
        int nextAvenue = actualAvenue + 1;

        System.out.println("robot "+id + "entré a move Right");
        //Verificamos que no se quiera salir del mapa
        if (nextAvenue >= TrafficController.map[0].length) {
            System.out.println("Robot " + id + ": ERROR - nextAvenue (" + nextAvenue + ") está fuera de los límites del mapa.");
            return; // Salir para evitar ArrayIndexOutOfBoundsException
        }
        while(!TrafficController.tryMove(actualStreet, actualAvenue, actualStreet, nextAvenue, this)){
            System.out.println("robot "+id+" no me pude mover");
            //TrafficController.tryMove(actualStreet, actualAvenue, actualStreet, nextAvenue, this);
        }
        
    }

    public void moveLeft(){
        // while(!facingWest()){ 
        //     System.out.println("Debug - dirección actual: " + getDirection());
        //     turnLeft(); 
        // }
        // System.out.println("Salí del while, dirección final: " +
        // getDirection());
        System.out.println("robot "+id + "entré a move Left");
        int actualAvenue = getAvenue();
        int actualStreet = getStreet();
        int nextAvenue = actualAvenue - 1;
    
        //Verificamos que no se quiera salir del mapa
        if (nextAvenue < 0) {
            System.out.println("Robot " + id + ": ERROR - nextAvenue (" + nextAvenue + ") está fuera de los límites del mapa.");
            return; // Salir para evitar ArrayIndexOutOfBoundsException
        }

        //TrafficController.tryMove(actualStreet, actualAvenue, actualStreet,nextAvenue, this);
        while(!TrafficController.tryMove(actualStreet, actualAvenue, actualStreet,nextAvenue, this)){
            System.out.println("robot "+id+" no me pude mover");
            //TrafficController.tryMove(actualStreet, actualAvenue, actualStreet,nextAvenue, this);
        }
        
        
    }
    

    public void moveUp(){
        // 1. Orientarse hacia el Norte
        // while(!facingNorth()){
        //     System.out.println("no estoy mirando al norte (arriba) ");
        //     turnLeft();
        // }
        System.out.println("robot "+id + "entré a move Up");

        int actualAvenue = getAvenue();
        int actualStreet = getStreet();
        int nextStreet = actualStreet + 1;
    
        //Verificamos que no se quiera salir del mapa
        if (nextStreet >= TrafficController.map.length) {
            System.out.println("Robot " + id + ": ERROR - nextStreet (" + nextStreet + ") está fuera de los límites del mapa.");
            return; // Salir para evitar ArrayIndexOutOfBoundsException
        }

        
        while(!TrafficController.tryMove(actualStreet, actualAvenue, nextStreet, actualAvenue, this)){
            System.out.println("robot "+id+" no me pude mover");
            //TrafficController.tryMove(actualStreet, actualAvenue, nextStreet, actualAvenue, this);
        }
    }

    public void moveDown(){
        // 1. Orientarse hacia el Sur
        // while (!facingSouth()) {
        //     System.out.println("no estoy mirando al sur (abajo) ");
        //     turnLeft();
        // }
        System.out.println("robot "+id + "entré a move Down");
        int actualAvenue = getAvenue();
        int actualStreet = getStreet();
        int nextStreet = actualStreet - 1;
    
        //Verificamos que no se quiera salir del mapa
        if (nextStreet < 0) {
            System.out.println("Robot " + id + ": ERROR - nextStreet (" + nextStreet + ") está fuera de los límites del mapa.");
            return; // Salir para evitar ArrayIndexOutOfBoundsException
        }

    
        while(!TrafficController.tryMove(actualStreet, actualAvenue, nextStreet, actualAvenue, this)){
            System.out.println("robot "+id+" no me pude mover");
            //TrafficController.tryMove(actualStreet, actualAvenue, nextStreet, actualAvenue, this);
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
        synchronized(TrafficController.cellLocks[street][avenue]) {
        TrafficController.map[street][avenue] = 1;
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
        for(int i=0; i<6; i++) moveLeft();
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