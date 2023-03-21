import java.util.ArrayList;

public class TwoChoicesHashtable {
	
	private static ArrayList<Node> table;
	
	private class Node{
		public String key;
		public Node next = null;
	}
	
	private int bucketCount(int index) {	//helper method to count collisions
		int count = 0;
		Node pointer = table.get(index);
		while(pointer != null) {
			count++;
			pointer = pointer.next;
		}
		return count;
	}
	
	private Node lastNode(int i) {			//helper method to retrieve the last node of a bucket
		Node temp = table.get(i);
		while (temp.next != null) {
			temp = temp.next;
		}
		return temp;
	}
	
	public int hashcode(String key) {		//method: sum the ascii values of all chars
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
	
	public void add(Node toAdd) {
		int index1 = hash1(hashcode(toAdd.key));
		int index2 = hash2(hashcode(toAdd.key));
		if (table.get(index1) != null && table.get(index2) != null) {	//both buckets occupied
			if (bucketCount(index1) > bucketCount(index2)) {	//right has less collisions
				lastNode(index2).next = toAdd;
			}
			else {												//default: insert at left
				lastNode(index1).next = toAdd;
			}
		}
		else if (table.get(index1) == null)								//left bucket empty
			table.add(index1, toAdd);
		else if (table.get(index2) == null)								//right bucket empty
			table.add(index2, toAdd);
	}
	
	public static void main(String[] args) {
		
		// Not sure if I need to make a driver for this
		
	}
}
