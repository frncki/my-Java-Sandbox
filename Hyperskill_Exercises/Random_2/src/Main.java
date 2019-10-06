/*
Given the number N, and the numbers A and B, output sum of the first N random numbers in a range from A to B inclusively. The seed should be a number A+B.
Input contains numbers N, A, B in a single line in this order.

Sample Input 1:
100 5 10

Sample Output 1:
734
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = 0;
        Random random = new Random();
        random.setSeed(a+b);
        for (int i = 0; i < n; i ++) {
            sum += random.nextInt(b - a + 1) + a;
        }
        System.out.println(sum);
    }
}

/*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        final int a = scanner.nextInt();
        final int b = scanner.nextInt();

        final Random random = new Random(a + b);
        int sum = 0;

        while (n-- > 0) {
            sum += random.nextInt(b + 1 - a) + a;
        }

        System.out.println(sum);
    }
}
 */