package week11;

public class Sound {
    private int[] samples;

    public int limitAmplitude(int limit) {
        samples = new int[samples.length];
        int numChanges = 0;

        for (int i = 0; i < samples.length; i++) {
            if (samples[i] > limit) {
                samples[i] = limit;
                numChanges++;
            }
            if (samples[i] < -limit) {
                samples[i] = -limit;
                numChanges++;
            }
        }

        return numChanges;
    }

    public void trimSilenceFromBeginning() {
        int numZeroes = 0;

        while (samples[numZeroes] == 0) {
            numZeroes++;
        }

        int[] newSamples = new int[samples.length - numZeroes];

        for (int i = 0; i < newSamples.length; i++) {
            newSamples[i] = samples[i + numZeroes];
        }

        samples = newSamples;
    }
}
