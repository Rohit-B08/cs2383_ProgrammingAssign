import java.util.ArrayList;

public class TwoChoicesHashtable {
	
	private static ArrayList<Node> table;
	
	private class Node{
		public String key;
		public Node next = null;
		
		public Node(String key) {
			this.key = key;
		}
	}
	
	public int bucketCount(int index) {
		int count = 0;
		Node pointer = table.get(index);
		while(pointer != null) {
			count++;
			pointer = pointer.next;
		}
		return count;
	}
	
	public int hashcode(String key) {			//sum ascii values of all chars
		int hashcode = 0;
		for (int i=0; i<key.length(); i++) {
			hashcode += key.charAt(i);
		}
		return hashcode;
	}
	
	public int hash1(int hashcode) {
		return (hashcode % 10);
	}
	
	public int hash2(int hashcode) {
		return ((2*hashcode) % 10);
	}
	
	public void add(String key) {
		Node toAdd = new Node(key);
		int index1 = hash1(hashcode(key));
		int index2 = hash2(hashcode(key));
		if (table.get(index1) != null && table.get(index2) != null) { //both buckets occupied
			if (bucketCount(index1) < bucketCount(index2)) {
				
			}
		}
		else if (table.get(index1) == null)	//first bucket empty
			table.add(index1, toAdd);
		else if (table.get(index2) == null) //second bucket empty
			table.add(index2, toAdd);
	}
	
	public static void main(String[] args) {
		
		table = new ArrayList<Node>(10);
		
	}
}
