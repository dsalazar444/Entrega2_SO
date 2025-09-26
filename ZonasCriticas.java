import java.util.concurrent.Semaphore;
public class ZonasCriticas {
    private final Semaphore semaforo = new Semaphore(1, true);

    private int dentroNorte = 0;
    private int dentroSur = 0;
    private int pasaronNorte = 0;
    private int pasaronSur = 0;
    private int esperandoNorte = 0;
    private int esperandoSur = 0;

    private String turno = ""; // NORTE o SUR

    // --- NUEVO ---
    private long inicioEsperaNorte = 0;
    private long inicioEsperaSur = 0;
    private static final long LIMITE_ESPERA = 80_000; // 80 segundos
    // -------------

    public void entrarNorte() throws InterruptedException {
        while (true) {
            semaforo.acquire();

            if (esperandoNorte == 0) {
                inicioEsperaNorte = System.currentTimeMillis(); // primer norte en esperar
            }
            esperandoNorte++;

            if (turno.equals("")) {
                turno = "NORTE";
            }

            // --- NUEVO: forzar cambio por tiempo ---
            if (esperandoNorte > 0 && (System.currentTimeMillis() - inicioEsperaNorte) >= LIMITE_ESPERA) {
                turno = "NORTE";
                pasaronNorte = 0;
                pasaronSur = 0;
            }
            // --------------------------------------

            if (turno.equals("NORTE") && pasaronNorte < 4) {
                esperandoNorte--;
                dentroNorte++;
                pasaronNorte++;
                if (esperandoNorte == 0) inicioEsperaNorte = 0; // reinicio
                semaforo.release();

                System.out.println(">> Entrada NORTE: dentroNorte=" + dentroNorte + " turno=" + turno);
                return;
            }

            if (pasaronNorte == 4 && dentroNorte == 0 && esperandoSur > 0) {
                pasaronNorte = 0;
                pasaronSur = 0;
                turno = "SUR";
            }

            semaforo.release();
            Thread.sleep(10);
        }
    }

    public void entrarSur() throws InterruptedException {
        while (true) {
            semaforo.acquire();

            if (esperandoSur == 0) {
                inicioEsperaSur = System.currentTimeMillis(); // primer sur en esperar
            }
            esperandoSur++;

            if (turno.equals("")) {
                turno = "SUR";
            }

            // --- NUEVO: forzar cambio por tiempo ---
            if (esperandoSur > 0 && (System.currentTimeMillis() - inicioEsperaSur) >= LIMITE_ESPERA) {
                turno = "SUR";
                pasaronNorte = 0;
                pasaronSur = 0;
            }
            // --------------------------------------

            if (turno.equals("SUR") && pasaronSur < 4) {
                esperandoSur--;
                dentroSur++;
                pasaronSur++;
                if (esperandoSur == 0) inicioEsperaSur = 0; // reinicio
                semaforo.release();

                System.out.println(">> Entrada SUR: dentroSur=" + dentroSur + " turno=" + turno);
                return;
            }

            if (pasaronSur == 4 && dentroSur == 0 && esperandoNorte > 0) {
                pasaronSur = 0;
                pasaronNorte = 0;
                turno = "NORTE";
            }

            semaforo.release();
            Thread.sleep(10);
        }
    }

    public void salirZona(String lado) {
        try {
            semaforo.acquire();
            if (lado.equals("NORTE")) {
                dentroNorte--;
                if (pasaronNorte == 4 && dentroNorte == 0) {
                    pasaronNorte = 4;
                    pasaronSur = 0;
                    dentroNorte=0;
                    dentroSur=0;
                    turno = "SUR";
                }
            } else if (lado.equals("SUR")) {
                dentroSur--;
                if (pasaronSur == 4 && dentroSur == 0) {
                    pasaronSur = 4;
                    pasaronNorte = 0;
                    dentroNorte=0;
                    dentroSur=0;
                    turno = "NORTE";
                }
            }

            System.out.println("Salida " + lado + ". Dentro Norte: " + dentroNorte + ", Dentro Sur: " + dentroSur + ", Pasaron Sur: " + pasaronSur + ", Pasaron Norte: " + pasaronNorte + ", Turno: " + turno);
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getTurno() {
        try {
            semaforo.acquire();
            String t = turno;
            semaforo.release();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public void setTurno(String nuevoTurno) {
        try {
            semaforo.acquire();
            turno = nuevoTurno;
            semaforo.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

