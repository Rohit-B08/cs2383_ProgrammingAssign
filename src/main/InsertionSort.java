import java.util.Random;

public class InsertionSort {

    public static int[] integerInsertion(int[] values) {
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
        return values;
    }

    public static double[] doubleInsertion(double[] values) {
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
        return values;
    }

    public static char[] charInsertion(char[] values) {
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
        return values;
    }

    public static String[] stringInsertion(String[] values) {
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
            intValues[i] = (int) (Math.random() * 10000 + 0);
            doubleValues[i] = (Math.random() * 10000 + 0);
            charValues[i] = charLibrary[(int) (Math.random() * (charLibrary.length) + 0)];

            for (int j = 0; j <= 4; j++) {
                int index = random.nextInt(stringAlphabet.length());
                char randomChar = stringAlphabet.charAt(index);
                sb.append(randomChar);
            }

            stringValues[i] = sb.toString();
            sb = new StringBuilder();
        }

        double startTime = System.currentTimeMillis();
        integerInsertion(intValues);
        double endTime = System.currentTimeMillis();
        System.out.println("Int Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        doubleInsertion(doubleValues);
        endTime = System.currentTimeMillis();
        System.out.println("Double Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        charInsertion(charValues);
        endTime = System.currentTimeMillis();
        System.out.println("Char Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        stringInsertion(stringValues);
        endTime = System.currentTimeMillis();
        System.out.println("String Execution Time: " + (endTime - startTime));

    }

}
