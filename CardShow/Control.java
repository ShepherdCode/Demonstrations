/**
 * Control the CardView program.
 * 
 * To start a new game,
 * invoke main() with or without parameters.
 */
public class Control {
    Model model;
    View view;

    public Control () {
        model = new Model ();
        view = new View (this); 
    }

    public void go () {
        dealCard();
        view.go();
    }

    public void dealCard () {
        model.dealCard();
        view.changeStatus(model.getStatus());
        System.out.println(model.getStatus());
    }

    public void returnCard () {
        model.returnCard();
        view.changeStatus(model.getStatus());
        System.out.println(model.getStatus());
    }

    public static void main () {
        main(null);
    }

    public static void main (String[] args) {
        Control control = new Control();
        control.go();
    }
}
