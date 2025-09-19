class TrafficController {
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
