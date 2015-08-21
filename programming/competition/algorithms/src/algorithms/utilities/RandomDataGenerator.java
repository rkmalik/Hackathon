package algorithms.utilities;

import java.util.Random;

/**
 * This class random data like, random integers, random doubles, random strings.
 * 
 */
public class RandomDataGenerator {

    public static Random rand = new Random();

    public static int getRandomInteger(int range) {
        return rand.nextInt(range);
    }

    public static double getRandomDouble() {
        return rand.nextDouble();
    }

    public static String getRandomString() {
        return null;
    }
}
