/*
Find the first seed that is greater or equal to K where each of N gaussian numbers is lesser than or equal M.
The input contains numbers K, N, M in a single line. You should output the seed.

Sample Input 1:
0 5 0

Sample Output 1:
38

Sample Input 2:
0 5 -1.5

Sample Output 2:
498666

Sample Input 3:
10000 1 1.9

Sample Output 3:
10000

you have to check the all n iterations of Gaussian generated numbers to be less than M.
If that is true, then escape loop and print the seed.
If any of the generated numbers is greater than or equal to M, then you have to test out next seed and go to the loop all over again.
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long k = scanner.nextLong();
        int n = scanner.nextInt();
        final double m = scanner.nextDouble();

        Random random = new Random();
        double gaussian;
        boolean valid = false;

        while (true) {
            random.setSeed(k);
            for (int i = 0; i < n; i++) {
                gaussian = random.nextGaussian();
                if (gaussian >= m) {
                    valid = false;
                    k++;
                    break;
                } else {
                    valid = true;
                }
            }
            if (valid) {
                System.out.println(k);
                break;
            }
        }
    }
}

/*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        final int k = scanner.nextInt();
        final int n = scanner.nextInt();
        final double m = scanner.nextDouble();

        int seed = k;
        int count = 0;
        Random random = new Random(seed);

        while (true) {
            final double number = random.nextGaussian();
            count++;
            if (Double.compare(number, m) >= 0) {
                count = 0;
                seed++;
                random = new Random(seed);
                continue;
            }
            if (count >= n) {
                break;
            }
        }

        System.out.println(seed);
    }
}

 */