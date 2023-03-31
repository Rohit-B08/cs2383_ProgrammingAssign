package graph_traversal.breadth_first;

import graph_traversal.GraphLoader;
import graph_traversal.Node;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class BreadthFirst
{
	public static void main(String[] args)
	{
		System.out.println("Breadth first");
		System.out.println("Graph 1");
		Node graph1 = GraphLoader.graph1();
		System.out.println(bfs(graph1, "c"));
		System.out.println(bfs(graph1, "g"));
//		System.out.println(bfs(graph1, "none"));
		
		System.out.println("Graph 2");
		Node graph2 = GraphLoader.graph2();
		System.out.println(bfs(graph2, "b"));
		System.out.println(bfs(graph2, "e"));
		System.out.println(bfs(graph2, "f"));
	}
	
	private static TraversalState bfs(Node graph, String goal)
	{
		HashSet<Node> visited = new HashSet<>();
		visited.add(graph);
		Queue<TraversalState> queue = new ArrayDeque<>();
		queue.add(new TraversalState(graph));
		// Go through every state to try and find the goal
		while (!queue.isEmpty())
		{
			TraversalState current = queue.remove();
			// Add all possible directions to the queue
			// Stop if a neighbour is the end goal
			for (Node neighbour : current.getNeighbours())
			{
				if (!visited.add(neighbour)) continue;
				TraversalState withNeighbour = current.cloneWith(neighbour);
				if (neighbour.hasId(goal)) return withNeighbour;
				queue.add(withNeighbour);
			}
		}
		return null;
	}
}
