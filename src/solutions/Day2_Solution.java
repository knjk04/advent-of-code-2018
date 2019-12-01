package solutions;

import utils.Util;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class Day2_Solution {
    private int twoLetterCount = 0;
    private int threeLetterCount = 0;

    public static void main(String[] args) {
        List<String> input = Util.readInput("/day02.txt");
        new Day2_Solution().runPartOne(input);
    }

    private void runPartOne(List<String> input) {
        HashMap<Character, Integer> chars = new HashMap<>();
        for (String line : input) {
            // check if each character in the ID is in the hashmap
            // update the count if so. Otherwise, add it
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (chars.containsKey(currentChar)) {
                    // increment count in hashmap
                    int count = chars.get(currentChar);
                    chars.replace(currentChar, ++count);
                } else {
                    // add to hashmap if it doesn't exist
                    chars.put(currentChar, 1);
                }
            }

            Collection<Integer> counts = chars.values();
            if (counts.contains(2)) {
                twoLetterCount++;
            }
            if (counts.contains(3)) {
                threeLetterCount++;
            }

            chars.clear(); // reset at the end of every iteration
        }
        System.out.println("total count = " + (twoLetterCount * threeLetterCount));
    }
}
