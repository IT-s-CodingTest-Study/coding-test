import java.util.*;

class Solution {
    
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        
        // Point 클래스를 이용하여 입력값 처리
        Point[] point = new Point[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            point[i] = new Point(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }
        
        // Y가 큰 순, X가 작은 순 정렬
        Arrays.sort(point, (a, b) -> {
            return a.y == b.y ? a.x - b.x : b.y - a.y;
        });
        
        // root 트리 생성 및 나머지 Point 트리에 삽입
        TreeNode root = new TreeNode(point[0]);
        for (int i = 1; i < point.length; i++) {
            insert(root, new TreeNode(point[i]));
        }
            
        // 전위 탐색, 후위탐색 실행
        preOrder(root);
        postOrder(root);
        
        // 리스트를 배열로 변경
        answer[0] = preOrderList.stream().mapToInt(i -> i).toArray();
        answer[1] = postOrderList.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
    
    public void insert(TreeNode parent, TreeNode child) {
        if (child.data.x < parent.data.x) {
            if (parent.leftChild == null) {
                parent.leftChild = child;
            } else {
                insert(parent.leftChild, child);
            }
        } else {
            if (parent.rightChild == null) {
                parent.rightChild = child;
            } else {
                insert(parent.rightChild, child);
            }
        }
    }
    
    public void preOrder(TreeNode node) {
        if (node != null) {
            preOrderList.add(node.data.index);
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }
    
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            postOrderList.add(node.data.index);
        }
    }
    
}

class Point {
    int x, y, index;
    Point(int x, int y, int index) {
        this.x = x;
        this.y = y;
        this.index = index;
    }
}

class TreeNode {
    Point data;
    TreeNode leftChild;
    TreeNode rightChild;
    
    TreeNode(Point data) {
        this.data = data;
    }
}