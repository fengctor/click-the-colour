/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clickthecolour;

/**
 *
 * @author Gary
 */
public class Player {
// Instance variables    
    private String name;
    private int age;
    private long[] clickTime = new long[5];         // time difference in clickTime is measured in nanoseconds
    
/*  Note: instead of using a method to set the player's click time, 
    I've decided to save the times in variables in the main program
    and use them to construct each Player after the game is successfully completed.
*/
// Constructor
    public Player(String playerName, int years, long[] time) {
        // copies elements from parameter array into player's clickTime records
        this.name = playerName;
        this.age = years;
        System.arraycopy(time, 0, this.clickTime, 0, 5);

    }
    
// Access methods
    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    // returns (clickNumber-1)th recorded click time
    public double getTime(int clickNumber) {
        return this.clickTime[clickNumber];
    }
    
    
// Manipulation methods
    // returns average time in seconds for use in getScore()
    private double getAvgTime() {
        double average = 0;
        for(int i = 0; i < 5; i++) {
            average += this.clickTime[i];
        }
        average /= 5;
        // convert nanoseconds to seconds
        average /= 1000000000.0;
        return average;
    }
    public double getScore() {
        // calculate score
        double score = 5 - getAvgTime();
        // min score of 0
        if(score <= 0) {
            return 0;
        }
        // make possible max score of 100 otherwise
        score *= 20;
        // round score to nearest thousandth
        score = (int)(score * 1000) / 1000.0;
        return score;
    }
}
