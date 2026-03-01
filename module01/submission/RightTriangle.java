/**
 * Compilation: javac RightTriangle.java
 * Execution: java RightTriangle [a] [b] [c]
 *
 * Takes three integer command-line arguments and determines whether they
 * constitute the side lengths of some right triangle. Checks all possible
 * orientations using the Pythagorean theorem.
 *
 * % java RightTriangle 3 4 5
 * true
 *
 * % java RightTriangle 5 12 13
 * true
 *
 * % java RightTriangle 1 2 3
 * false
 */
public class RightTriangle {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        boolean is_right_triangle = (a > 0 && b > 0 && c > 0) && (a * a + b * b == c * c || a * a + c * c == b * b
                || b * b + c * c == a * a);
        System.out.println(is_right_triangle);
    }
}
