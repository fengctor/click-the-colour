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
public class YoungPlayer extends Player {
// Constructor
    YoungPlayer(String playerName, int years, long[] time) {
        super(playerName, years, time);
    }
    
// Access methods
    // returns (clickNumber-1)th recorded click time
    @Override
    public double getTime(int clickNumber) {
        return super.getTime(clickNumber);
    }
    @Override
    public int getAge() {
        return super.getAge();
    }    
// Manipulation methods
    // returns average time in seconds for use in getScore()
    private double getAvgTime() {
        double average = 0;
        for(int i = 0; i < 5; i++) {
            average += getTime(i);
        }
        average /= 5;
        // convert nanoseconds to seconds
        average /= 1000000000.0;
        return average;
    }
    @Override
    public double getScore() {
        // bonus score for younger players
        double bonus = 2.5;
        // calculate score
        double score = 5 - getAvgTime();
        // min score of 0 + bonus added
        if(score <= 0) {
            return 0 + bonus;
        }
        // make possible max score of 100 otherwise
        score *= 20;
        // round score to nearest thousandth
        score = (int)(score * 1000) / 1000.0;
        return score + bonus;
    }
}
