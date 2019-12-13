import java.util.*;

public class Main {
    public static void main(String[] args) {
        //char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
        int solutions = 0;
        int vowelsFactor = 1;
        int consonantsFactor = 1;
        int vowelsCounter = 0;
        int consonantsCounter = 0;

        Scanner scanner = new Scanner(System.in);
        char[] wordLetters = scanner.next().toCharArray();
        boolean[] isVowel = new boolean[wordLetters.length];

        if (wordLetters.length < 3) {
            System.out.println(0);
            System.exit(2);
        }


        for (int i = 0; i < wordLetters.length; i++) {
            if (wordLetters[i] == 'a' || wordLetters[i] == 'e' || wordLetters[i] == 'i' || wordLetters[i] == 'o' || wordLetters[i] == 'u' || wordLetters[i] == 'y') {
                isVowel[i] = true;
            }
            //System.out.print(isVowel[i]);
        }
        for (int i = 1; i < wordLetters.length; i++) {
            if (isVowel[i - 1] && isVowel[i]) {
                vowelsCounter++;
            } else if (!isVowel[i - 1] && !isVowel[i]) {
                consonantsCounter++;
            }
        }

        for (int i = 3; i < wordLetters.length; i++) {
            if (!isVowel[i - 3] && isVowel[i - 2] && isVowel[i - 1] && isVowel[i]) {
                vowelsFactor++;
            } else if (isVowel[i - 2] && !isVowel[i - 2] && !isVowel[i - 1] && !isVowel[i]) {
                consonantsFactor++;
            }
        }

        vowelsCounter += vowelsFactor;
        consonantsCounter += consonantsFactor;

        System.out.println(vowelsFactor + " " + consonantsFactor + " " +vowelsCounter + " " + consonantsCounter);

        if (vowelsCounter > 2 && vowelsCounter % 2 == 0) {
            solutions += vowelsCounter / 2 - vowelsFactor;
            //System.out.println("solutions1");
        } else if (vowelsCounter > 2 && vowelsCounter % 2 == 1) {
            solutions += vowelsCounter / 2;
            //System.out.println("solutions2");
        }
        if (consonantsCounter > 2 && consonantsCounter % 2 == 0) {
            solutions += consonantsCounter / 2 - consonantsFactor;
            //System.out.println("solutions3");
        } else if (consonantsCounter > 2 && consonantsCounter % 2 == 1) {
            solutions += consonantsCounter / 2;
            //System.out.println("solutions4");
        }

        //qqqewwwerrrettteyyyeuuueiiieoooepppeaaaesssedddefffegggehhhejjjekkkelllezzzexxxecccevvvebbbennnemmm
        //eeeeeeeeeerrrreeeeeeee
        System.out.println(solutions);
    }
}