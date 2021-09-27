package week4;

public class BayviewGlenPools {
    public static void main(String[] args) {
        final int length = 20;
        final int width = 8;
        final int shallowLength = 5;
        final int transition = 7;
        final int shallowHeight = 3;
        final int deepHeight = 8;

        final int linerCost = 2;

        double surfaceArea = getSurfaceArea(length, width, shallowHeight, shallowLength, transition, deepHeight);
        double volume = getVolume(length, width, shallowHeight, shallowLength, transition, deepHeight);
    }

    public static double getVolume(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {
        double transitionBase = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
        double deepLength = length - transitionBase - shallowLength;

        double shallowVolume = (double) shallowLength * width * shallowHeight;
        double deepVolume = (double) deepLength * width * deepHeight;
        double transitionVolume = (transitionBase * shallowHeight * width)
                + ((deepHeight - shallowHeight) * transitionBase * 0.5);

        return deepVolume + shallowVolume + transitionVolume;

    }

    public static double getSurfaceArea(int length, int width, int shallowHeight, int shallowLength, int transition,
            int deepHeight) {
        double transitionBase = Math.sqrt(Math.pow(transition, 2) - Math.pow(deepHeight - shallowHeight, 2));
        double deepLength = length - transitionBase - shallowLength;

        int shallowBack = shallowHeight * width;
        int deepBack = deepHeight * width;
        double bottom = (deepLength + transition + shallowLength) * width;
        double side = shallowHeight * shallowLength + deepHeight * deepLength + transitionBase * shallowHeight
                + (deepHeight - shallowHeight) * transitionBase * 0.5;

        return shallowBack + deepBack + bottom + side;
    }
}
