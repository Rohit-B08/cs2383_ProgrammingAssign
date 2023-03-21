
public class matrixAddition {

    public static long[][] addSquareMatrix(long[][] a, long[][] b) {
        double startTime = System.currentTimeMillis();
        long[][] sum = new long[a.length][a.length];

        for(int i=0; i<a.length; i++) {
            for(int j = 0; j < a.length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        double endTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (endTime - startTime));
        return sum;
    }

    public static void main(String[] args) {

        int size  = 9200;
        long[][] first = new long[size][size];
        long[][] second = new long[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                first[i][j] = (i*j);
                second[i][j] = (i+j);
            }
        }
        addSquareMatrix(first, second);

    }
}
