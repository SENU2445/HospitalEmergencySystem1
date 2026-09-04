package hospital;

public class TreatmentStack {

    private StackNode top;

    public TreatmentStack() {
        top = null;
    }

    // Push
    public void push(Treatment treatment) {

        StackNode newNode = new StackNode(treatment);

        newNode.next = top;
        top = newNode;
    }

    // Pop
    public Treatment pop() {

        if (top == null) {
            return null;
        }

        Treatment treatment = top.treatment;
        top = top.next;

        return treatment;
    }

    // Display Stack
    public void displayStack() {

        if (top == null) {
            System.out.println("Treatment history is empty.");
            return;
        }

        StackNode temp = top;

        while (temp != null) {
            System.out.println(temp.treatment);
            temp = temp.next;
        }
    }

    // Check Empty
    public boolean isEmpty() {
        return top == null;
    }
}