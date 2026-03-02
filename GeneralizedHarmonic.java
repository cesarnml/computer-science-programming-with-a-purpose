/**
 * Compilation: javac GeneralizedHarmonic.java
 * Execution: java GeneralizedHarmonic [n] [r]
 *
 * Takes two integer command-line arguments n and r, and uses a for loop to
 * compute the nth generalized harmonic number of order r, defined by the
 * formula: H(n,r) = 1/1^r + 1/2^r + ... + 1/n^r
 *
 * % java GeneralizedHarmonic 1 1
 * 1.0
 *
 * % java GeneralizedHarmonic 2 1
 * 1.5
 *
 * % java GeneralizedHarmonic 3 1
 * 1.8333333333333333
 *
 * % java GeneralizedHarmonic 1 2
 * 1.0
 *
 * % java GeneralizedHarmonic 2 2
 * 1.25
 *
 * % java GeneralizedHarmonic 3 2
 * 1.3611111111111112
 */
public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int r = Integer.parseInt(args[1]);
        double result = 0.0;
        for (int i = 1; i <= n; i++) {
            result += 1 / Math.pow(i, r);
        }
        System.out.println(result);
    }
}
