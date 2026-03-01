package assignments;

/**
 * Compilation: javac GreatCircle.java
 * Execution: java GreatCircle [x1] [y1] [x2] [y2]
 *
 * Takes four double command-line arguments representing the latitude and
 * longitude (in degrees) of two points on Earth's surface, and prints the
 * great-circle distance (in kilometers) between them using the Haversine
 * formula.
 *
 * % java GreatCircle 40.35 74.65 48.87 -2.33
 * 5902.927099258561 kilometers
 *
 * % java GreatCircle 60.0 15.0 120.0 105.0
 * 4604.53989281927 kilometers
 */
public class GreatCircle {
    public static void main(String[] args) {
        // Parse command-line arguments and convert to radians
        double x1 = Math.toRadians(Double.parseDouble(args[0]));
        double y1 = Math.toRadians(Double.parseDouble(args[1]));
        double x2 = Math.toRadians(Double.parseDouble(args[2]));
        double y2 = Math.toRadians(Double.parseDouble(args[3]));

        // Mean radius of Earth in kilometers
        double r = 6371.0;

        // Haversine formula
        double term1 = Math.sin((x2 - x1) / 2);
        double term2 = Math.sin((y2 - y1) / 2);
        double distance = 2 * r * Math.asin(Math.sqrt(term1 * term1 + Math.cos(x1) * Math.cos(x2) * term2 * term2));

        System.out.println(distance + " kilometers");
    }
}
