/*
 * Compilation:  javac Birthday.java
 * Execution:    java Birthday n trials
 *
 * Takes two integer command-line arguments n and trials. Repeats the
 * birthday-collision experiment trials times: people enter the room one by
 * one, each assigned a random birthday from 0 to n - 1, until a duplicate
 * birthday appears. Prints a table with i, the number of trials where the
 * first duplicate appears when the i-th person enters, and the cumulative
 * fraction of trials with a duplicate by i people. Stops when the fraction
 * reaches or exceeds 50%.
 *
 * % java Birthday 365 1000000
 * 1 0 0.0
 * ...
 * 23 31613 0.5064230000000001
 */
public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 1];

        // Run the experiment trials times
        for (int trial = 0; trial < trials; trial++) {
            boolean[] inRoom = new boolean[n];
            int peopleEntered = 0;

            // Keep adding people until collision
            while (true) {
                peopleEntered++;
                int birthday = (int) (Math.random() * n);
                if (inRoom[birthday]) { // Collision!
                    count[peopleEntered]++;
                    break;
                }
                inRoom[birthday] = true;
            }
        }

        // Print results until fraction >= 50%
        double cumulative = 0.0;
        for (int i = 1; i <= n; i++) {
            cumulative += (double) count[i] / trials;
            System.out.println(i + " " + count[i] + " " + cumulative);
            if (cumulative >= 0.5) {
                break;
            }
        }
    }

}
