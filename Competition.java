
/*
 * This class "Competition" will be used as the interfacing class
 * for the SkiJumping program.
 */
package SkiJumping;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Competition {

    // Attributes
    Scanner reader;
    List<Jumper> competitors;
    String competitionName;
    
    // Constructor
    public Competition(String competitionName) {
        // User input initialization
        this.competitionName = competitionName;
        this.reader = new Scanner(System.in);
        this.competitors = new ArrayList<Jumper>();
    }
    
    // Methods
    public void checkCompetitors() {
        // Since the Jumper object implements the Comparable interface,
        // the List with Jumper objects (which also belongs to Comparable interface
        // can now be easily sorted.  The method "compareTo" in Jumper class defines the criteria for sorting.
        Collections.sort(competitors);
        
        // Sort the competitor list, so the jumper with the lowesst amount of points will start in each round
        int pos = 1;
        for (Jumper jumper : this.competitors) {
            System.out.println("  " + pos + ". " + jumper.getName() + " (" + jumper.getPoints() + " points)");
            pos++;
        }
    }
    
    public void competeInRound() {
        // Defines what happens in one competion round.
        for (Jumper jumper : this.competitors) {

            System.out.println(jumper.getName());
            
            // Make a jump
            int jumpscore = Action.jump();
            jumper.addLength(jumpscore);
            System.out.println("  length: " + jumpscore);
            
            // Get a jury score
            List<Integer> juryscore = Action.juryVotes();

            // Show the jury votes
            System.out.print("  judge votes: [ ");
            for (int s : juryscore) {
                System.out.print(s + " ");
            }
            System.out.println("]");

            // From the jury score, only the middle 3 values are accepted
            // On a sorted list, exclude the values in position 0 and 5.
            Collections.sort(juryscore);
            

            
            int votescore = juryscore.get(1) + juryscore.get(2) + juryscore.get(3);
            
            // Calculate the points and add to the jumper
            int roundscore = jumpscore + votescore;
            jumper.addPoints(roundscore);
        }       
    }

    public void endTournament() {
        
        // Sort the list of Jumper objects (sorting is possible because of the override method CompareTo)
        Collections.sort(this.competitors, Collections.reverseOrder());
        
        int pos = 1;
        
        for (Jumper jumper : this.competitors) {
            System.out.println(pos + "\t\t" + jumper.getName() + " (" + jumper.getPoints() + ")");                          
            System.out.println("" + "\t\t" + jumper.getResults());
            pos++;
        }
        
        
                
                
                
    }
    // Main program
    public void run() {
        
        System.out.println(this.competitionName + "\n");
        
        System.out.println("Enter the name of the participants one by one.");
        System.out.println("An empty input will start the competition!");
        
        String name = "";
         do {
            System.out.print("   Participant name: ");
            name = this.reader.nextLine();
            if (name.length() > 0) {
                // Create a player object out of the competitor
                Jumper competitor = new Jumper(name);
                // Add the competitor to the set of competitor objects.
                this.competitors.add(competitor);
            }
         }
        while (name.length() > 0);
       
        System.out.println("\nThe competition begins!\n");
        
        
        int round = 1;
        String command = "";
        
        do {
            System.out.println("Round " + round + "\n");
            
            System.out.println("Jumping order:");
            
            // This method gives the list of competitors and sorts them
            // The jumper with lowest points will start the round.
            checkCompetitors();
            System.out.println("");
            competeInRound();
            System.out.println("");
            
            round += 1;
            System.out.println("Write 'jump' to jump; everything else will stop the competition.");           
            command = this.reader.nextLine();    
            System.out.println("");
            
        }
        while (command.equals("jump"));
            
        System.out.println("<END OF TOURNAMENT> \n");
        System.out.println("TOURNAMENT RESULTS");
        endTournament();            

    }
}
