import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.next().toCharArray();
        char arg1 = scanner.next().charAt(0);
        char arg2 = scanner.next().charAt(0);
        int counter = 0;

        for(int i = 0; i < input.length - 1; i++) {
            if((input[i] == arg1 || input[i] == arg2) && (input[i + 1] == arg1 || input[i + 1] == arg2)) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}