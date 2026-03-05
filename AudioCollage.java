/*
 * Compilation:  javac -cp AudioCollage.java
 * Execution:    java -cp AudioCollage
 *
 * Implements a small digital-audio library with five effects:
 * amplify, reverse, merge, mix, and changeSpeed.
 *
 * The main() method reads five WAV files, combines them into an
 * audio collage using all required effects, normalizes amplitudes to
 * stay within [-1, +1], and plays the result with StdAudio.play().
 */
public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        /*
         * Creates a new array with the same length as the input.
         * Each sample is multiplied by alpha to raise or lower volume.
         * The input array is never modified.
         */
        double[] output = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[i] * alpha;
        }
        return output;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        /*
         * Copies samples in reverse order into a new array.
         * Sample i in output comes from sample (length - 1 - i) in input.
         * The input array is never modified.
         */
        double[] output = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[a.length - 1 - i];
        }
        return output;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        /*
         * Appends b after a in a new array.
         * First copy all of a, then copy all of b.
         * Result length is a.length + b.length.
         */
        double[] merged = new double[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            merged[i] = a[i];
        }
        for (int i = a.length; i < (a.length + b.length); i++) {
            merged[i] = b[i - a.length];
        }
        return merged;
    }

    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        /*
         * Adds sample values from both arrays index-by-index.
         * If one array ends first, remaining values come from the longer array.
         * Result length is max(a.length, b.length).
         */
        int longest = Math.max(a.length, b.length);
        double[] mixed = new double[longest];
        for (int i = 0; i < longest; i++) {
            if (i < a.length) {
                mixed[i] += a[i];
            }
            if (i < b.length) {
                mixed[i] += b[i];
            }
        }
        return mixed;
    }

    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        /*
         * Resamples the input using sample i from index floor(i * alpha).
         * New length is floor(a.length / alpha).
         * The source index clamp prevents edge-case overflow from rounding.
         */
        int newLength = (int) (a.length / alpha);
        double[] changed = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            int sourceIndex = (int) (i * alpha);
            if (sourceIndex >= a.length) {
                sourceIndex = a.length - 1;
            }
            changed[i] = a[sourceIndex];
        }
        return changed;
    }

    // Returns a scaled copy so every sample is in [-1.0, 1.0].
    private static double[] normalize(double[] a) {
        double maxAbs = 0.0;
        for (int i = 0; i < a.length; i++) {
            maxAbs = Math.max(maxAbs, Math.abs(a[i]));
        }
        if (maxAbs <= 1.0) {
            return a;
        }
        return amplify(a, 1.0 / maxAbs);
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        /*
         * Collage pipeline overview:
         * 1) Load five source clips from WAV files.
         * 2) Build an intro and phrase using all required effects:
         * - changeSpeed + reverse for texture
         * - amplify + mix for layered sections
         * - merge to sequence sections
         * 3) Merge intro, layerA, and layerB into one collage.
         * 4) Normalize so all output samples stay within [-1.0, 1.0].
         * 5) Play the final collage with StdAudio.play(...).
         */
        double[] beatbox = StdAudio.read("./beatbox.wav");
        double[] buzzer = StdAudio.read("./buzzer.wav");
        double[] chimes = StdAudio.read("./chimes.wav");
        double[] cow = StdAudio.read("./cow.wav");
        double[] dialup = StdAudio.read("./dialup.wav");

        // Build sections with all required effects.
        double[] intro = merge(changeSpeed(beatbox, 1.2), reverse(chimes));
        double[] layerA = mix(amplify(cow, 0.45), changeSpeed(dialup, 0.8));
        double[] layerB = mix(amplify(reverse(buzzer), 0.50), changeSpeed(chimes, 1.5));
        double[] collage = merge(merge(intro, layerA), layerB);

        collage = normalize(collage);
        StdAudio.play(collage);
    }
}
