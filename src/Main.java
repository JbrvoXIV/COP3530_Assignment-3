
import java.util.HashMap;

public class Main {

    public static char findDistinguishingChar(String str1, String str2) {

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

    public static void main(String[] args) {
        System.out.println("Character with highest difference of appearance in both strings: " + findDistinguishingChar("apple", "pale"));
    }
}
