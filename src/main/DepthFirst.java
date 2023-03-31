package graph_traversal.depth_first;

import graph_traversal.GraphLoader;
import graph_traversal.Node;

import java.util.HashSet;
import java.util.Set;

public class DepthFirst
{
	public static void main(String[] args)
	{
		System.out.println("Depth first");
		System.out.println("Graph 1");
		Node graph1 = GraphLoader.graph1();
		System.out.println(dfs(graph1, "c"));
		System.out.println(dfs(graph1, "g"));
//		System.out.println(dfs(graph1, "none"));
		
		System.out.println("Graph 2");
		Node graph2 = GraphLoader.graph2();
		System.out.println(dfs(graph2, "b"));
		System.out.println(dfs(graph2, "e"));
		System.out.println(dfs(graph2, "f"));
	}
	
	private static PathHistory dfs(Node graph, String goal)
	{
		HashSet<Node> visited = new HashSet<>();
		visited.add(graph);
		return dfs(graph, goal, new PathHistory(graph), visited);
	}
	
	private static PathHistory dfs(Node current, String goal, PathHistory progress, Set<Node> visited)
	{
		if (current.hasId(goal)) return progress;
		for (Node neighbour : current.getNeighbours())
		{
			if (!visited.add(neighbour)) continue;
			progress.addNode(neighbour);
			PathHistory result = dfs(neighbour, goal, progress, visited);
			if (result != null) return result;
			progress.removeLast();
		}
		return null;
	}
}
