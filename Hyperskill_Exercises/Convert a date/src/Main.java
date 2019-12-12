import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");
        int day, month, year;

        try {
            year = Integer.parseInt(input[0]);
            month = Integer.parseInt(input[1]);
            day = Integer.parseInt(input[2]);
            if (day < 1 || day > 31 || month < 1 || month > 12 || year < 1) {
                System.err.print("Incorrect input");
                System.exit(-1);
            }
        } catch (Exception e) {
            System.err.print(e);
            System.exit(-2);
        }

        System.out.println(input[1] + "/" + input[2] + "/" + input[0]);
    }
}