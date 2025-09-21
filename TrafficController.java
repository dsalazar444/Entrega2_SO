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
