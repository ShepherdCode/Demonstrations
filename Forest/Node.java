public class Node {
    // instance variables - replace the example below with your own
    public Node left, right;
    public String cargo;

    public Node (String cargo)    {
        this.cargo = cargo;
    }

    private String indented (int indent) {
        String dent = "";
        for (int i=0; i<=indent; i++) {
            dent += "  ";
        }
        String show = "";
        show += cargo;
        if (left != null) {
            show += "\n" + dent + left.indented(indent+1);
        }
        if (right != null) {
            show += "\n" + dent + right.indented(indent+1);
        }
        return show;
    }
    
    public String toString ()    {
        return indented(0);
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
        System.out.println(a);
    }
}
