package assignments;

/**
 * Compilation: javac CMYKtoRGB.java
 * Execution: java CMYKtoRGB [cyan] [magenta] [yellow] [black]
 *
 * Converts from CMYK color format to RGB color format. Takes four double
 * command-line arguments representing cyan, magenta, yellow, and black values
 * (on a scale from 0.0 to 1.0), and prints the corresponding RGB values
 * (on a scale from 0 to 255).
 *
 * % java CMYKtoRGB 0.0 1.0 0.0 0.0
 * red = 255
 * green = 0
 * blue = 255
 *
 * % java CMYKtoRGB 0.0 0.4392156862745098 1.0 0.0
 * red = 255
 * green = 143
 * blue = 0
 */
public class CMYKtoRGB {
    public static void main(String[] args) {
        // Parse command-line arguments
        double cyan = Double.parseDouble(args[0]);
        double magenta = Double.parseDouble(args[1]);
        double yellow = Double.parseDouble(args[2]);
        double black = Double.parseDouble(args[3]);

        // Calculate white
        double white = 1 - black;

        // Calculate RGB values and round to nearest integer
        int red = (int) Math.round(255 * white * (1 - cyan));
        int green = (int) Math.round(255 * white * (1 - magenta));
        int blue = (int) Math.round(255 * white * (1 - yellow));

        // Print RGB values
        System.out.println("red   = " + red);
        System.out.println("green = " + green);
        System.out.println("blue  = " + blue);
    }
}
