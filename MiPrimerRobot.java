import kareltherobot.*;
import java.awt.Color;

public class MiPrimerRobot implements Directions {
    public static void main(String[] args) {
        World.setDelay(0);
        World.readWorld("Mundo2.kwld");
        World.setVisible(true);        

        // --- BLOQUE 1: CREACIÓN DE ROBOTS ---
        TransportRobot r0 = new TransportRobot(0, 1, 7, East, 0, Color.blue);
        TransportRobot r1 = new TransportRobot(1, 1, 6, East, 0, Color.blue);
        TransportRobot r2 = new TransportRobot(2, 1, 5, East, 0, Color.blue);
        TransportRobot r3 = new TransportRobot(3, 1, 4, East, 0, Color.blue);
        TransportRobot r4 = new TransportRobot(4, 1, 3, East, 0, Color.blue);
        TransportRobot r5 = new TransportRobot(5, 1, 2, East, 0, Color.blue);
        TransportRobot r6 = new TransportRobot(6, 1, 1, East, 0, Color.blue);
        TransportRobot r7 = new TransportRobot(7, 2, 7, West, 0, Color.blue);
        TransportRobot r8 = new TransportRobot(8, 2, 6, West, 0, Color.blue);
        TransportRobot r9 = new TransportRobot(9, 2, 5, West, 0, Color.blue);
        TransportRobot r10 = new TransportRobot(10, 2, 4, West, 0, Color.blue);
        TransportRobot r11 = new TransportRobot(11, 2, 3, West, 0, Color.blue);
        TransportRobot r12 = new TransportRobot(12, 2, 2, West, 0, Color.blue);
        TransportRobot r13 = new TransportRobot(13, 2, 1, South, 0, Color.blue);
        TransportRobot r14 = new TransportRobot(14, 3, 7, South, 0, Color.blue);
        TransportRobot r15 = new TransportRobot(15, 3, 6, East, 0, Color.blue);
        TransportRobot r16 = new TransportRobot(16, 3, 5, East, 0, Color.blue);
        TransportRobot r17 = new TransportRobot(17, 3, 4, East, 0, Color.blue);
        TransportRobot r18 = new TransportRobot(18, 3, 3, East, 0, Color.blue);
        TransportRobot r19 = new TransportRobot(19, 3, 2, East, 0, Color.blue);
        TransportRobot r20 = new TransportRobot(20, 3, 1, East, 0, Color.blue);
        TransportRobot r21 = new TransportRobot(21, 4, 7, West, 0, Color.blue);
        TransportRobot r22 = new TransportRobot(22, 4, 6, West, 0, Color.blue);
        TransportRobot r23 = new TransportRobot(23, 4, 5, West, 0, Color.blue);
        TransportRobot r24 = new TransportRobot(24, 4, 4, West, 0, Color.blue);
        TransportRobot r25 = new TransportRobot(25, 4, 3, West, 0, Color.blue);
        TransportRobot r26 = new TransportRobot(26, 4, 2, West, 0, Color.blue);
        TransportRobot r27 = new TransportRobot(27, 4, 1, South, 0, Color.blue);
        TransportRobot r28 = new TransportRobot(28, 12, 23, South, 0, Color.green);
        TransportRobot r29 = new TransportRobot(29, 13, 23, South, 0, Color.green);
        TransportRobot r30 = new TransportRobot(30, 13, 24, West, 0, Color.green);
        TransportRobot r31 = new TransportRobot(31, 13, 25, West, 0, Color.green);
        TransportRobot r32 = new TransportRobot(32, 13, 26, West, 0, Color.green);
        TransportRobot r33 = new TransportRobot(33, 13, 27, West, 0, Color.green);
        TransportRobot r34 = new TransportRobot(34, 13, 28, West, 0, Color.green);
        TransportRobot r35 = new TransportRobot(35, 12, 28, North, 0, Color.green);
        TransportRobot r36 = new TransportRobot(36, 12, 29, West, 0, Color.green);
        TransportRobot r37 = new TransportRobot(37, 13, 29, South, 0, Color.green);
        TransportRobot r38 = new TransportRobot(38, 14, 23, East, 0, Color.green);
        TransportRobot r39 = new TransportRobot(39, 14, 24, East, 0, Color.green);
        TransportRobot r40 = new TransportRobot(40, 14, 25, East, 0, Color.green);
        TransportRobot r41 = new TransportRobot(41, 14, 26, East, 0, Color.green);
        TransportRobot r42 = new TransportRobot(42, 14, 27, East, 0, Color.green);
        TransportRobot r43 = new TransportRobot(43, 14, 28, East, 0, Color.green);
        TransportRobot r44 = new TransportRobot(44, 14, 29, South, 0, Color.green);
        TransportRobot r45 = new TransportRobot(45, 15, 23, South, 0, Color.green);
        TransportRobot r46 = new TransportRobot(46, 15, 24, West, 0, Color.green);
        TransportRobot r47 = new TransportRobot(47, 15, 25, West, 0, Color.green);
        TransportRobot r48 = new TransportRobot(48, 15, 26, West, 0, Color.green);
        TransportRobot r49 = new TransportRobot(49, 15, 27, West, 0, Color.green);
        TransportRobot r50 = new TransportRobot(50, 15, 28, West, 0, Color.green);
        TransportRobot r51 = new TransportRobot(51, 15, 29, West, 0, Color.green);
        TransportRobot r52 = new TransportRobot(52, 16, 29, South, 0, Color.green);
        TransportRobot r53 = new TransportRobot(53, 16, 30, West, 0, Color.green);
        TransportRobot r54 = new TransportRobot(54, 15, 30, North, 0, Color.green);
        TransportRobot r55 = new TransportRobot(55, 14, 30, North, 0, Color.green);

        TransportRobot[] robots = {
        r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27,
        r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55
    };
        World.setDelay(5);

        for (TransportRobot robot : robots) {
            new Thread(robot).start();
        }
    }

}
