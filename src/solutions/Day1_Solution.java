package solutions;

import utils.Util;

import java.util.HashSet;
import java.util.List;

public class Day1_Solution {
    // HashSet instead of ArrayList because it can search (contains()) in constant time
    private HashSet<Integer> frequencies = new HashSet<>();
    private int resultingFrequency = 0;

    public static void main(String[] args) {
        List<String> input = Util.readInput("/day01.txt");
        new Day1_Solution().runPartTwo(input);
    }

    private void runPartOne(List<String> input) {
        int resultingFrequency = 0;
        for (String line : input) {
            char sign = line.charAt(0);
            int frequency = Integer.parseInt(line.substring(1));
            resultingFrequency = (sign == '+') ? (resultingFrequency + frequency) : (resultingFrequency - frequency);
        }
        System.out.println(resultingFrequency);
    }

    private void runPartTwo(List<String> input) {
        frequencies.add(resultingFrequency);
        while (true) {
            if (findDuplicateFrequency(input)) {
                break;
            }
        }
        System.out.println("duplicate frequency = " + resultingFrequency);
    }

    private boolean findDuplicateFrequency(List<String> input) {
        for (String line : input) {
            if (line.isEmpty()) {
                break;
            }
            System.out.println("line = " + line);
            char sign = line.charAt(0);
            int frequency = Integer.parseInt(line.substring(1));
            resultingFrequency = (sign == '+') ? (resultingFrequency + frequency) : (resultingFrequency - frequency);

            if (frequencies.contains(resultingFrequency)) {
                System.out.println("found duplicate");
                return true;
            } else {
                frequencies.add(resultingFrequency);
                System.out.println("resultingFrequency = " + resultingFrequency);
            }
        }
        return false;
    }
}
