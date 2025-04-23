import java.util.*;

class 길찾기게임 {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer =  new int[2][nodeinfo.length];
        List<Node> nodes = new ArrayList<>();
        
        for(int i = 0; i<nodeinfo.length; i++){
            nodes.add(new Node(nodeinfo[i][0], nodeinfo[i][1], i+1));}
            nodes.sort((a,b)->{
                if(b.y == a.y)return a.x - b.x;
                return b.y - a.y;
            });
                
            Node root = nodes.get(0);
            for(int i =1; i<nodes.size();i++){
                insert(root, nodes.get(i));
            }
            List<Integer> pre = new ArrayList<>();
            List<Integer> post = new ArrayList<>();
            
            preorder(root, pre);
            postorder(root, post);
        
        for(int i = 0; i<nodeinfo.length; i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        return answer;
}

    void insert(Node parent, Node child){
        if(child.x < parent.x) {
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }
        else {
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
    
    public void preorder(Node node, List<Integer> result){
          if (node == null) return;
        result.add(node.num);
        preorder(node.left, result);
        preorder(node.right, result);
    }
    public void postorder(Node node, List<Integer> result){
          if (node == null) return;
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.num);
    }
}
class Node{
    int x,y;
    int num;
    Node left;
    Node right;

    Node(int x, int y, int num){
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
