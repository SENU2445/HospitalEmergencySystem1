package hospital;

public class PatientHistoryNode {

    Patient patient;
    PatientHistoryNode next;

    public PatientHistoryNode(Patient patient) {
        this.patient = patient;
        this.next = null;
    }
}