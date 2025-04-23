import java.util.*;

class 길찾기게임 {
    int[][] answer;
    int idx;
    public int[][] solution(int[][] nodeinfo) {
        // node 저장할 배열 정의
        Node[] nodes = new Node[nodeinfo.length];
        for(int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        // nodes 정렬
        Arrays.sort(nodes, (n1, n2) -> {
           if(n1.y == n2.y) {           // y 값이 같다면
               return n1.x - n2.x;      // x 값 오름차순 정렬
           } else {                     // y 값이 같지 않다면
               return n2.y - n1.y;      // y 값 내림차순 정렬
           }
        });
        Node root = nodes[0];
        for(int i = 1; i < nodes.length; i++) {
            insertNode(root, nodes[i]);
        }

        answer = new int[2][nodeinfo.length];
        idx = 0;
        preorder(root);
        idx = 0;
        postorder(root);
        return answer;
    }

    // 노드 삽입
    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    // 전위 순회
    public void preorder(Node root) {
        if(root != null) {
            answer[0][idx++] = root.value;
            preorder(root.left);
            preorder(root.right);
        }
    }

    // 후위 순회
    public void postorder(Node root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            answer[1][idx++] = root.value;
        }
    }

    // 노드 클래스
    public static class Node {
        int x, y, value;
        Node left, right;

        public Node(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}

