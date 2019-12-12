import java.util.*;

public class Main {
    public static void main(String[] args) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int solutions = 0;

        Scanner scanner = new Scanner(System.in);
        char[] wordLetters = scanner.next().toCharArray();

        if (wordLetters.length < 3) {
            System.out.println(0);
            System.exit(2);
        }


        for (int i = 1; i < wordLetters.length; i++) {
            for (char vowel : vowels) {

            }
        }
        System.out.println(solutions);
    }
}