
public class Job implements Comparable<Job>{
	private String name;
	private int length, priority;
	
	public Job (String name, int length, int priority) {
		this.name = name;
		this.length = length;
		this.priority = priority;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getLength() {
		return length;
	}
	
	public int run() {
		length--;
		return length;
	}
	
	public String getName() {
		return name;
	}
	
	public int compareTo(Job other) {
		if(this.getPriority() < other.getPriority())		//this has HIGHER priority than other
			return 1;
		else if(this.getPriority() > other.getPriority())	//this has LOWER priority than other
			return -1;
		else												//equal priority
			return 0;
	}
}
