import java.util.Random;

public class BubbleSort {

    public static int[] integerBubble(int[] values) {
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
        return values;
    }

    public static double[] doubleBubble(double[] values) {
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
        return values;
    }

    public static String[] stringBubble(String[] values) {
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
        return values;
    }

    public static void main(String[] args) {
        int size = 100000;

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
        double startTime, endTime;

        startTime = System.currentTimeMillis();
        integerBubble(intValues);
        endTime = System.currentTimeMillis();
        System.out.println("Int Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        doubleBubble(doubleValues);
        endTime = System.currentTimeMillis();
        System.out.println("Double Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        charBubble(charValues);
        endTime = System.currentTimeMillis();
        System.out.println("Char Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        stringBubble(stringValues);
        endTime = System.currentTimeMillis();
        System.out.println("String Execution Time: " + (endTime - startTime));

    }

}
