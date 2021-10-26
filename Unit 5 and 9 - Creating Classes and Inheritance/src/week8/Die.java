package week8;

public class Die {
    // attributes - defines teh state of the Object

    // the atributes SHOULD be private
    // private -> visiblE(accessible) in this class
    private int numSides;
    private int topSide;

    // constructor
    // has the same name as the class
    // you should create at least 1
    // they are used to obtain (construct an instance of this class)
    // In this case it will give a Die
    // Purpose is to initialize the state (attributes)
    public Die() {
        // constructor initializes the attributes
        numSides = 6;
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
}