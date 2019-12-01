package solutions;

import utils.Util;
import java.util.List;

public class Day1_Solution {
    public static void main(String[] args) {
        List<String> input = Util.readInput("/day01.txt");
        new Day1_Solution().runPartOne(input);
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
}
