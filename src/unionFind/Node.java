package unionFind;

public class Node {
	private int Parent;
	private int Rank;
	
	public Node(int newParent, int newRank) {
		this.Parent = newParent;
		this.Rank = newRank;
	}

	public int getParent() {
		return Parent;
	}

	public void setParent(int newParent) {
		this.Parent = newParent;
	}

	public int getRank() {
		return Rank;
	}

	public void setRank(int newRank) {
		this.Rank = newRank;
	}
	
	
}
