package hospital;

public class Treatment {

    private int patientId;
    private String treatmentDate;
    private String doctorName;
    private String treatmentDetails;

    public Treatment(int patientId, String treatmentDate,
                     String doctorName, String treatmentDetails) {

        this.patientId = patientId;
        this.treatmentDate = treatmentDate;
        this.doctorName = doctorName;
        this.treatmentDetails = treatmentDetails;
    }

    public int getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId
                + ", Date: " + treatmentDate
                + ", Doctor: " + doctorName
                + ", Treatment: " + treatmentDetails;
    }
}