package solutions;

import utils.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day3_Solution {
    public static void main(String[] args) {
        List<String> input = Util.readInput("/day03.txt");
        runPartOne(input);
    }

    private static void runPartOne(List<String> input) {
        ArrayList<Claim> claims = new ArrayList<>();
        for (String s : input) {
            ArrayList<String> split = new ArrayList<>(Arrays.asList(s.split(" ")));

            Claim claim = new Claim();
            claim.id = Integer.parseInt(split.get(0).substring(1)); // substring 1 to get rid of the #

            String inches = split.get(2).substring(0, split.get(2).length()-1);
            String[] inchesSplit = inches.split(",");
            claim.inchesFromLeftEdge = Integer.parseInt(inchesSplit[0]);
            claim.inchesFromTopEdge = Integer.parseInt(inchesSplit[1]);

            String[] widthAndHeight = split.get(3).split("x");
            claim.rectangleWidth = Integer.parseInt(widthAndHeight[0]);
            claim.rectangleHeight = Integer.parseInt(widthAndHeight[1]);

            claims.add(claim);
        }
    }
    private static class Claim {
        private int id = 0;
        private int inchesFromLeftEdge = 0, inchesFromTopEdge = 0;
        private int rectangleWidth = 0, rectangleHeight = 0;
    }
}


