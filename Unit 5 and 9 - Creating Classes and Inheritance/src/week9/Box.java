package week9;

public class Box extends Rectangle {
    /*
     * Remember if you do not write a construcTor then Java supplies a no argument
     * conastructor that ONLY calls your parent's no arguement contructor public
     * Box() { super(); }
     */

    private double height;

    public Box(double l, double w, double h) {
        // length = l; // you get everything your parent has BUT the private stuff is
        // not visibler. Its there but not visible.
        // width = w;

        super(l, w); // first thing in a constructor iss to call one of your parents constructor
                     // (explicitly). If you do not then Java will attempt to call your parents
                     // no-argument constructor (implicitly)
        height = h;
    }

    public Box(double side) {
        super(side);
        height = side;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    /*
     * Method Overriding - Over write the method that was inherited from our parent
     */
    public double getArea() {
        return 2 * super.getArea() + height * getLength() * 2 + height * getWidth() * 2;
    }

    public boolean isCube() {
        return isSquare() && height == getWidth();
    }
}
