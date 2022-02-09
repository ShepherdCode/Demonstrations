public class StackDemo {
    Stack<Cargo> stack;
    public StackDemo () {
        Factory<Cargo> factory = new Factory<Cargo>();
        this.stack = factory.getStack();
    }
    public void demoPush(Cargo c) {
        System.out.println(stack);
        this.stack.push(c);
        System.out.println("Push:"+c.toString());
        System.out.println(stack);
        System.out.println();
    }
    public void demoPop() {
        System.out.println(stack);
        Cargo c = this.stack.pop();
        System.out.println("Pop:"+c.toString());
        System.out.println(stack);
        System.out.println();
    }
    
    public static void main (String [] args) {
        StackDemo demo = new StackDemo();
        demo.demoPush(new Cargo("apple"));
        demo.demoPush(new Cargo("banana"));
        demo.demoPush(new Cargo("cranberry"));
        demo.demoPop();
        demo.demoPop();
        demo.demoPop();
    }
}
