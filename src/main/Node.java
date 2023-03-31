package graph_traversal;

import java.util.HashSet;
import java.util.Set;

public class Node
{
	private final String id;
	private final Set<Node> paths = new HashSet<>();
	
	public Node(String id)
	{
		this.id = id;
	}
	
	public String getId()
	{
		return id;
	}
	
	public boolean hasId(String id)
	{
		return this.id.equalsIgnoreCase(id);
	}
	
	public Node[] getNeighbours()
	{
		return paths.toArray(new Node[0]);
	}
	
	public void addBiDirectionalPath(Node... to)
	{
		if (to == null) return;
		for (Node node : to)
		{
			if (paths.add(node))
			{
				node.addDirectionalPath(this);
			}
		}
	}
	
	public void addDirectionalPath(Node to)
	{
		paths.add(to);
	}
	
	@Override
	public String toString()
	{
		return String.format("%s (%d)", id, paths.size());
	}
}
