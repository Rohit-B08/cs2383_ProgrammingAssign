public class Mergesort
{
	
	public static void mergesort(int[] toSort)
	{
		if (toSort.length <= 1) return;
		
		int leftLength = toSort.length / 2;
		int[] leftHalf = new int[leftLength];
		System.arraycopy(toSort, 0, leftHalf, 0, leftLength);
		int[] rightHalf = new int[toSort.length - leftLength];
		System.arraycopy(toSort, leftLength, rightHalf, 0, toSort.length - leftLength);
		mergesort(leftHalf);
		mergesort(rightHalf);
		merge(toSort, leftHalf, rightHalf);
	}
	
	private static void merge(int[] toSort, int[] leftHalf, int[] rightHalf)
	{
		int iL = 0;
		int iR = 0;
		// Compare the two arrays
		for (int placed = 0; placed < toSort.length; placed++)
		{
			if (leftHalf[iL] < rightHalf[iR])
			{
				toSort[placed] = leftHalf[iL];
				iL++;
				// If the left array is completed: append all the items from the right array
				if (iL == leftHalf.length)
				{
					System.arraycopy(rightHalf, iR, toSort, placed + 1, rightHalf.length - iR);
					return;
				}
			}
			else
			{
				toSort[placed] = rightHalf[iR];
				iR++;
				// If the right array is completed: append all the items from the left array
				if (iR == rightHalf.length)
				{
					System.arraycopy(leftHalf, iL, toSort, placed + 1, leftHalf.length - iL);
					return;
				}
			}
		}
	}
}
