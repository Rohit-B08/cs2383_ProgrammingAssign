package graph_traversal;

public class GraphLoader
{
	private GraphLoader() {}
	
	public static Node graph1()
	{
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		Node g = new Node("g");
		a.addBiDirectionalPath(b, d);
		b.addBiDirectionalPath(c, d);
		c.addBiDirectionalPath(d, f);
		d.addBiDirectionalPath(e);
		e.addBiDirectionalPath(f);
		f.addBiDirectionalPath(g);
		return a;
	}
	
	public static Node graph2()
	{
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");
		Node e = new Node("e");
		Node f = new Node("f");
		a.addBiDirectionalPath(b, d);
		b.addBiDirectionalPath(c, d);
		c.addBiDirectionalPath(d, e);
		d.addBiDirectionalPath(e, f);
		return a;
	}
}
