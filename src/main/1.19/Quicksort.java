public class Quicksort
{
	public static void quicksort(int[] toSort)
	{
		quicksort(toSort, 0, toSort.length - 1);
	}
	
	private static void quicksort(int[] toSort, int left, int right)
	{
		if (left < right)
		{
			int pivotIndex = partition(toSort, left, right);
			quicksort(toSort, left, pivotIndex - 1);
			quicksort(toSort, pivotIndex + 1, right);
		}
	}
	
	private static int partition(int[] arr, int left, int right)
	{
		int pivot = arr[(left + right) / 2];
		int i = left;
		int j = right;
		while (i <= j)
		{
			while (arr[i] < pivot)
			{
				i++;
			}
			while (arr[j] > pivot)
			{
				j--;
			}
			if (i <= j)
			{
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		return i;
	}
	
	private static void swap(int[] arr, int i, int j)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
