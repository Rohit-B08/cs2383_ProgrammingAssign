import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class HashcodeCollisionAnalysis
{
	public static final int BASE = 10;
	public static final int MAX_HASH = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws FileNotFoundException
	{
		HashMap<Integer, HashSet<String>> results = new HashMap<>();
		int wordCount = hashWords(args[0], results);
		IntSummaryStatistics statistics = results.values()
		                                         .stream()
		                                         .mapToInt(Collection::size)
		                                         .summaryStatistics();
		System.out.println("Base:                    " + BASE);
		System.out.println("Word count:              " + wordCount);
		System.out.println("Unique word count:       " + statistics.getSum());
		System.out.println("Hashes:                  " + results.size());
		System.out.printf( "Collision chance:        %.2f%%\n", 100 - 100 * (results.size() / (double) statistics.getSum()));
		System.out.println("Highest collision count: " + statistics.getMax());
		System.out.println("average collision:       " + statistics.getAverage());
		if (statistics.getMax() > 1) showLargestCollisions(results, statistics);
	}
	
	private static int hashWords(String filename, HashMap<Integer, HashSet<String>> results) throws FileNotFoundException
	{
		File file = new File(filename);
		try (Scanner scan = new Scanner(file))
		{
			int wordCount = 0;
			while (scan.hasNextLine())
			{
				String line = scan.nextLine();
				if (line.isBlank()) continue;
				String[] words = line.split("\s+");
				wordCount += words.length;
				for (String word : words)
				{
					word = word.trim();
					results.computeIfAbsent(hash(word), k -> new HashSet<>())
					       .add(word);
				}
			}
			return wordCount;
		}
	}
	
	/**
	 * <a href="https://byby.dev/polynomial-rolling-hash">Implementation based on</a>
	 */
	private static int hash(String key)
	{
		int hash = 0;
		for (char c : key.toCharArray())
		{
			hash = (hash * BASE + c) % MAX_HASH;
		}
		return hash;
	}
	
	private static void showLargestCollisions(HashMap<Integer, HashSet<String>> results, IntSummaryStatistics statistics)
	{
		List<HashSet<String>> show = results.values()
		                                    .stream()
		                                    .filter(set -> set.size() == statistics.getMax())
		                                    .toList();
		int showAmount = show.size();
		System.out.println("Largest collisions:");
		if (showAmount > 3)
		{
			System.out.println("Showing 3/" + show.size());
			showAmount = 3;
		}
		for (int i = 0; i < showAmount; i++)
		{
			Iterator<String> iterator = show.get(i).iterator();
			String collision = iterator.next();
			System.out.print(hash(collision) + ": " + collision);
			while (iterator.hasNext())
			{
				System.out.print(" " + iterator.next());
			}
			System.out.println();
		}
	}
}
