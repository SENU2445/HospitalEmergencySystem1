package hospital;

public class BSTNode {

    Patient patient;
    BSTNode left;
    BSTNode right;

    public BSTNode(Patient patient) {
        this.patient = patient;
        left = null;
        right = null;
    }
}