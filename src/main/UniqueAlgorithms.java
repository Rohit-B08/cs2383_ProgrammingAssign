import java.util.Arrays;

 /** For each of the algorithms unique1 and unique2, which solve the element uniqueness problem,
 * perform an experimental analysis to determine the largest value of n
 * such that the given algorithm runs in one minute or less.
 * This creates unique value arrays for maximum processing required. */

 public class UniqueAlgorithms {
    public static void main(String args[]) {

        /** Perform an experimental analysis that compares
         * the relative running times of the methods shown in Code Fragment 4.12 */

        // Make arrays of length 10
        int[] arrayLength10 = makeUniqueArray(10);

        // Make arrays of length 100
        int[] arrayLength100 = makeUniqueArray(100);

        // Make arrays of length 1000
        int[] arrayLength1000 = makeUniqueArray(1000);

        // Make arrays of length 10000
        int[] arrayLength10000 = makeUniqueArray(10000);

        // Make arrays of length 100000
        int[] arrayLength100000 = makeUniqueArray(100000);

        // Make arrays of length 1000000
        int[] arrayLength1000000 = makeUniqueArray(1000000);

        // Make arrays of length 10000000
        int[] arrayLength10000000 = makeUniqueArray(10000000);

        // Make arrays of length 100000000
        int[] arrayLength100000000 = makeUniqueArray(100000000);

        // Going bigger makes java run out of heap space (OutOfMemoryError).

        // Make array of the arrays
        int[][] allArrays = {arrayLength10, arrayLength100, arrayLength1000, arrayLength10000, arrayLength100000, arrayLength1000000, arrayLength10000000, arrayLength100000000};

        System.out.println("------- Using unique numbers & Array length up to N=100,000,000 -------");

        // Run each array through unique1 & print timing
        int counter = 10;
        for (int[] currentArray : allArrays) {
            long startTime = getCurrentTime();
            boolean unique1Value = unique1(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter + " running unique1 was " + totalTime + "ms. Returned value of uniqueness was " + unique1Value);
            counter = counter * 10;
            if (totalTime > 1000) {
                System.out.println("Time limit exceeded. Stopping.");
                break;
            }
        }

        System.out.println("----------------------------------------");

        // Run each array through unique2 & print timing
        int counter2 = 10;
        for (int[] currentArray : allArrays) {
            long startTime = getCurrentTime();
            boolean unique2Value = unique2(currentArray);
            long endTime = getCurrentTime();
            long totalTime = getElapsedTime(startTime, endTime);
            System.out.println("Time for array " + counter2 + " running unique2 was " + totalTime + "ms. Returned value of uniqueness was " + unique2Value);
            counter2 = counter2 * 10;
            if (totalTime > 1000) {
                System.out.println("Time limit exceeded. Stopping.");
                break;
            }
        }
    }

    // method to create array of random integers with length n
    public static int[] makeArray(int arrayLength) {
        int[] intArray = new int[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            int randomValue = getRandomNumber();
            intArray[i] = randomValue;
        }
        return intArray;
    }

     // method to create array of integers with length n, unique values in descending order
     public static int[] makeUniqueArray(int arrayLength) {
         int[] intArray = new int[arrayLength];
         for (int i = 0; i < arrayLength; i++) {
             int value = arrayLength - i;
             intArray[i] = value;
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

    // Create random numbers between 1 and 1000000000
    public static int getRandomNumber() {
        double randomValue = Math.random();
        int randomInt = (int) (randomValue * 1000000000 + 1);
        return randomInt;
    }
    
    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique1(int[ ] data) {
        int n = data.length;
        for (int j=0; j < n-1; j++)
            for (int k=j+1; k < n; k++)
            if (data[j] == data[k]) {
                System.out.println("Data was duplicates at position " + j + ": " + data[j] + " & " + data[k]);
                return false; // found duplicate pair
            }
        return true; // if we reach this, elements are unique
    }

    /** Returns true if there are no duplicate elements in the array. */
    public static boolean unique2(int[ ] data) {
        int n = data.length;
        int[ ] temp = Arrays.copyOf(data, n); // make copy of data
        Arrays.sort(temp); // and sort the copy
        for (int j=0; j < n-1; j++)
            if (temp[j] == temp[j+1]) { // check neighboring entries
                System.out.println("Data was duplicates at position " + j + ": " + temp[j] + " & " + temp[j+1]);
                return false; // found duplicate pair
            }
        return true; // if we reach this, elements are unique
    }

}
