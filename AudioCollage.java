public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double[] output = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[i] * alpha;
        }
        return output;
    }

    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double[] output = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            output[i] = a[a.length - 1 - i];
        }
        return output;
    }

    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
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
        int newLength = (int) (a.length / alpha);
        double[] changed = new double[newLength];
        for (int i = 0; i < newLength; i++) {
            changed[i] = a[(int) (i * alpha)];
        }
        return changed;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double[] beatbox = StdAudio.read("./beatbox.wav");
        double[] buzzer = StdAudio.read("./buzzer.wav");
        double[] chimes = StdAudio.read("./chimes.wav");
        double[] cow = StdAudio.read("./cow.wav");
        double[] dialup = StdAudio.read("./dialup.wav");
        int totalLength = beatbox.length + buzzer.length + chimes.length + cow.length + dialup.length;
        StdOut.println("DEBUG total audio length: " + totalLength);

    }
}
