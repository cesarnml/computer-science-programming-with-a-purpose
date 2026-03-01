package optional_enrichment_exercises;

/**
 * 1.2.30 Uniform random numbers. Write a program that prints five uniform
 * random numbers between 0 and 1, their average value, and their minimum and
 * maximum values. Use Math.random(), Math.min(), and Math.max().
 */
public class UniformRandomNumbers {
    public static void main(String[] args) {
        double a = Math.random();
        double b = Math.random();
        double c = Math.random();
        double d = Math.random();
        double e = Math.random();
        double avg = (a + b + c + d + e) / 5;
        double min = Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
        double max = Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + avg + " " + min + " " + max);
    }
}
