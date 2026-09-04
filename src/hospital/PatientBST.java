package hospital;

public class PatientBST {

    private BSTNode root;

    public void insert(Patient patient) {
        root = insertRec(root, patient);
    }

    private BSTNode insertRec(BSTNode root, Patient patient) {

        if (root == null) {
            return new BSTNode(patient);
        }

        if (patient.getPatientId() < root.patient.getPatientId()) {
            root.left = insertRec(root.left, patient);
        } else if (patient.getPatientId() > root.patient.getPatientId()) {
            root.right = insertRec(root.right, patient);
        }

        return root;
    }

    public Patient search(int patientId) {
        BSTNode node = searchRec(root, patientId);

        if (node == null)
            return null;

        return node.patient;
    }

    private BSTNode searchRec(BSTNode root, int patientId) {

        if (root == null)
            return null;

        if (root.patient.getPatientId() == patientId)
            return root;

        if (patientId < root.patient.getPatientId())
            return searchRec(root.left, patientId);

        return searchRec(root.right, patientId);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(BSTNode root) {

        if (root != null) {
            inOrderRec(root.left);
            System.out.println(root.patient);
            inOrderRec(root.right);
        }
    }

    public void delete(int patientId) {
        root = deleteRec(root, patientId);
    }

    private BSTNode deleteRec(BSTNode root, int patientId) {

        if (root == null)
            return null;

        if (patientId < root.patient.getPatientId()) {

            root.left = deleteRec(root.left, patientId);

        } else if (patientId > root.patient.getPatientId()) {

            root.right = deleteRec(root.right, patientId);

        } else {

            if (root.left == null)
                return root.right;

            if (root.right == null)
                return root.left;

            BSTNode minNode = findMin(root.right);

            root.patient = minNode.patient;

            root.right = deleteRec(root.right,
                    minNode.patient.getPatientId());
        }

        return root;
    }

    private BSTNode findMin(BSTNode node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }
}