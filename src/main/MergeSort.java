import java.util.Random;

public class MergeSort {

    static int[] mergeIntArrays(int[] left, int[] right, int[] values) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k] = left[i];
                i++;
            } else {
                values[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            values[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            values[k] = right[j];
            j++;
            k++;
        }

        return values;
    }

    static double[] mergeDoubleArrays(double[] left, double[] right, double[] values) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k] = left[i];
                i++;
            } else {
                values[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            values[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            values[k] = right[j];
            j++;
            k++;
        }

        return values;
    }

    static char[] mergeCharArrays(char[] left, char[] right, char[] values) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k] = left[i];
                i++;
            } else {
                values[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            values[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            values[k] = right[j];
            j++;
            k++;
        }

        return values;
    }

    static String[] mergeStringArrays(String[] left, String[] right, String[] values) {
        int i = 0, j = 0, k = 0;

        while(i < left.length && j < right.length) {
            if (right[j].compareTo(left[i]) > 0) {
                values[k] = left[i];
                i++;
            } else {
                values[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            values[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            values[k] = right[j];
            j++;
            k++;
        }

        return values;
    }

    public static int[] integerMerge(int[] values) {
        if (values.length == 1) {
            return values;
        }

        int mid = values.length / 2;
        int[] left = new int[mid];
        int[] right = new int[values.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = values[i];
        }

        for (int i = 0; i < values.length - mid; i++) {
            right[i] = values[mid + i];
        }

        left = integerMerge(left);
        right = integerMerge(right);

        values = mergeIntArrays(left, right, values);
        return values;
    }

    public static double[] doubleMerge(double[] values) {
        if (values.length == 1) {
            return values;
        }

        int mid = values.length / 2;
        double[] left = new double[mid];
        double[] right = new double[values.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = values[i];
        }

        for (int i = 0; i < values.length - mid; i++) {
            right[i] = values[mid + i];
        }

        left = doubleMerge(left);
        right = doubleMerge(right);

        values = mergeDoubleArrays(left, right, values);

        return values;
    }

    public static char[] charMerge(char[] values) {
        if (values.length == 1) {
            return values;
        }

        int mid = values.length / 2;
        char[] left = new char[mid];
        char[] right = new char[values.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = values[i];
        }

        for (int i = 0; i < values.length - mid; i++) {
            right[i] = values[mid + i];
        }

        left = charMerge(left);
        right = charMerge(right);

        values = mergeCharArrays(left, right, values);
        return values;
    }

    public static String[] stringMerge(String[] values) {
        if (values.length == 1) {
            return values;
        }

        int mid = values.length / 2;
        String[] left = new String[mid];
        String[] right = new String[values.length - mid];

        for (int i = 0; i < mid; i++) {
            left[i] = values[i];
        }

        for (int i = 0; i < values.length - mid; i++) {
            right[i] = values[mid + i];
        }

        left = stringMerge(left);
        right = stringMerge(right);

        values = mergeStringArrays(left, right, values);
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
        integerMerge(intValues);
        double endTime = System.currentTimeMillis();
        System.out.println("Int Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        doubleMerge(doubleValues);
        endTime = System.currentTimeMillis();
        System.out.println("Double Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        charMerge(charValues);
        endTime = System.currentTimeMillis();
        System.out.println("Char Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        stringMerge(stringValues);
        endTime = System.currentTimeMillis();
        System.out.println("String Execution Time: " + (endTime - startTime));
    }

}
