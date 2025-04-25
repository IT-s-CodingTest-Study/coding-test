import java.util.*;
class Solution {

    // 노드 클래스 선언: 좌표 (x, y)와 노드 인덱스, 좌우 자식 노드 연결
    class Node {
        int x, y, index;
        Node left, right;

        Node(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;

        // Node 배열 생성 (x, y, index 포함)
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        // y 내림차순 → x 오름차순으로 정렬
        Arrays.sort(nodes, (a, b) -> {
            if (b.y == a.y) {
                return a.x - b.x;
            } else {
                return b.y - a.y;
            }
        });

        // 트리 구성: 첫 노드를 루트로 지정
        Node root = nodes[0];
        for (int i = 1; i < n; i++) {
            insert(root, nodes[i]);
        }

        // 전위/후위 순회 결과 저장용 리스트
        List<Integer> pre = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        preorder(root, pre);
        postorder(root, post);

        // 결과를 2차원 배열에 저장
        int[][] answer = new int[2][n];
        for (int i = 0; i < n; i++) {
            answer[0][i] = pre.get(i);   // 전위 순회 결과
            answer[1][i] = post.get(i);  // 후위 순회 결과
        }

        return answer;
    }

    // 트리에 자식 노드 삽입
    void insert(Node parent, Node child) {
        if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }

    // 전위 순회: 루트 → 왼쪽 → 오른쪽
    void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.index);
        preorder(node.left, list);
        preorder(node.right, list);
    }

    // 후위 순회: 왼쪽 → 오른쪽 → 루트
    void postorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.index);
    }
}
