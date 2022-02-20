import java.util.*;

public class TreeDemo {
    private int dfs_order; // preorder, inorder, or postorder
    public void BFS (Node root) {
        // queue factory
        LinkedList<Node> list = new LinkedList<Node>();
        DataStruct<Node> struct = new DataStruct<Node>(list);
        struct.setToQueue();
        Queue<Node> q = struct;
        // tree traversal
        q.push(root);
        while (!q.isEmpty()) {
            Node parent = q.pop(); 
            System.out.print(" "+parent.cargo);
            if (parent.left != null) {
                q.push(parent.left);
            }
            if (parent.right != null) {
                q.push(parent.right);
            }
        }
    }
    public void DFS (Node root) {
        // easiest way to use a stack is recursion
        if (dfs_order < 0) 
            System.out.print(" "+root.cargo);
        if (root.left != null) {
            DFS (root.left);
        }        
        if (dfs_order == 0) 
            System.out.print(" "+root.cargo);
        if (root.right != null) {
            DFS (root.right);
        }
        if (dfs_order > 0) 
            System.out.print(" "+root.cargo);

    }
    public static void main () {
        Node a = new Node ("A");
        Node b = new Node ("B");
        Node c = new Node ("C");
        Node d = new Node ("D");
        Node e = new Node ("E");
        Node f = new Node ("F");
        Node g = new Node ("G");
        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        //
        TreeDemo demo = new TreeDemo();
        System.out.print("\nBFS order    :");
        demo.BFS(a);
        System.out.print("\nDFS preorder :");
        demo.dfs_order = -1;
        demo.DFS(a);
        System.out.print("\nDFS inorder  :");
        demo.dfs_order = 0;
        demo.DFS(a);
        System.out.print("\nDFS postorder:");
        demo.dfs_order = 1;
        demo.DFS(a);
    }
}
