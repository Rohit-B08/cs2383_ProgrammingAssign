import java.lang.Math;
public class PrefixAverage {

    /**
     * Perform an experimental analysis of the two algorithms
     * prefixAverage1 and prefixAverage2, from Section 4.3.3.
     * Visualize their running times as a function of the input
     * size with a log-log chart
     */

    public static void main(String args[]) {
        // Make array of length 10
        double[] arrayLength10 = makeArray(10);

        // Make array of length 100
        double[] arrayLength100 = makeArray(100);

        // Make array of length 1000
        double[] arrayLength1000 = makeArray(1000);

        // Make array of length 10000
        double[] arrayLength10000 = makeArray(10000);

        // Make array of length 100000
        double[] arrayLength100000 = makeArray(100000);

        // Make array of length 1000000
        double[] arrayLength1000000 = makeArray(1000000);

        // Make array of the arrays
        double[][] allArrays = {arrayLength10, arrayLength100, arrayLength1000, arrayLength10000, arrayLength100000, arrayLength1000000};

        // Run each array through prefixAverage1 & print timing
        int counter = 10;
        for (double[] currentArray : allArrays){
            long startTime = getCurrentTime();
            double[] prefixAverage1Array = prefixAverage1(currentArray);
            double average = prefixAverage1Array[currentArray.length-1];
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter + " running prefixAverage1 was " + totalTime + "ms. Average was " + average);
            counter = counter*10;
        }

        // Run each array through prefixAverage2 & print timing
        int counter2 = 10;
        for (double[] currentArray : allArrays){
            long startTime = getCurrentTime();
            double[] prefixAverage2Array = prefixAverage2(currentArray);
            double average = prefixAverage2Array[currentArray.length-1];
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter2 + " running prefixAverage2 was " + totalTime + "ms. Average was " + average + ".");
            counter2 = counter2*10;
        }
    }

    // method to create array of doubles with length n
    public static double[] makeArray(int arrayLength) {
        double[] doubleArray = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            double randomValue = getRandomNumber();
            doubleArray[i] = randomValue;
        }
        return doubleArray;
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

    // Create random numbers between 1 and 100
    public static int getRandomNumber() {
        double randomValue = Math.random();
        int randomInt = (int) (randomValue * 100 + 1);
        return randomInt;
    }

    /**
     * prefixAverage1 Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j].
     */
    public static double[] prefixAverage1(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        for (int j = 0; j < n; j++) {
            double total = 0; // begin computing x[0] + ... + x[j]
            for (int i = 0; i <= j; i++)
                total += x[i];
            a[j] = total / (j + 1); // record the average
        }
        return a;
    }

    /**
     * prefixAverage2 Returns an array a such that, for all j, a[j] equals the average of x[0], ..., x[j].
     */
    public static double[] prefixAverage2(double[] x) {
        int n = x.length;
        double[] a = new double[n]; // filled with zeros by default
        double total = 0; // compute prefix sum as x[0] + x[1] + ...
        for (int j = 0; j < n; j++) {
            total += x[j]; // update prefix sum to include x[j]
            a[j] = total / (j + 1); // compute average based on current sum
        }
        return a;
    }

}
