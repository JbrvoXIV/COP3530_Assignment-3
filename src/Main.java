
import java.util.HashMap;
import java.util.Random;

public class Main {

    public static char findDistinguishingChar(String str1, String str2) { // PROG PART 1

        HashMap<Character, Integer> str1Map = new HashMap<>();
        HashMap<Character, Integer> str2Map = new HashMap<>();

        for(int i = 0; i < str1.length(); i++) { // ADD LETTER WITH FREQUENCY COUNTER TO HASHMAP FOR STR1
            char letter = str1.charAt(i);
            if(!str1Map.containsKey(letter)) {
                str1Map.put(letter, 0);
            }
            str1Map.put(letter, str1Map.get(letter) + 1);
        }

        for(int i = 0; i < str2.length(); i++) { // ADD LETTER WITH FREQUENCY COUNTER TO HASHMAP FOR STR2
            char letter = str2.charAt(i);
            if(!str2Map.containsKey(letter)) {
                str2Map.put(letter, 0);
            }
            str2Map.put(letter, str2Map.get(letter) + 1);
        }

        int maxDiff = -1;
        char maxDiffLetter = Character.MIN_VALUE;

        if(str1Map.size() < str2Map.size()) { // COMPARE AND TALLY HIGHEST DIFFERENCE OF FREQUENCY TO MAXDIFF AND ASSIGN LETTER OF HIGHEST DIFF FREQUENCY TO MAXDIFFLETTER
            Character[] keyVals = str1Map.keySet().toArray(new Character[0]);
            for(Character chr : keyVals) {
                if(!str2Map.containsKey(chr))
                    continue;
                if(Math.abs(str1Map.get(chr) - str2Map.get(chr)) > maxDiff) {
                    maxDiff = Math.abs(str1Map.get(chr) - str2Map.get(chr));
                    maxDiffLetter = chr;
                }
            }
        } else {
            Character[] keyVals = str2Map.keySet().toArray(new Character[0]);
            for(Character chr : keyVals) {
                if(!str1Map.containsKey(chr))
                    continue;
                if(Math.abs(str2Map.get(chr) - str1Map.get(chr)) > maxDiff) {
                    maxDiff = Math.abs(str2Map.get(chr) - str1Map.get(chr));
                    maxDiffLetter = chr;
                }
            }
        }

        return maxDiffLetter;
    }

    public static int sumOfUniqueElements(int[] arr) { // PROG PART 3

        HashMap<Integer, Integer> valueUniqueness = new HashMap<>();
        int sumOfUniqueVals = 0;

        for(int val : arr) { // ADD ELEMENTS FROM ARRAY TO HASHMAP AND INCREASE COUNTER BASED ON FREQUENCY
            if(!valueUniqueness.containsKey(val))
                valueUniqueness.put(val, 0);
            valueUniqueness.put(val, valueUniqueness.get(val) + 1);
        }

        for(int val : arr) { // LOOP THROUGH HASHMAP, INCREASING SUM WITH UNIQUE VALUE FOUND
            if(valueUniqueness.get(val) == 1)
                sumOfUniqueVals += val;
        }

        return sumOfUniqueVals;
    }

    public static void main(String[] args) {
        System.out.println("Character with highest difference of appearance in both strings: " + findDistinguishingChar("apple", "pale"));

        Random rnd = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < 20; i++) {
            arr[i] = rnd.nextInt(10);
            System.out.printf("%d,", arr[i]);
        }
        System.out.println("\n" + sumOfUniqueElements(arr));
    }
}
