import java.util.Arrays;
public class BinarySearchTree {
    
    BinarySearchTree left,right;
    Comparable key;
    Object value;
    
    public BinarySearchTree(Comparable key, Object value)    {
        this.key=key;
        this.value=value;
        left=null;
        right=null;
    }

    public void recursiveAdd (Comparable newKey, Object newVal) {
        int cmp = newKey.compareTo(this.key);
        if (cmp<0) {
            if (left==null) {
                left=new BinarySearchTree(newKey,newVal);
            } else {
                left.recursiveAdd(newKey,newVal);
            }
        } else if (cmp>0) {
            if (right==null) {
                right=new BinarySearchTree(newKey,newVal);
            } else {
                right.recursiveAdd(newKey,newVal);
            }
        } else {
            value = newVal; // same key? overwrite value
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
                show += "not found";
            } else {
                show += left.showPath(searchKey);
            }
        } else if (cmp>0) {
            if (right==null) {
                show += "key not found";
            } else {
                show += right.showPath(searchKey);
            }
        } else show += "found, value="+value;
        return show;
    }

    public static void main () {
        // Setup
        String root = "DATA";
        Object cargo = null;  // just use same cargo everywhere
        BinarySearchTree tree = new BinarySearchTree(root,cargo);
        String [] keys = {"ART","MATH","ACCT","CIS","HIST","PHYS"};
        System.out.println("This demo will load keys "+root+" and");
        System.out.println(Arrays.deepToString(keys));
        System.out.println("All values are null just because we're lazy.");
        // Load and Draw
        System.out.println("BST add one at a time");
        for (String key : keys) {
            System.out.println(tree.toParens());
            tree.recursiveAdd(key,cargo);
        }
        System.out.println(tree.toParens());
        // Search
        System.out.println("Ok, let's search the tree.");
        System.out.print("Search for key "+root+": ");
        System.out.println(tree.showPath(root));
        for (String key : keys) {
            System.out.print("Search for key "+key+": ");
            System.out.println(tree.showPath(key));
        }
        // Worst case
        String missing = "ZOO";
        System.out.print("Search for key "+missing+": ");
        System.out.println(tree.showPath(missing));
    }
}
