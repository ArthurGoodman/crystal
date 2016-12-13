import java.util.Random;

public class Worker implements Runnable {
    private Random random = new Random();
    private int i = 0;

    public void run() {
        while (true) {
            int delta = -1;

            if (random.nextDouble() < Crystal.getP() && i > 0) {
                delta = -1;
            } else if (i < Crystal.getN() - 1)
                delta = 1;

            synchronized (Crystal.getCrystal()) {
                Crystal.getCrystal()[i]--;
                Crystal.getCrystal()[i + delta]++;
            }

            i += delta;

            try {
                Thread.sleep(10);
            } catch (InterruptedException ignored) {
                break;
            }
        }
    }
}
