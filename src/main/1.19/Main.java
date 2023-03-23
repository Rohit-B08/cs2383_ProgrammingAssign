import java.util.Random;
import java.util.stream.IntStream;

public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Small random data\t" +
		                   "Large random data\t" +
		                   "Almost sorted data\t" +
		                   "Sorted data");
		Sorter[] sorters = {Mergesort::mergesort, Quicksort::quicksort};
		for (Sorter sorter : sorters)
		{
			System.out.print(benchmark(sorter, () -> randomArray(1000), 20000) + " ms\t");
			System.out.print(benchmark(sorter, () -> randomArray(1000000), 500) + " ms\t");
			System.out.print(benchmark(sorter, () -> almostSortedArray(1000000), 2000) + " ms\t");
			System.out.print(benchmark(sorter, () -> sortedArray(1000000), 2000) + " ms");
			System.out.println();
		}
	}
	
	private static double benchmark(Sorter sorter, ArrayGenerator generator, int testCount)
	{
		long totalSortTime = 0;
		for (int i = 0; i < testCount; i++)
		{
			int[] toSort = generator.generate();
			long start = System.currentTimeMillis();
			sorter.sort(toSort);
			totalSortTime += System.currentTimeMillis() - start;
		}
		return totalSortTime / (double) testCount;
	}
	
	private static int[] randomArray(int length)
	{
		return new Random().ints(length).toArray();
	}
	
	private static int[] almostSortedArray(int length)
	{
		Random r = new Random();
		return IntStream.range(0, length)
		                // Add some variation to each value
		                .map(v -> v + r.nextInt(-2, 3))
		                .toArray();
	}
	
	private static int[] sortedArray(int length)
	{
		return IntStream.range(0, length).toArray();
	}
}
