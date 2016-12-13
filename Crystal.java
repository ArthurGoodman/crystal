import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Crystal {
    private static ExecutorService executor;

    private static int[] crystal;

    private static int n;
    private static int m;
    private static double p;

    public static void initialize() {
        crystal = new int[n];
        crystal[0] = m;
    }

    public static void dump() {
        int sum = 0;

        for (int c : crystal) {
            sum += c;
            System.out.print(c + " ");
        }

        System.out.println("; sum = " + sum);
    }

    public static void runThreads() {
        executor = Executors.newFixedThreadPool(m);

        for (int i = 0; i < m; i++)
            executor.execute(new Worker());
    }

    public static void monitor() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

            Crystal.dump();
        }
    }

    public static void shutdownThreads() {
        executor.shutdownNow();

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {
        }
    }

    public static int[] getCrystal() {
        return crystal;
    }

    public static int getN() {
        return n;
    }

    public static void setM(int m) {
        Crystal.m = Math.max(0, Math.min(m, 1000));
    }

    public static void setN(int n) {
        Crystal.n = Math.max(1, Math.min(n, 1000));
    }

    public static double getP() {
        return p;
    }

    public static void setP(double p) {
        Crystal.p = Math.max(0.0, Math.min(p, 1.0));
    }
}
