import java.util.PriorityQueue;
import java.util.Scanner;

public class JobScheduler {

	public static void main(String[] args) {
		PriorityQueue<Job> queue = new PriorityQueue<Job>();
		Scanner scan = new Scanner(System.in);
		String input = "";
		Job current = null;
		Job temp = null;
		String name;
		int length, priority;
		while (!input.equals("3")) {
			
			temp = queue.peek();
			if (temp != null && current == null)
				current = temp;
			
			if (current != null) {
				
				if (current.run() >= 0)
					System.out.println("Time-slice used processing job: " + current.getName()
								+ "\nRemaining length: " + current.getLength());
				else {
					queue.remove(current);
					if (temp != null) {
						current = temp;
						current.run();
						System.out.println("Time-slice used processing job: " + current.getName()
						+ "\nRemaining length: " + current.getLength());
					}
					else {
						current = null;
						System.out.println("No job to process.");
					}
				}
				
			}
			else
				System.out.println("No job to process.");
			
			System.out.println("1: Add a job\n2: No new job (continue)\n3: End program");
			input = scan.nextLine();
			
			if (input.equals("1")) {
				System.out.print("Input the job name: ");
				name = scan.nextLine();
				System.out.print("Input the job length (1 to 100 inclusive): ");
				length = Integer.parseInt(scan.nextLine());
				System.out.print("Input the job priority (-20 to 19 inclusive; -20 is highest priority): ");
				priority = Integer.parseInt(scan.nextLine());
				queue.add(new Job(name, length, priority));
				System.out.println("Job added successfully.");
			}
			
		}
		scan.close();
	}
}
