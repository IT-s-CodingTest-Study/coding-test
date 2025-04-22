import java.util.*;

class Node {
	public int value;
	public int x;
	public int y;
	public Node right;
	public Node left;

	public Node (int value, int x, int y, Node right, Node left){
		this.value = value;
		this.x = x;
		this.y = y;
		this.right = right;
		this.left = left;
	}
}

class Solution {
	int[][] answer = {};
	int idx = 0;
	public int[][] solution(int[][] nodeinfo) {
		Node[] nodes = new Node[nodeinfo.length];
		for(int i = 0; i < nodeinfo.length; i++){
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1], null, null); //left와 right 연결노드는 트리 구성 때 입력
		}

		Arrays.sort(nodes, new Comparator<Node>() {
			public int compare(Node a, Node b){
				if(a.y == b.y){
					return a.x - b.x;// y가 같다면 x좌표는 오름차
				}
				return b.y - a.y;
			}
		});

		Node parent = nodes[0];
		for(int i = 1; i < nodes.length; i++){
			CreateTree(parent, nodes[i]);
		}

		answer = new int[2][nodeinfo.length];

		//전위순회 시행
		preorder(parent);
		idx=0;

		//후위순회 시행
		postorder(parent);

		return answer;
	}

	//Tree 만드는 메서드
	public void CreateTree(Node parent, Node child){
		if(parent.x < child.x){
			if(parent.right == null){
				parent.right = child;
			} else {
				CreateTree(parent.right, child);
			}
		} else {
			if(parent.left == null) {
				parent.left = child;
			} else {
				CreateTree(parent.left, child);
			}
		}
	}

	//전위순회
	public void preorder(Node root){
		if(root != null){
			answer[0][idx++] = root.value;
			preorder(root.left);
			preorder(root.right);
		}
	}

	//후위순회
	public void postorder(Node root){
		if(root != null){
			postorder(root.left);
			postorder(root.right);
			answer[1][idx++] = root.value;
		}
	}
}
