import java.util.concurrent.Semaphore;


//Donde manejaremos lógica de todos los semaforos, desde un unico objeto trafficController
class TrafficController {
    // Definimos matriz del mapa, para evitar que dos robots estén en la misma
    // ubicación.
    // Java la inicializa en 0 automaticamente. La ponemos como static para que
    // todos los objetos TrafficControler accedan a la misma, pero se supone
    // trabajaremos con un unico traficcController, entonces después le podemos
    // quitar el static
    public static int[][] map = new int[20][31];

    //Semaforo para cruce a punto de carga
    private static Semaphore sem1 = new Semaphore(1, true);
    //Semaforo para calle doblevia 1
    private static Semaphore sem2 = new Semaphore(4, true);
    //Semaforo para calle doblevia 2
    private static Semaphore sem3 = new Semaphore(2, true);

    //Semaforo para avenida doblevia 1
    private static Semaphore sem4 = new Semaphore(4, true);
    //Semaforo para inicio de ruta verde
    private static Semaphore sem5 = new Semaphore(1, true);

    //Fine-graned locks -> creamos matriz con locks para cada posición del mapa
    public static Object[][] cellLocks = new Object[20][31];

    //Llenamos la matriz cellLocks -> Con static indicamos que se haga una única vez, al cargar la CLASE en memoria (independiente de n hijos, se hará una vez.)
    static {
        for(int i=0;i<20;i++){
            for(int j=0; j<31;j++){
                cellLocks[i][j]= new Object();
            }
        }
    }

    //-------------------Funciones------------------------

    //Debemos asegurar que los Locks se obtengan siempre en el mismo orden, para evitar deadlocks
    public static Object[] getOrderedLocks (int street1, int avenue1, int street2, int avenue2){
        //Obtenemos locks
        Object lock1 = cellLocks[street1][avenue1];
        Object lock2 = cellLocks[street2][avenue2];
        
        // REGLA: Ordenar por street primero, luego por avenue
        if (street1 < street2 || (street1 == street2 && avenue1 < avenue2)) {
            return new Object[]{lock1, lock2};  // Orden correcto -> lock1 es el de la posición menor
        } else {
            return new Object[]{lock2, lock1};  // Invertir orden, porque lock1 será el de la posición mayor, y nosotros queremos que sea siempre, lock menor, luego lock mayor
        }
    }

    public static boolean tryMove (int fromStreet, int fromAvenue, int toStreet, int toAvenue, TransportRobot r){
        //Obtenemos lista con locks ordenados
        System.out.println("--------------");
        Object[] locks = getOrderedLocks(fromStreet, fromAvenue, toStreet, toAvenue);
        
        synchronized(locks[0]) { //El primer lock será el de la posición menor
            synchronized(locks[1]) {
                int count=0;
                // esperamos hasta que la celda esté libre
                // while(map[toStreet][toAvenue] != 0) {
                //     count++;
                    // Esto es necesario ya que con synchronized solo aseguramos
                    // el acceso a un recurso, más no que el robot se mueva,
                    // entonces si este puede acceder, pero no moverse, usamos
                    // el ciclo para que solo salga del synchronized una vez se
                    // movió. Esto no causa muchos problemas ya que estariamos
                    // bloqueando solo dos casillas.
                //     System.out.println("Robot" + r.id +" -> estoy esperando liberación del recurso mapa" + toStreet +","+ toAvenue + " que esta en: " +map[toStreet][toAvenue]);
                //     if (count > 3){
                //         System.out.println("Robot" + r.id +" -> me cansé de esperar, bye");
                //         return;
                //     }
                    
                //     // Ceder control al scheduler para permitir context switch
                //     //Thread.yield();
                // }
                //Fue necesario porque con return se devolvia a move, luego a
                //caminoAzul, y actualizaba marcador sin haberse movido
                if(map[toStreet][toAvenue] != 0) return false;

                //Actualizamos mapa
                map[fromStreet][fromAvenue] = 0;  // Liberar origen
                System.out.println("Robot" + r.id +"Liberé mi casilla "+ fromStreet +","+ fromAvenue +" , que esta en: " +map[fromStreet][fromAvenue] );
                map[toStreet][toAvenue] = 1;      // Ocupar destino
                System.out.println("Robot" + r.id +"Ocupé casilla "+ toStreet +","+ toAvenue +" , que esta en: " +map[toStreet][toAvenue] );

                r.move();
                //actualizamos coordenadas del robot
                r.setStreet(toStreet);
                r.setAvenue(toAvenue);
                System.out.println("Robot" + r.id +" -> Ya me moví :)" );
                return true;
            }
        }
    }


    //-------------Funciones para los semaforos---------------------
    public static boolean isInSem1Section(int street, int avenue) {
        return ((street == 2) && (avenue >= 10) && (avenue <= 11));
    }


    //Faltan las demás zonas
    
    
     
    public static void enterBlue() throws InterruptedException {
        //blueSection.acquire();
    }

    public static void leaveBlue() {
        //blueSection.release();
    }

    public static void enterGreen() throws InterruptedException {
        //greenSection.acquire();
    }

    public static void leaveGreen() {
        //greenSection.release();
    }
}
