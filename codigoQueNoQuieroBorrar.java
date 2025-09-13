import kareltherobot.*;
import java.awt.Color;
public class MiPrimerRobot implements Directions
{
        public static void main(String [] args)
        {
// Usamos el archivo que creamos del mundo
        World.readWorld("Mundo2.kwld");

        World.setVisible(true);
// Coloca el robot en la posición inicial del mundo (1,1),
// mirando al Este, sin ninguna sirena.
        Robot Karel = new Robot(1, 1, East, 0);
        Robot Karel2 = new Robot(1, 1, East, 0,  Color.blue);
// Mover el robot 4 pasos
        Karel.move();
        Karel2.move();
        Karel.move();
        Karel2.move();
        Karel.move();
        Karel2.move();
        Karel.move();
        Karel2.move();
// Recoger los 5 beepers
        Karel.pickBeeper();
        Karel.pickBeeper();
        Karel.pickBeeper();
        Karel.pickBeeper();
        Karel.pickBeeper();
// Girar a la izquierda y salir de los muros
        Karel.turnLeft();
        Karel.move();
        Karel2.turnLeft();
        Karel2.move();
        Karel.move();
        Karel2.move();
// Poner los beepers fuera de los muros
        Karel.putBeeper();
        Karel.putBeeper();
        Karel.putBeeper();
        Karel.putBeeper();
        Karel.putBeeper();
// Ponerse en otra posición y apagar el robot
        Karel.move();
        Karel.turnOff();
        Karel2.move();
        Karel2.turnOff();
        }
}

/*class Racer extends Robot
{
    public Racer(int Street, int Avenue, Direction direction, int beeps, Color color)
    {
        super(Street, Avenue, direction, beeps);
        World.setupThread(this);
    }
    public void race()
    {
        while(! nextToABeeper())
             move();
        pickBeeper();
        turnOff();
    }
    public void run()
    {
        race();
    }
}

public static void main(String [] args)
{
    Racer first = new Racer(1, 1, East, 0);
    Racer second = new Racer(2, 1, East, 0, Color.blue);
}*/