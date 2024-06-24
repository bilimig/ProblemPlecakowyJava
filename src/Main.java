import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter the seed: ");
        int seed = Integer.parseInt(scanner.nextLine());

        Problem problem = new Problem(seed, n);

        System.out.print("Enter the capacity: ");
        int capacity = Integer.parseInt(scanner.nextLine());

        problem.solve(capacity);
        problem.seeResult();

        scanner.close();
    }
}
