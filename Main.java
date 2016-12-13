import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("n = ");
            Crystal.setN(scanner.nextInt());

            System.out.print("m = ");
            Crystal.setM(scanner.nextInt());

            System.out.print("p = ");
            Crystal.setP(scanner.nextDouble());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        Crystal.initialize();
        Crystal.dump();
        Crystal.runThreads();
        Crystal.monitor();
        Crystal.shutdownThreads();
        Crystal.dump();
    }
}
