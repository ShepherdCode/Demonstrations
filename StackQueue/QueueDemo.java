public class QueueDemo {
    Queue<Cargo> queue;
    public QueueDemo () {
        Factory<Cargo> factory = new Factory<Cargo>();
        this.queue = factory.getQueue();
    }
    public void demoPush(Cargo c) {
        System.out.println(queue);
        this.queue.push(c);
        System.out.println("Push:"+c.toString());
        System.out.println(queue);
        System.out.println();
    }
    public void demoPop() {
        System.out.println(queue);
        Cargo c = this.queue.pop();
        System.out.println("Pop:"+c.toString());
        System.out.println(queue);
        System.out.println();
    }
    
    public static void main (String [] args) {
        QueueDemo demo = new QueueDemo();
        demo.demoPush(new Cargo("apple"));
        demo.demoPush(new Cargo("banana"));
        demo.demoPush(new Cargo("cranberry"));
        demo.demoPop();
        demo.demoPop();
        demo.demoPop();
    }
}
