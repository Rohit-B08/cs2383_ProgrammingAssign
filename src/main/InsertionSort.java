import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static int[] integerInsertion(int[] values) {
        double startTime = System.currentTimeMillis();
        int key, j;
        for (int i = 1; i < values.length; i++) {
            key = values[i];
            j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static double[] doubleInsertion(double[] values) {
        double startTime = System.currentTimeMillis();
        double key;
        int j;
        for (int i = 1; i < values.length; i++) {
            key = values[i];
            j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static char[] charInsertion(char[] values) {
        double startTime = System.currentTimeMillis();
        char key;
        int j;
        for (int i = 1; i < values.length; i++) {
            key = values[i];
            j = i - 1;
            while (j >= 0 && values[j] > key) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static String[] stringInsertion(String[] values) {
        double startTime = System.currentTimeMillis();
        String key;
        int j;
        for (int i = 1; i < values.length; i++) {
            key = values[i];
            j = i - 1;
            while (j >= 0 && values[j].compareTo(key) > 0) {
                values[j + 1] = values[j];
                j--;
            }
            values[j + 1] = key;
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static void main(String[] args) {
        int size = 50;

        char[] charLibrary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String stringAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        int[] intValues = new int[size+1];
        double[] doubleValues = new double[size+1];
        char[] charValues = new char[size+1];
        String[] stringValues = new String[size+1];
        for (int i = 0; i <= size; i++) {
            intValues[i] = i;
            doubleValues[i] = i;
            charValues[i] = charLibrary[(int) (Math.random() * (charLibrary.length) + 0)];

            for (int j = 0; j <= 4; j++) {
                int index = random.nextInt(stringAlphabet.length());
                char randomChar = stringAlphabet.charAt(index);
                sb.append(randomChar);
            }

            stringValues[i] = sb.toString();
            sb = new StringBuilder();
        }

        //System.out.println("Unsorted int array: " + Arrays.toString(intValues));
        integerInsertion(intValues);
        //System.out.println("Sorted int array: " + Arrays.toString(integerInsertion(intValues)));

        /*
        System.out.println("Unsorted double array: " + Arrays.toString(doubleValues));
        System.out.println("Sorted double array: " + Arrays.toString(doubleInsertion(doubleValues)));

        System.out.println("Unsorted char array: " + Arrays.toString(charValues));
        System.out.println("Sorted char array: " + Arrays.toString(charInsertion(charValues)));

        System.out.println("Unsorted string array: " + Arrays.toString(stringValues));
        System.out.println("Sorted string array: " + Arrays.toString(stringInsertion(stringValues)));
        */
    }

}
