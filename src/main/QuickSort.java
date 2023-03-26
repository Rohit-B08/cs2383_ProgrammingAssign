import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    static ArrayList<Integer> mergeIntArrayList(ArrayList<Integer> left, ArrayList<Integer> right, int pivot) {
        ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList());

        intList.addAll(left);
        intList.add(pivot);
        intList.addAll(right);

        return intList;
    }

    static ArrayList<Double> mergeDoubleArrayList(ArrayList<Double> left, ArrayList<Double> right, double pivot) {
        ArrayList<Double> doubleList = new ArrayList<Double>(Arrays.asList());

        doubleList.addAll(left);
        doubleList.add(pivot);
        doubleList.addAll(right);

        return doubleList;
    }

    static ArrayList<Character> mergeCharArrayList(ArrayList<Character> left, ArrayList<Character> right, char pivot) {
        ArrayList<Character> charList = new ArrayList<Character>(Arrays.asList());

        charList.addAll(left);
        charList.add(pivot);
        charList.addAll(right);

        return charList;
    }

    static ArrayList<String> mergeStringArrayList(ArrayList<String> left, ArrayList<String> right, String pivot) {
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList());

        stringList.addAll(left);
        stringList.add(pivot);
        stringList.addAll(right);

        return stringList;
    }

    static ArrayList<Integer> intQuickSort(ArrayList<Integer> intList) {
        //if the length is less than 1
        if(intList.size() <= 1)
            return intList;

        //setting pivot as last value
        int pivot = intList.get(intList.size()-1);

        //ArrayList for items smaller than the pivot
        ArrayList<Integer> intListLeft = new ArrayList<Integer>(Arrays.asList());

        //ArrayList for items bigger than the pivot
        ArrayList<Integer> intListRight = new ArrayList<Integer>(Arrays.asList());

        //cycling through the ArrayList
        for (int i = 0; i < intList.size() - 1; i++) {
            //If value less than pivot, add it to the ArrayList for smaller items
            if(intList.get(i) <= pivot) {
                intListLeft.add(intList.get(i));
            }
            else{ //Else, add it to the ArrayList for bigger items
                intListRight.add(intList.get(i));
            }
        }

        intListLeft = intQuickSort(intListLeft);
        intListRight = intQuickSort(intListRight);

        intList = mergeIntArrayList(intListLeft, intListRight, pivot);

        return intList;
    }

    static ArrayList<Double> doubleQuickSort(ArrayList<Double> doubleList) {
        //if the length is less than 1
        if(doubleList.size() <= 1)
            return doubleList;

        //setting pivot as last value
        double pivot = doubleList.get(doubleList.size()-1);

        //ArrayList for items smaller than the pivot
        ArrayList<Double> doubleListLeft = new ArrayList<Double>(Arrays.asList());

        //ArrayList for items bigger than the pivot
        ArrayList<Double> doubleListRight = new ArrayList<Double>(Arrays.asList());

        //cycling through the ArrayList
        for (int i = 0; i < doubleList.size() - 1; i++) {
            //If value less than pivot, add it to the ArrayList for smaller items
            if(doubleList.get(i) <= pivot) {
                doubleListLeft.add(doubleList.get(i));
            }
            else{ //Else, add it to the ArrayList for bigger items
                doubleListRight.add(doubleList.get(i));
            }
        }

        doubleListLeft = doubleQuickSort(doubleListLeft);
        doubleListRight = doubleQuickSort(doubleListRight);

        doubleList = mergeDoubleArrayList(doubleListLeft, doubleListRight, pivot);

        return doubleList;
    }

    static ArrayList<Character> charQuickSort(ArrayList<Character> charList) {
        //if the length is less than 1
        if(charList.size() <= 1)
            return charList;

        //setting pivot as last value
        char pivot = charList.get(charList.size()-1);

        //ArrayList for items smaller than the pivot
        ArrayList<Character> charListLeft = new ArrayList<Character>(Arrays.asList());

        //ArrayList for items bigger than the pivot
        ArrayList<Character> charListRight = new ArrayList<Character>(Arrays.asList());

        //cycling through the ArrayList
        for (int i = 0; i < charList.size() - 1; i++) {
            //If value less than pivot, add it to the ArrayList for smaller items
            if(charList.get(i) <= pivot) {
                charListLeft.add(charList.get(i));
            }
            else{ //Else, add it to the ArrayList for bigger items
                charListRight.add(charList.get(i));
            }
        }

        charListLeft = charQuickSort(charListLeft);
        charListRight = charQuickSort(charListRight);

        charList = mergeCharArrayList(charListLeft, charListRight, pivot);

        return charList;
    }

    static ArrayList<String> stringQuickSort(ArrayList<String> stringList) {
        //if the length is less than 1
        if(stringList.size() <= 1)
            return stringList;

        //setting pivot as last value
        String pivot = stringList.get(stringList.size()-1);

        //ArrayList for items smaller than the pivot
        ArrayList<String> stringListLeft = new ArrayList<String>(Arrays.asList());

        //ArrayList for items bigger than the pivot
        ArrayList<String> stringListRight = new ArrayList<String>(Arrays.asList());

        //cycling through the ArrayList
        for (int i = 0; i < stringList.size() - 1; i++) {
            //If value less than pivot, add it to the ArrayList for smaller items
            if(stringList.get(i).compareTo(pivot) < 0) {
                stringListLeft.add(stringList.get(i));
            }
            else{ //Else, add it to the ArrayList for bigger items
                stringListRight.add(stringList.get(i));
            }
        }

        stringListLeft = stringQuickSort(stringListLeft);
        stringListRight = stringQuickSort(stringListRight);

        stringList = mergeStringArrayList(stringListLeft, stringListRight, pivot);

        return stringList;
    }

    public static void main(String args[]) {
        int size = 50;

        ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList());
        ArrayList<Double> doubleList = new ArrayList<Double>(Arrays.asList());
        ArrayList<Character> charList = new ArrayList<Character>(Arrays.asList());
        ArrayList<String> stringList = new ArrayList<String>(Arrays.asList());

        char[] charLibrary = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String stringAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i <= size; i++) {
            intList.add((int) (Math.random() * 10000 + 0));
            doubleList.add((Math.random() * 10000 + 0));
            charList.add(charLibrary[(int) (Math.random() * (charLibrary.length) + 0)]);

            for (int j = 0; j <= 4; j++) {
                int index = random.nextInt(stringAlphabet.length());
                char randomChar = stringAlphabet.charAt(index);
                sb.append(randomChar);
            }

            stringList.add(sb.toString());
            sb = new StringBuilder();
        }

        double startTime, endTime;
        startTime = System.currentTimeMillis();
        intQuickSort(intList);
        endTime = System.currentTimeMillis();
        System.out.println("Int Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        doubleQuickSort(doubleList);
        endTime = System.currentTimeMillis();
        System.out.println("Double Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        charQuickSort(charList);
        endTime = System.currentTimeMillis();
        System.out.println("Char Execution Time: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        stringQuickSort(stringList);
        endTime = System.currentTimeMillis();
        System.out.println("String Execution Time: " + (endTime - startTime));
    }
}