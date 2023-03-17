import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static int[] integerBubble(int[] values) {
        double startTime = System.currentTimeMillis();
        int temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j+1]) {
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static double[] doubleBubble(double[] values) {
        double startTime = System.currentTimeMillis();
        double temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j+1]) {
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static char[] charBubble(char[] values) {
        double startTime = System.currentTimeMillis();
        char temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] > values[j+1]) {
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static String[] stringBubble(String[] values) {
        double startTime = System.currentTimeMillis();
        String temp;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j].compareTo(values[j + 1]) > 0) {
                    temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }

        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return values;
    }

    public static void main(String[] args) {
        int size = 5000000;

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
        integerBubble(intValues);
        //System.out.println("Sorted int array: " + Arrays.toString(integerBubble(intValues)));

        /*
        System.out.println("Unsorted double array: " + Arrays.toString(doubleValues));
        System.out.println("Sorted double array: " + Arrays.toString(doubleBubble(doubleValues)));

        System.out.println("Unsorted char array: " + Arrays.toString(charValues));
        System.out.println("Sorted char array: " + Arrays.toString(charBubble(charValues)));

        System.out.println("Unsorted string array: " + Arrays.toString(stringValues));
        System.out.println("Sorted string array: " + Arrays.toString(stringBubble(stringValues)));
        */
    }

}
