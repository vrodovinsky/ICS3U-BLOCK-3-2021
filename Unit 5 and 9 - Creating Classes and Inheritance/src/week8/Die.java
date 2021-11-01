package week8;

import javax.lang.model.util.ElementScanner6;

public class Die {

    public static final int DEFAULT_NUM_SIDES = 6;
    // attributes - defines teh state of the Object

    // the atributes SHOULD be private
    // private -> visiblE(accessible) in this class
    public int numSides;
    public int topSide;

    // constructor
    // has the same name as the class
    // you should create at least 1
    // they are used to obtain (construct an instance of this class)
    // In this case it will give a Die
    // Purpose is to initialize the state (attributes)
    public Die() {
        // constructor initializes the attributes
        numSides = DEFAULT_NUM_SIDES;
        roll();
    }

    public Die(int numSides) {
        // The word this refers to the Object that we are working with.
        // The object that called the method
        this.numSides = numSides;
        roll();
    }

    public void roll() {
        topSide = (int) (Math.random() * numSides) + 1;
    }

    public int getTopSide() {
        return topSide;
    }

    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj instanceof Die) {
            return this.topSide == ((Die) obj).topSide;
        } else {
            return false;
        }
    }

    public String toString() {
        return " " + topSide;
    }
}