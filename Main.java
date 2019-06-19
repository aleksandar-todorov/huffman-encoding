import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	private static int treeHeight = 0;
	private static int encondingLength = 0;
	private static Map<Character, Integer> symbolCount = new HashMap<>();
	
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String data = scanner.nextLine();
		scanner.close();
		
		/*
		 * Step 1 : Counting Frequencies
		 */
		
		for(int i=0; i<data.length();i++) {
			if(!symbolCount.containsKey(data.charAt(i))) 
			{
				symbolCount.put(data.charAt(i), 1);
			} else
			{
				symbolCount.put(data.charAt(i), symbolCount.get(data.charAt(i)) + 1);
			}
		}
		
		/*
		 * Step 2 : Building Priority Queue and Nodes
		 */

		PriorityQueue<Node> pQueue = new PriorityQueue<>();
		
		for(Map.Entry<Character, Integer> entry : symbolCount.entrySet()) {
			Node currentNode = new Node(entry.getKey(), entry.getValue());
			pQueue.offer(currentNode);
		}
		
		/*
		 * Step 3 : Building root and Nodes
		 */
			while(pQueue.size() > 1) 
			{
				Node leftNode = pQueue.poll();
				Node rightNode = pQueue.poll();
				
				Node parentNode = new Node(leftNode.getCount() + rightNode.getCount());
				
				parentNode.setLeft(leftNode);
				parentNode.setRight(rightNode);
				pQueue.offer(parentNode);
				
			}
			
			Node root = pQueue.poll();
			
		/*
		 * Step 4 : Finding height of root and length of code
		 */
			findTreeHeight(root, 0);
			findencondingLength(root, 0);
			
			System.out.println("treeHeight : " + treeHeight);
			System.out.println("encondingLength : " + encondingLength);
			 
	}
	
	public static void findTreeHeight(Node currentNode, int currentHeight) {

		if(currentNode == null) return ;
		
		findTreeHeight(currentNode.getLeft(), currentHeight + 1);
		findTreeHeight(currentNode.getRight(), currentHeight + 1);
		
		if(currentHeight > treeHeight) treeHeight = currentHeight;
		
		return ;
	}
	
	public static void findencondingLength(Node currentNode, int currentHeight) {
		
		if(currentNode == null) return ;
		
		findencondingLength(currentNode.getLeft(), currentHeight + 1);
		findencondingLength(currentNode.getRight(), currentHeight + 1);
		
		char currentSymbol = currentNode.getSymbol();
		if(currentSymbol != '\u0000') encondingLength += currentHeight*symbolCount.get(currentSymbol);
	
		return ;
	}
}









