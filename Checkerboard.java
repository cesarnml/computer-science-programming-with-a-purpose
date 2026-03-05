/*
 * Compilation:  javac Checkerboard.java
 * Execution:    java Checkerboard n
 *
 * Takes an integer n as a command-line argument and draws an n-by-n
 * checkerboard using blue and light gray squares, with the bottom-left
 * square colored blue.
 *
 * % java Checkerboard 4
 * (draws a 4-by-4 checkerboard)
 */

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                } else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                }
                double x = 1.0 * j + 0.5;
                double y = 1.0 * i + 0.5;
                StdDraw.filledSquare(x, y, 0.5);
            }
        }
        StdDraw.show();
    }
}
