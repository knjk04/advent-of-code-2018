package solutions;

import utils.Util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

public class Day2_Solution {

    public static void main(String[] args) {
        List<String> input = Util.readInput("/day02.txt");
        new Day2_Solution().runPartOne(input);
        new Day2_Solution().runPartTwo(input);
    }

    private void runPartOne(List<String> input) {
        int twoLetterCount = 0, threeLetterCount = 0;
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

    private void runPartTwo(List<String> input) {
        StringBuilder common = new StringBuilder();
        ArrayList<String> idValues = new ArrayList<>(input);
        idValues.removeIf(Predicate.isEqual("")); // remove empty string

        for (int i = 0; i < idValues.size(); i++) {
            String ithElement = idValues.get(i);
            for (int j = i + 1; j < idValues.size(); j++) {
                String jthElement = idValues.get(j);

                ArrayList<Integer> differentCharIndexes = new ArrayList<>();
                int differBy = 0;
                // Assumes ithElement and jthElement are of the same length
                for (int k = 0; k < ithElement.length(); k++) {
                    if (ithElement.charAt(k) != jthElement.charAt(k)) {
                        differBy++;
                        differentCharIndexes.add(k);
                    }
                    if (differBy > 1) {
                        break; // no point comparing the rest of the jthElement to the ithElement
                    }
                }

                if (differBy == 1) {
                    for (int k = 0; k < ithElement.length(); k++) {
                        if (!differentCharIndexes.contains(k)) {
                            common.append(ithElement.charAt(k));
                        }
                    }
                }
            }
        }

        System.out.println("common = " + common);

    }
}
