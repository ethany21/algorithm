import java.util.Queue;
import java.util.LinkedList;

class LeetCode559 {

    public static int depth;

    public int maxDepth(Node root) {

        if (root == null){return 0;}

        depth = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            int size = que.size();
            for (int i = 0; i < size; i++){
                Node current = que.poll();

                if(current.children.isEmpty()){
                    continue;
                } else{
                    int num = current.children.size();
                    for (int j = 0; j < num; j++){
                        que.offer(current.children.get(j));
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
/**

 Runtime: 1 ms, Memory Usage: 39.5 MB
 Runtime beats 40.21% of java submissions;
 Memory usage beats 16.05% of java submissions;

 **/