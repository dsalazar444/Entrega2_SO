import java.util.concurrent.Semaphore;

public class mapaOcupacion {
    private static final int MAX_FILAS = 20; // ajusta al tamaño del mundo Karel
    private static final int MAX_COLUMNAS = 31;
    private static final Semaphore[][] grid = new Semaphore[MAX_FILAS][MAX_COLUMNAS];

    static {
        for (int i = 0; i < MAX_FILAS; i++) {
            for (int j = 0; j < MAX_COLUMNAS; j++) {
                grid[i][j] = new Semaphore(1); // cada celda solo 1 robot
            }
        }
    }

    public static void ocupar(int fila, int columna) throws InterruptedException {
        grid[fila- 1][columna- 1].acquire(); // espera hasta que la celda esté libre
    }

    public static void liberar(int fila, int columna) {
        grid[fila- 1][columna- 1].release(); // libera la celda
    }
}
