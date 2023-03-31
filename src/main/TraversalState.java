package graph_traversal.breadth_first;

import graph_traversal.Node;

/**
 * Records a step in the traversal that can be picked up later
 */
public class TraversalState
{
	private final Node[] nodes;
	
	public TraversalState(Node first)
	{
		nodes = new Node[]{first};
	}
	
	private TraversalState(Node[] nodes)
	{
		this.nodes = nodes;
	}
	
	/**
	 * Creates a copy of this state with an additional node at the end
	 *
	 * @param toAdd The node to add
	 *
	 * @return The clone
	 */
	public TraversalState cloneWith(Node toAdd)
	{
		Node[] copy = new Node[nodes.length + 1];
		System.arraycopy(nodes, 0, copy, 0, nodes.length);
		copy[copy.length - 1] = toAdd;
		return new TraversalState(copy);
	}
	
	/**
	 * Will get the next options to traverse by taking the neighbours from the last node.
	 * These neighbours still need to be filtered
	 *
	 * @return An array with all the neighbours
	 */
	public Node[] getNeighbours()
	{
		return nodes[nodes.length - 1].getNeighbours();
	}
	
	@Override
	public String toString()
	{
		StringBuilder result = new StringBuilder(nodes[0].getId());
		for (int i = 1; i < nodes.length; i++)
		{
			result.append(" -> ").append(nodes[i].getId());
		}
		return result.toString();
	}
}
