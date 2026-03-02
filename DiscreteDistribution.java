/*
 * Compilation:  javac DiscreteDistribution.java
 * Execution:    java DiscreteDistribution m a1 a2 ... ak
 *
 * Takes an integer m and a sequence of positive integers a1, a2, ..., ak
 * as command-line arguments. Prints m random indices, each chosen with
 * probability proportional to the corresponding frequency. Uses cumulative
 * sums and linear search to sample from the discrete distribution.
 *
 * % java DiscreteDistribution 25 1 1 1 1 1 1
 * 5 2 4 5 5 3 4 3 1 5 2 4 2 0 1 3 6 2 3 2 4 1 4
 */
public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] freq = new int[args.length];
        freq[0] = 0;
        int sum = 0;
        for (int i = 1; i < freq.length; i++) {
            freq[i] = Integer.parseInt(args[i]) + freq[i - 1];
            sum += Integer.parseInt(args[i]);
        }
        for (int i = 0; i < m; i++) {
            int r = (int) (Math.random() * sum);
            for (int j = 0; j < freq.length; j++) {
                if (r < freq[j]) {
                    System.out.print(j);
                    if (i != m - 1) {
                        System.out.print(" ");
                    }
                    break;
                }
            }
        }
        System.out.println();
    }

}
