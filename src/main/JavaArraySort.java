import java.util.Arrays;

public class JavaArraySort {

    public static void main(String args[]) {

        /** Perform an experimental analysis to test the hypothesis that
         * Java’s Array.sort method runs in O(nlogn) time on average
         * Using random numbers from 1 to 100,000 */

        // Make arrays of length 100
        int[] arrayLength100 = makeArray(100);

        // Make arrays of length 1000
        int[] arrayLength1000 = makeArray(1000);

        // Make arrays of length 10000
        int[] arrayLength10000 = makeArray(10000);

        // Make arrays of length 100000
        int[] arrayLength100000 = makeArray(100000);

        // Make arrays of length 1000000
        int[] arrayLength1000000 = makeArray(1000000);

        // Make arrays of length 10000000
        int[] arrayLength10000000 = makeArray(10000000);

        // Make arrays of length 100000000
        int[] arrayLength100000000 = makeArray(100000000);

        // Make array of the arrays
        int[][] allArrays = {arrayLength100, arrayLength1000, arrayLength10000, arrayLength100000, arrayLength1000000, arrayLength10000000, arrayLength100000000};

        System.out.println("------- Using random numbers 1 to 100,000 & Array length up to N=100,000,000 -------");

        // Run each array through unique1 & print timing
        int counter = 100;
        for (int[] currentArray : allArrays) {
            long startTime = getCurrentTime();
            boolean currentValue = sortArray(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter + " running Java's Array sort was " + totalTime + "ms.");
            counter = counter * 10;
        }
    }

    // method to create array of integers with length n
    public static int[] makeArray(int arrayLength) {
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int randomValue = getRandomNumber();
            intArray[i] = randomValue;
        }
        return intArray;
    }

    // method to get current time in ms
    public static long getCurrentTime() {
        long currentTimeInMs = System.currentTimeMillis();
        return currentTimeInMs;
    }

    // method to calculate elapsed time
    public static long getElapsedTime(long startTime, long endTime) {
        long elapsedTime = endTime - startTime;
        return elapsedTime;
    }

    // Create random numbers between 1 and 100000
    public static int getRandomNumber() {
        double randomValue = Math.random();
        int randomInt = (int) (randomValue * 100000 + 1);
        return randomInt;
    }

    public static boolean sortArray(int[ ] data) {
        Arrays.sort(data); // sort the data
        return true;
    }
}
