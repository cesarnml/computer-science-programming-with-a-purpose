/*
 * Compilation:  javac WorldMap.java
 * Execution:    java WorldMap < input.txt
 *
 * Reads map boundary data from standard input and draws each region as a
 * polygon using StdDraw. The input begins with canvas width and height.
 * Each region then provides: region name, number of vertices, and that many
 * (x, y) coordinate pairs.
 *
 * % java WorldMap < usa.txt
 */
public class WorldMap {
    public static void main(String[] args) {
        int width = StdIn.readInt();
        int height = StdIn.readInt();
        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        while (!StdIn.isEmpty()) {
            StdIn.readString(); // region name is not needed for drawing
            int vertices = StdIn.readInt();
            double[] x = new double[vertices];
            double[] y = new double[vertices];

            for (int i = 0; i < vertices; i++) {
                x[i] = StdIn.readDouble();
                y[i] = StdIn.readDouble();
            }
            StdDraw.polygon(x, y);
        }
        StdDraw.show();
    }
}
