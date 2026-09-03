package hospital;

public class StackNode {

    Treatment treatment;
    StackNode next;

    public StackNode(Treatment treatment) {
        this.treatment = treatment;
        this.next = null;
    }
}