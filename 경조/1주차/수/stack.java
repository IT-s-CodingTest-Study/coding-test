import java.util.*;
public class stack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        List<Integer> stack = new ArrayList<>();

        for(int i=0; i<num; i++){
            String command = in.next();

            switch(command) {
                case "push":
                    int x = in.nextInt();
                    stack.add(x);
                    break;
                case "pop":
                    System.out.println(stack.isEmpty() ? -1 : stack.remove(stack.size() - 1));
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.isEmpty() ? 1 : 0);
                    break;
                case "top":
                    System.out.println(stack.isEmpty() ? -1 : stack.get(stack.size() - 1));
                    break;
            }
        }
        in.close();
    }
}
