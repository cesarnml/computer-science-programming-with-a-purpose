/**
 * Compilation: javac BandMatrix.java
 * Execution: java BandMatrix [n] [width]
 *
 * Takes two integer command-line arguments n and width, and prints an n x n
 * band matrix where entries are asterisks (*) if they are within width distance
 * from the diagonal, and zeros (0) otherwise.
 *
 * % java BandMatrix 5 1
 * * * 0 0 0
 * * * * 0 0
 * 0 * * * 0
 * 0 0 * * *
 * 0 0 0 * *
 *
 * % java BandMatrix 8 2
 * * * * 0 0 0 0 0
 * * * * * 0 0 0 0
 * * * * * * 0 0 0
 * 0 * * * * * 0 0
 * 0 0 * * * * * 0
 * 0 0 0 * * * * *
 * 0 0 0 0 * * * *
 * 0 0 0 0 0 * * *
 */
public class BandMatrix {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int width = Integer.parseInt(args[1]);

        for (int i = 0; i < n; i++) {
            String line = "";
            for (int j = 0; j < n; j++) {
                if (Math.abs(j - i) > width) {
                    line += "0";
                } else {
                    line += "*";
                }
                if (j != n - 1) {
                    line += "  ";
                }
            }
            System.out.println(line);
        }
    }
}
