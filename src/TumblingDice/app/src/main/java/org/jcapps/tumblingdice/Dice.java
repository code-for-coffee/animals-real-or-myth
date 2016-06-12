package org.jcapps.tumblingdice;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by JC on 6/10/16.
 */
public class Dice {

    private int sides;

    public Dice(int sides) {
        this.sides = sides;
    }

    public int roll() {
        int ret;
        Random r = new Random();
        int smallestNum = 1;
        int largestNum = this.sides;
        ret = smallestNum + r.nextInt((largestNum - smallestNum) + 1);
        return ret;
    }

    public String rollToString() {
        String ret = Integer.toString(this.roll());
        return ret;
    }
}
