import java.util.concurrent.Semaphore;
public class ZonasCriticas {
    private final Semaphore mutex = new Semaphore(1, true);

    private int dentroNorte = 0;
    private int dentroSur = 0;
    private int pasaronNorte = 0;
    private int pasaronSur = 0;

    private int turno3sur = 1;
    private String turno = ""; // NORTE o SUR

    public void entrarNorte() throws InterruptedException {
        while (true) {
            mutex.acquire();
            if (turno.equals("")) {
                turno = "NORTE";
            }

            if (turno.equals("NORTE") && pasaronNorte < 4) {
                dentroNorte++;
                pasaronNorte++;
                mutex.release();
                return;
            }
            mutex.release();
            Thread.sleep(10); // Evita busy-wait
        }
    }

    public void entrarSur() throws InterruptedException {
        while (true) {
            mutex.acquire();
            if (turno.equals("")) {
                turno = "SUR";
            }

            if (turno.equals("SUR") && pasaronSur < 4) {
                dentroSur++;
                pasaronSur++;
                mutex.release();
                return;
            }
            mutex.release();
            Thread.sleep(10); // Evita busy-wait
        }
    }

    public void salirZona(String lado) {
        try {
            mutex.acquire();
            if (lado.equals("NORTE")) {
                dentroNorte--;
                if (pasaronNorte == 4 && dentroNorte == 0) {
                    pasaronNorte = 0;
                    pasaronSur = 0;
                    dentroSur=0;
                    turno = "SUR";
                }
            } else if (lado.equals("SUR")) {
                dentroSur--;
                if (pasaronSur == 4 && dentroSur == 0) {
                    pasaronSur = 0;
                    pasaronNorte = 0;
                    dentroNorte=0;
                    turno = "NORTE";
                }
            }

            System.out.println("Salida " + lado + ". Dentro Norte: " + dentroNorte + ", Dentro Sur: " + dentroSur + ", Pasaron Sur: " + pasaronSur + ", Pasaron Norte: " + pasaronNorte + ", Turno: " + turno);
            mutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getTurno() {
        try {
            mutex.acquire();
            String t = turno;
            mutex.release();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getTurno3sur() {
        try {
            mutex.acquire();
            int t = turno3sur;
            mutex.release();
            return t;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public void setTurno(String nuevoTurno) {
    try {
        mutex.acquire();
        turno = nuevoTurno;
        
        mutex.release();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
}

   public void setTurno3sur(int nuevoTurno) {
    try {
        mutex.acquire();
        turno3sur = nuevoTurno;

        mutex.release();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    }

}
