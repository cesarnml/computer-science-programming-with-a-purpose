/*
 * Compilation:  javac ShannonEntropy.java
 * Execution:    java ShannonEntropy m < input.txt
 *
 * Reads integers between 1 and m from standard input and computes their
 * Shannon entropy using:
 *   H = -sum(p_i * log2(p_i))
 * where p_i is the empirical frequency of symbol i.
 *
 * % java ShannonEntropy 3 < tiny.txt
 * 1.5850
 */

public class ShannonEntropy {
    public static void main(String[] args) {
        // setup
        int m = Integer.parseInt(args[0]);
        int[] count = new int[m + 1];
        int total = 0;

        // read entries
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            count[i] += 1;
            total += 1;
        }

        double h = 0.0;
        for (int i = 1; i <= m; i++) {
            if (count[i] > 0) {
                double p = (double) count[i] / total;
                h -= p * (Math.log(p) / Math.log(2.0));
            }
        }
        StdOut.printf("%.4f\n", h);
    }
}
