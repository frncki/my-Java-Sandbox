import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<List<Character>> vowelsList = new ArrayList<>();
        List<List<Character>> consonantsList = new ArrayList<>();
        int solutions = 0;

        Scanner scanner = new Scanner(System.in);
        char[] wordLetters = scanner.next().toCharArray();

        if (wordLetters.length < 3) {
            System.out.println(0);
            System.exit(2);
        }

        List<Character> tempVowels = new ArrayList<>();
        for (int i = 0; i < wordLetters.length; i++) {
            if (checkForVowel(wordLetters, i)) {
                tempVowels.add(wordLetters[i]);
            } else {
                vowelsList.add(tempVowels);
                tempVowels = new ArrayList<>();
            }
        }

        List<Character> tempConsonants = new ArrayList<>();
        for (int i = 0; i < wordLetters.length; i++) {
            if (!checkForVowel(wordLetters, i)) {
                tempConsonants.add(wordLetters[i]);
            } else {
                consonantsList.add(tempConsonants);
                tempConsonants = new ArrayList<>();
            }
        }

        for (List<Character> vowels : vowelsList) {
            System.out.println(vowels);
        }
        System.out.println("pupa");
        for (List<Character> vowels : consonantsList) {
            System.out.println(vowels);
        }

        for (List<Character> vowels : vowelsList) {
            int vowelsInRow = vowels.size();
            if(vowelsInRow > 2) {
                if(vowelsInRow % 2 == 1) {
                    solutions += vowelsInRow / 2;
                } else {
                    solutions += vowelsInRow / 2 - 1;
                }
            }
        }

        for (List<Character> consonants : consonantsList) {
            int consonantsInRow = consonants.size();
            if(consonantsInRow > 2) {
                if(consonantsInRow % 2 == 1) {
                    solutions += consonantsInRow / 2;
                } else {
                    solutions += consonantsInRow / 2 - 1;
                }
            }
        }

        //eeeeeeeeeerrrreeeeeeee
        //aaaaaweeeeewiiiiiwooooowuuuuuwyyyyyw
        //qqqewwwerrrettteyyyeuuueiiieoooepppeaaaesssedddefffegggehhhejjjekkkelllezzzexxxecccevvvebbbennnemmm

        System.out.println(solutions);
    }

    private static boolean checkForVowel(char[] wordLetters, int i) {
        return (wordLetters[i] == 'a' || wordLetters[i] == 'e' || wordLetters[i] == 'i' || wordLetters[i] == 'o' || wordLetters[i] == 'u' || wordLetters[i] == 'y');
    }
}