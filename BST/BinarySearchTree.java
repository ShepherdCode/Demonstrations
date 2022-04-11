import java.util.Arrays;
public class BinarySearchTree {
    BinarySearchTree parent;
    BinarySearchTree left,right;
    Comparable key;
    Object cargo;
    public BinarySearchTree(Comparable key,Object cargo)    {
        this.key=key;
        this.cargo=cargo;
        left=null;
        right=null;
    }

    public Comparable getKey() {
        return key;
    }

    public Object getValue() {
        return cargo;
    }
    
    public void recursiveAdd (Comparable newKey, Object newVal) {
        int cmp = newKey.compareTo(this.key);
        if (cmp<0) {
            if (left==null) {
                left=new BinarySearchTree(newKey,newVal);
                left.parent=this;
            } else {
                left.recursiveAdd(newKey,newVal);
            }
        } else {
            if (right==null) {
                right=new BinarySearchTree(newKey,newVal);
                right.parent=this;
            } else {
                right.recursiveAdd(newKey,newVal);
            }
        }
    }

    public String toParens() {
        String disp = String.format( " %s(" , key);
        if (left==null) {
            disp += "null,";
        } else {
            disp += String.format( "%s,", left.toParens() );
        }
        if (right==null) {
            disp += "null)";
        } else {
            disp += String.format( "%s)", right.toParens() );
        }
        return disp;
    }

    public String showPath (Comparable searchKey) {
        String show = String.format("%s ",this.key);
        int cmp = searchKey.compareTo(this.key);
        if (cmp<0) {
            if (left==null) {
                show += "null";
            } else {
                show += left.showPath(searchKey);
            }
        } else if (cmp>0) {
            if (right==null) {
                show += "null";
            } else {
                show += right.showPath(searchKey);
            }
        } else show += "found!";
        return show;
    }

    public static void main () {
        String root = "DATA";
        String missing = "ZOO";
        Object cargo = null;  // just use same cargo everywhere
        BinarySearchTree tree = new BinarySearchTree(root,cargo);
        String [] keys = {"ART","MATH","ACCT","CIS","HIST","PHYS"};
        // Setup
        System.out.println("This demo will load "+root+" and");
        System.out.println(Arrays.deepToString(keys));
        // Load and Draw
        System.out.println("BST add one at a time");
        for (String key : keys) {
            System.out.println(tree.toParens());
            tree.recursiveAdd(key,cargo);
        }
        System.out.println(tree.toParens());
        // Search
        System.out.print("Search for "+root+": ");
        System.out.println(tree.showPath(root));
        for (String key : keys) {
            System.out.print("Search for "+key+": ");
            System.out.println(tree.showPath(key));
        }
        System.out.print("Search for "+missing+": ");
        System.out.println(tree.showPath(missing));
    }
}
