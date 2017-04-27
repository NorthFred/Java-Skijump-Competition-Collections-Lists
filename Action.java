/*
 * This class handles the randomization results from both:
 * A. The ski jump length
 * B. The jury points
 * This class allows for creation of an object with all points.
 */
package SkiJumping;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Action {


    public static int jump() {
        final int MIN = 60;
        final int MAX = 120;
        // The jump length is a random integer between 60 and 120.
        Random generate = new Random();
        int result = generate.nextInt((MAX - MIN) + 1) + MIN;
        return result;
    }
    
    public static List<Integer> juryVotes() {
        final int MINPOINTS = 10;
        final int MAXPOINTS = 20;
        List<Integer> votes = new ArrayList<Integer>();
        // 5 jury members vote for the jump. Vote = random integer between 10 and 20.
        Random generate = new Random();
        for (int i = 0; i < 5; i++) {
            int points = generate.nextInt((MAXPOINTS - MINPOINTS) + 1) + MINPOINTS;
            votes.add(points);
        }
        return votes;
    }
}
