/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */

public class WorldMap {
    /**
     * Reads a map description from standard input and draws each region polygon.
     * Input format:
     * 1) canvas width and height,
     * 2) repeated region blocks containing: region name, vertex count, then
     *    vertex coordinate pairs (x, y).
     */
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
