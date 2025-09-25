import java.util.concurrent.Semaphore;
public class ZonasCriticas {
    private final Semaphore mutex = new Semaphore(1, true);

    private int dentroNorte = 0;
    private int dentroSur = 0;
    private int pasaronNorte = 0;
    private int pasaronSur = 0;
    private int esperandoNorte = 0;
    private int esperandoSur = 0;


    private int turno3sur = 1;
    private String turno = ""; // NORTE o SUR

    public void entrarNorte() throws InterruptedException {
    while (true) {
        mutex.acquire();
        esperandoNorte++;

        if (turno.equals("")) {
            turno = "NORTE";
        }

        if (turno.equals("NORTE") && pasaronNorte < 4) {
            esperandoNorte--;
            dentroNorte++;
            pasaronNorte++;
            mutex.release();

            System.out.println(">> Entrada NORTE: dentroNorte=" + dentroNorte + " turno=" + turno);
            return;
        }

        // Solo cambiar de turno si:
        // - ya pasaron 4 del norte
        // - nadie más está dentro
        // - Y HAY alguien esperando del SUR
        if (pasaronNorte == 4 && dentroNorte == 0 && esperandoSur > 0) {
            pasaronNorte = 0;
            pasaronSur = 0;
            turno = "SUR";
        }

        mutex.release();
        Thread.sleep(10);
    }
}
public void entrarSur() throws InterruptedException {
    while (true) {
        mutex.acquire();
        esperandoSur++;

        if (turno.equals("")) {
            turno = "SUR";
        }

        if (turno.equals("SUR") && pasaronSur < 4) {
            esperandoSur--;
            dentroSur++;
            pasaronSur++;
            mutex.release();

            System.out.println(">> Entrada SUR: dentroSur=" + dentroSur + " turno=" + turno);
            return;
        }

        if (pasaronSur == 4 && dentroSur == 0 && esperandoNorte > 0) {
            pasaronSur = 0;
            pasaronNorte = 0;
            turno = "NORTE";
        }

        mutex.release();
        Thread.sleep(10);
    }
}


    public void salirZona(String lado) {
        try {
            mutex.acquire();
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
    
    public void setTurno(String nuevoTurno) {
    try {
        mutex.acquire();
        turno = nuevoTurno;
        
        mutex.release();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
}

   
}
