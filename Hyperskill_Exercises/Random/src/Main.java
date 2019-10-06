/*
Find the seed between A and B inclusively that produces N pseudorandom numbers from 0 inclusive to K exclusive and have the maximum of these N numbers be the minimum among all maximums of other seeds in this range.

For example, we have N=4, A=7, B=9, K=100. Suppose, for the seed 7 we have sequence 45, 99, 23, 67 - the maximum is 99. For the seed 8, we have 64, 34, 23, 9 - the maximum is 64. For the seed 9, we have 78, 34, 0, 11 - the maximum is 78.
The minimum among these maximums is 64 form the seed 8, therefore, in this case, the program should output 8.

If there are some seeds with equal minimal maximums, you should output the seed which is less than all other seeds.

The input contains numbers A, B, N, K in a single line.

You should output 2 numbers - a seed and it's maximum.

Sample Input 1:
0 100 5 1000

Sample Output 1:
18
270


Sample Input 2:
0 100 1000 1000

Sample Output 2:
5
993


Sample Input 3:
0 100 10000 1000

Sample Output 3:
0
999

 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] userInput = scanner.nextLine().split(" ");

        Random random = new Random();
        // variables from hyperskill exercise
        int a = 0;
        int b = 0;
        int n = 0;
        int k = 0;

        //my variables
        int numOfSeeds;
        int currentRandNum;
        int maxRandNumForSeed;
        int seedIndex;
        int bestSeed = 0;

        int[][] everyOutput;

        try {
            a = Integer.parseInt(userInput[0]);
            b = Integer.parseInt(userInput[1]);
            n = Integer.parseInt(userInput[2]);
            k = Integer.parseInt(userInput[3]);
        } catch (Exception ex) {
            System.err.println(ex);
        }

        numOfSeeds = b - a + 1; // +1 because we want both a & b inclusive

        everyOutput = new int[2][numOfSeeds];

        for (int i = a; i <= b; i++) {
            random.setSeed((long) i);
            maxRandNumForSeed = 0;
            seedIndex = i - a;
            for (int j = 0; j < n; j++) {
                currentRandNum = random.nextInt(k);
                if (currentRandNum > maxRandNumForSeed) {
                    maxRandNumForSeed = currentRandNum; // it works! and I figured it out by myself xd <3
                }
            }
            everyOutput[0][seedIndex] = i; //current seed
            everyOutput[1][seedIndex] = maxRandNumForSeed; //maximum for that seed
        }

        for (int i = 0; i < numOfSeeds; i++) {
            if (everyOutput[1][i] < k) {
                k = everyOutput[1][i];
                bestSeed = everyOutput[0][i];

            }
        }

        System.out.println(bestSeed);
        System.out.println(k);
    }
}

/*
JetBrains code
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int seedMin = a;
        Integer max = null;

        for (int seed = a; seed <= b; seed++) {
            Integer curMax = null;
            Random random = new Random(seed);

            for (int i = 0; i < n; i++) {
                int nextVal = random.nextInt(k);
                if (curMax == null || nextVal > curMax) {
                    curMax = nextVal;
                }
            }

            if (max == null || curMax < max) {
                max = curMax;
                seedMin = seed;
            }
        }

        System.out.println(seedMin);
        System.out.println(max);
    }
}
 */