
public class Node implements Comparable<Node>{
	
	private char symbol;
	private int count;
	
	private Node left;
	private Node right;
	
	Node( char symbol, int count) {
        this.setCount(count);
        this.setSymbol(symbol);
    }
	
	Node(int count){
		 this.setCount(count);
		 this.setSymbol('\u0000');
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

	public char getSymbol() {
		return symbol;
	}

	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	@Override
	public int compareTo(Node node) {
		return this.count - node.getCount();
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
