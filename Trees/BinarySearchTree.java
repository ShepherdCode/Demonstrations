public class BinarySearchTree {
    BinarySearchTree parent;
    BinarySearchTree [] children;
    Comparable key;
    public BinarySearchTree(Comparable key)    {
        this.key=key;
        children = new BinarySearchTree [2]; 
    }

    public Comparable getKey() {
        return key;
    }

    private void setParent (BinarySearchTree node) {
        this.parent = node;
    }

    public BinarySearchTree getParent ()    {
        return parent;
    }

    public BinarySearchTree getLeft ()    {
        return children[0];
    }

    public BinarySearchTree getRight ()    {
        return children[1];
    }

    public void add (Comparable newKey) {
        int cmp = newKey.compareTo(this.key);
        if (cmp<0) {
            if (children[0]==null) {
                children[0]=new BinarySearchTree(newKey);
                children[0].setParent(this);
            } else {
                children[0].add(newKey);
            }
        } else {
            if (children[1]==null) {
                children[1]=new BinarySearchTree(newKey);
                children[1].setParent(this);
            } else {
                children[1].add(newKey);
            }
        }
    }

    public String toParens() {
        String disp = String.format( "%s(" , key);
        if (getLeft()==null) {
            disp += ",";
        } else {
            disp += String.format( "%s,", getLeft().toParens() );
        }
        if (getRight()==null) {
            disp += ")";
        } else {
            disp += String.format( "%s)", getRight().toParens() );
        }
        return disp;
    }

    public String showPath (Comparable searchKey) {
        String s = String.format("%s ",this.key);
        int cmp = searchKey.compareTo(this.key);
        if (cmp<0) {
            if (getLeft()==null) {
                s += "null";
            } else {
                s += getLeft().showPath(searchKey);
            }
        } else if (cmp>0) {
            if (getRight()==null) {
                s += "null";
            } else {
                s += getRight().showPath(searchKey);
            }
        }
        return s;
    }

    public int measurePath (Comparable searchKey) {
        int cmp = searchKey.compareTo(this.key);
        if (cmp<0 && getLeft()!=null) {
            return 1 + getLeft().measurePath(searchKey);
        } else if (cmp>0 && getRight()!=null) {
            return 1 + getRight().measurePath(searchKey);
        }
        return 0;
    }

    public static void main () {
        // Load
        String root = "DATA";
        String missing = "ZOO";
        BinarySearchTree tree = new BinarySearchTree(root);
        String [] children = {"ART","MATH","ACCT","CIS","HIST","PHYS"};
        for (String s : children) {
            tree.add(s);
        }
        // Draw
        System.out.println("Parentheses Tree Representation");
        System.out.println(tree.toParens());
        for (String s : children) {
            System.out.print("Search for "+s+"... ");
            System.out.println(tree.showPath(s));
        }
        System.out.print("Search for "+missing+"... ");
        System.out.println(tree.showPath(missing));
        // Measure
        System.out.print("Measure "+root+": ");
        System.out.println(tree.measurePath(root));
        for (String s : children) {
            System.out.print("Measure "+s+": ");
            System.out.println(tree.measurePath(s));
        }
        System.out.print("Measure "+missing+": ");
        System.out.println(tree.measurePath(missing));
    }
}
