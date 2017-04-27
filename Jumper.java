package SkiJumping;

import java.util.List;
import java.util.ArrayList;

public class Jumper implements Comparable<Jumper> {

    // Attributes
    private String name;
    private Action points;      // Takes in object with jumper's points
    int totalPoints;
    List<Integer> jumpLengths;
    
    // Constructor
    public Jumper(String name) { 
        // When the jumper is initalized, only his total score (0) and name are set.
        // His jumpLengths will be recorded in a list for tracking purposes.
        this.name = name;
        this.totalPoints = 0;
        jumpLengths = new ArrayList<Integer>();
    }
    
    // Accessors
    public int getPoints() {
        // Gets the points from the 
        return this.totalPoints;
    }
    
    public void addPoints(int points) {
        this.totalPoints += points;
    }
    
    public void addLength(int length) {
        this.jumpLengths.add(length);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getResults() {
        String resultsAsString = "Jump lengths: ";
        if (this.jumpLengths != null) {
            for (int i = 0; i < this.jumpLengths.size(); i++) {
                if (i != this.jumpLengths.size() - 1) {
                    resultsAsString = resultsAsString + this.jumpLengths.get(i) + " m,";
                }
                else
                    resultsAsString = resultsAsString + this.jumpLengths.get(i) + " m";
            }
        }
        return resultsAsString;
    }
    
    @Override       // Overriding the compareTo method from interface Comparable
                    // Enables to compare objects in their List interfaces!
    public int compareTo(Jumper jumper) {
        if (this.getPoints() == jumper.getPoints()) {
            return 0;
        }
        else if (this.getPoints() > jumper.getPoints()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
