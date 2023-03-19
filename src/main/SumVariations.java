public class SumVariations {
    public static void main(String args[]) {

        /** Perform an experimental analysis that compares
         * the relative running times of the methods shown in Code Fragment 4.12 */

        // Make arrays of length 10
        int[] arrayLength10 = makeArray(10);
        int[] arrayLength10B = makeArray(10);

        // Make arrays of length 100
        int[] arrayLength100 = makeArray(100);
        int[] arrayLength100B = makeArray(100);

        // Make arrays of length 1000
        int[] arrayLength1000 = makeArray(1000);
        int[] arrayLength1000B = makeArray(1000);

        // Make arrays of length 10000
        int[] arrayLength10000 = makeArray(10000);
        int[] arrayLength10000B = makeArray(10000);

        // Make arrays of length 100000
        int[] arrayLength100000 = makeArray(100000);
        int[] arrayLength100000B = makeArray(100000);

        // Make arrays of length 1000000
        int[] arrayLength1000000 = makeArray(1000000);
        int[] arrayLength1000000B = makeArray(1000000);

        // Make array of the arrays
        int[][] allArrays = {arrayLength10, arrayLength100, arrayLength1000, arrayLength10000, arrayLength100000, arrayLength1000000};

        int[][] allArraysB = {arrayLength10B, arrayLength100B, arrayLength1000B, arrayLength10000B, arrayLength100000B, arrayLength100000B};

        // Run each array through example1 & print timing
        int counter = 10;
        for (int[] currentArray : allArrays){
            long startTime = getCurrentTime();
            int example1ArrayValue = example1(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter + " running example1 was " + totalTime + "ms. Returned value was " + example1ArrayValue);
            counter = counter*10;
        }

        System.out.println("----------------------------------------");

        // Run each array through example2 & print timing
        int counter2 = 10;
        for (int[] currentArray : allArrays){
            long startTime = getCurrentTime();
            int example2ArrayValue = example2(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter2 + " running example2 was " + totalTime + "ms. Returned value was " + example2ArrayValue);
            counter2 = counter2*10;
        }

        System.out.println("----------------------------------------");

        // Run each array through example3 & print timing
        int counter3 = 10;
        for (int[] currentArray : allArrays){
            long startTime = getCurrentTime();
            long example3ArrayValue = example3(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter3 + " running example3 was " + totalTime + "ms. Returned value was " + example3ArrayValue);
            counter3 = counter3*10;
        }

        System.out.println("----------------------------------------");

        // Run each array through example4 & print timing
        int counter4 = 10;
        for (int[] currentArray : allArrays){
            long startTime = getCurrentTime();
            long example4ArrayValue = example4(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter4 + " running example4 was " + totalTime + "ms. Returned value was " + example4ArrayValue);
            counter4 = counter4*10;
        }

        System.out.println("----------------------------------------");
        System.out.println("----- Warning! Example5 takes too long to run. Set to stop at N=10,000 -----");
        System.out.println("----- Change for loop length if you want to try more. ----------------------");
        System.out.println("----------------------------------------");

        // Run each array through example5 & print timing, stopping at 10,000 which is the last reasonable value to run.
        int counter5 = 10;
        for (int i = 0; i < allArrays.length-2; i++) {
            int[] currentArray = allArrays[i];
            int[] currentArrayB = allArraysB[i];
            long startTime = getCurrentTime();
            int example5ArrayValue = example5(currentArray, currentArrayB);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter5 + " running example5 was " + totalTime + "ms. Returned value was " + example5ArrayValue);
            counter5 = counter5*10;
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

    // Create random numbers between 1 and 1000
    public static int getRandomNumber() {
        double randomValue = Math.random();
        int randomInt = (int) (randomValue * 1000 + 1);
        return randomInt;
    }

    /** Returns the sum of the integers in given array.*/
    public static int example1(int[ ] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j++) // loop from 0 to n-1
            total += arr[j];
        return total;
    }

    /** Returns the sum of the integers with even index in given array.*/
    public static int example2(int[ ] arr) {
        int n = arr.length, total = 0;
        for (int j=0; j < n; j += 2) // note the increment of 2
            total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array.*/
    public static long example3(int[ ] arr) {
        int n = arr.length;
        long total = 0;
        for (int j=0; j < n; j++) // loop from 0 to n-1
            for (int k=0; k <= j; k++) // loop from 0 to j
            total += arr[j];
        return total;
    }

    /** Returns the sum of the prefix sums of given array.*/
    public static long example4(int[ ] arr) {
        int n = arr.length, prefix = 0;
        long total = 0;
        for (int j=0; j < n; j++) { // loop from 0 to n-1
            prefix += arr[j];
            total += prefix;
            }
        return total;
    }

    /** Returns the number of times second array stores sum of prefix sums from first.*/
    public static int example5(int[ ] first, int[ ] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i=0; i < n; i++) { // loop from 0 to n-1
            int total = 0;
            for (int j=0; j < n; j++) // loop from 0 to n-1
                for (int k=0; k <= j; k++) // loop from 0 to j
                total += first[k];
            if (second[i] == total) count++;
            }
        return count;
    }

}
