import java.util.*;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] characters = input.split("");
        int len = characters.length;

        if(len % 2 == 0) {
            for(int i = 0; i < len; i++) {
                if(i != len/2 && i != len/2 - 1) System.out.print(characters[i]);
            }
        } else {
            for(int i = 0; i < characters.length; i++) {
                if(i != len/2) System.out.print(characters[i]);
            }
        }
    }
}