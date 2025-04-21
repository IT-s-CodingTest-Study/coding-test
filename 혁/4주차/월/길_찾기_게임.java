import java.util.*;

public class 길_찾기_게임 {
    static class Node {
        int x, y, num;
        Node left, right;
        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    static List<Integer> preorderList = new ArrayList<>();
    static List<Integer> postorderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        Arrays.sort(nodes, (a, b) -> {
            if (b.y != a.y) return b.y - a.y;
            return a.x - b.x;
        });

        Node root = nodes[0];

        for (int i = 1; i < n; i++) {
            insertNode(root, nodes[i]);
        }

        preorder(root);
        postorder(root);

        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = preorderList.get(i);
            answer[1][i] = postorderList.get(i);
        }

        return answer;
    }

    private void insertNode(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) parent.left = child;
            else insertNode(parent.left, child);
        } else {
            if (parent.right == null) parent.right = child;
            else insertNode(parent.right, child);
        }
    }

    private void preorder(Node node) {
        if (node == null) return;
        preorderList.add(node.num);
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderList.add(node.num);
    }
}
