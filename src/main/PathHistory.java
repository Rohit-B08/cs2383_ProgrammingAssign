package graph_traversal.depth_first;

import graph_traversal.Node;

/**
 * Single linked list where you can easily add or remove the last item from it
 */
public class PathHistory
{
	private final Node node;
	private PathHistory next = null;
	
	public PathHistory(Node node)
	{
		this.node = node;
	}
	
	/**
	 * Add one Node to the end
	 *
	 * @param toAdd The node to add
	 */
	public void addNode(Node toAdd)
	{
		// If this is the last node, add it to the end of this
		if (next == null)
		{
			next = new PathHistory(toAdd);
		}
		// Pass along the node
		else
		{
			next.addNode(toAdd);
		}
	}
	
	/**
	 * Remove the last node in the list
	 */
	public void removeLast()
	{
		// Failsafe, when attempting to remove yourself
		if (next == null) return;
		// If the next node is the last one, forget it
		if (next.next == null)
		{
			next = null;
		}
		// Pass along the order that a node should be removed
		else
		{
			next.removeLast();
		}
	}
	
	@Override
	public String toString()
	{
		if (next == null) return node.getId();
		return node.getId() + " -> " + next.toString();
	}
}
