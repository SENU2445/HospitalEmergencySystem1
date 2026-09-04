package hospital;

public class PatientVisitHistory {

    private PatientHistoryNode head;

    public void addPatient(Patient patient) {
        PatientHistoryNode newNode =
                new PatientHistoryNode(patient);

        if (head == null) {
            head = newNode;
            return;
        }

        PatientHistoryNode current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public void displayHistory() {

        if (head == null) {
            System.out.println("Patient history is empty.");
            return;
        }

        PatientHistoryNode current = head;

        while (current != null) {
            System.out.println(current.patient);
            current = current.next;
        }
    }

    public Patient searchPatient(int patientId) {

        PatientHistoryNode current = head;

        while (current != null) {

            if (current.patient.getPatientId() == patientId) {
                return current.patient;
            }

            current = current.next;
        }

        return null;
    }

    public void removePatient(int patientId) {

        if (head == null) {
            return;
        }

        if (head.patient.getPatientId() == patientId) {
            head = head.next;
            return;
        }

        PatientHistoryNode current = head;

        while (current.next != null) {

            if (current.next.patient.getPatientId() == patientId) {
                current.next = current.next.next;
                return;
            }

            current = current.next;
        }
    }
}