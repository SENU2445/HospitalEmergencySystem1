package hospital;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        PatientBST patientBST = new PatientBST();
        EmergencyQueue emergencyQueue = new EmergencyQueue();
        TreatmentStack treatmentStack = new TreatmentStack();
        VisitLinkedList visitList = new VisitLinkedList();
        PatientVisitHistory patientHistory =
                new PatientVisitHistory();

        int choice;

        do {

            System.out.println();
            System.out.println("======================================");
            System.out.println("     HOSPITAL EMERGENCY SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Display Patients (BST In-Order)");
            System.out.println("4. Delete Patient");
            System.out.println("5. Add Patient to Emergency Queue");
            System.out.println("6. Treat Next Emergency Patient");
            System.out.println("7. Display Emergency Queue");
            System.out.println("8. Add Treatment");
            System.out.println("9. View Latest Treatment");
            System.out.println("10. Display Treatment History");
            System.out.println("11. Add Visit");
            System.out.println("12. Search Visit");
            System.out.println("13. Display Visit History");
            System.out.println("14. Remove Visit");
            System.out.println("15. Display Patient History");
            System.out.println("0. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Patient ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Contact Number: ");
                    String contact = scanner.nextLine();

                    System.out.print("Enter Medical Condition: ");
                    String condition = scanner.nextLine();

                    Patient patient = new Patient(
                            id,
                            name,
                            age,
                            contact,
                            condition
                    );

                    patientBST.insert(patient);
                    patientHistory.addPatient(patient);

                    System.out.println(
                            "Patient added successfully."
                    );

                    break;

                case 2:

                    System.out.print("Enter Patient ID to search: ");
                    int searchId = scanner.nextInt();

                    Patient foundPatient =
                            patientBST.search(searchId);

                    if (foundPatient != null) {
                        System.out.println(
                                "Patient Found:"
                        );
                        System.out.println(foundPatient);
                    } else {
                        System.out.println(
                                "Patient not found."
                        );
                    }

                    break;

                case 3:

                    System.out.println();
                    System.out.println(
                            "Patient List - BST In-Order"
                    );

                    patientBST.inOrder();

                    break;

                case 4:

                    System.out.print(
                            "Enter Patient ID to delete: "
                    );

                    int deleteId = scanner.nextInt();

                    Patient patientToDelete =
                            patientBST.search(deleteId);

                    if (patientToDelete != null) {

                        patientBST.delete(deleteId);
                        patientHistory.removePatient(deleteId);

                        System.out.println(
                                "Patient deleted successfully."
                        );

                    } else {

                        System.out.println(
                                "Patient not found."
                        );
                    }

                    break;

                case 5:

                    System.out.print(
                            "Enter Patient ID for emergency queue: "
                    );

                    int queueId = scanner.nextInt();

                    Patient queuePatient =
                            patientBST.search(queueId);

                    if (queuePatient != null) {

                        emergencyQueue.enqueue(queuePatient);

                        System.out.println(
                                "Patient added to emergency queue."
                        );

                    } else {

                        System.out.println(
                                "Patient not found."
                        );
                    }

                    break;

                case 6:

                    Patient nextPatient =
                            emergencyQueue.dequeue();

                    if (nextPatient != null) {

                        System.out.println(
                                "Treating Patient:"
                        );

                        System.out.println(nextPatient);

                    } else {

                        System.out.println(
                                "Emergency queue is empty."
                        );
                    }

                    break;

                case 7:

                    System.out.println();
                    System.out.println(
                            "Emergency Queue"
                    );

                    emergencyQueue.displayQueue();

                    break;

                case 8:

                    System.out.print(
                            "Enter Patient ID: "
                    );

                    int treatmentPatientId =
                            scanner.nextInt();

                    scanner.nextLine();

                    if (patientBST.search(
                            treatmentPatientId) == null) {

                        System.out.println(
                                "Patient not found."
                        );

                        break;
                    }

                    System.out.print(
                            "Enter Treatment Date: "
                    );

                    String date =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Doctor Name: "
                    );

                    String doctor =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Treatment Details: "
                    );

                    String details =
                            scanner.nextLine();

                    Treatment treatment =
                            new Treatment(
                                    treatmentPatientId,
                                    date,
                                    doctor,
                                    details
                            );

                    treatmentStack.push(treatment);

                    System.out.println(
                            "Treatment added successfully."
                    );

                    break;

                case 9:

                    Treatment latestTreatment =
                            treatmentStack.pop();

                    if (latestTreatment != null) {

                        System.out.println(
                                "Latest Treatment:"
                        );

                        System.out.println(
                                latestTreatment
                        );

                    } else {

                        System.out.println(
                                "Treatment history is empty."
                        );
                    }

                    break;

                case 10:

                    System.out.println();
                    System.out.println(
                            "Treatment History"
                    );

                    treatmentStack.displayStack();

                    break;

                case 11:

                    System.out.print(
                            "Enter Visit ID: "
                    );

                    int visitId =
                            scanner.nextInt();

                    scanner.nextLine();

                    System.out.print(
                            "Enter Visit Date: "
                    );

                    String visitDate =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Doctor Name: "
                    );

                    String visitDoctor =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Diagnosis: "
                    );

                    String diagnosis =
                            scanner.nextLine();

                    System.out.print(
                            "Enter Treatment: "
                    );

                    String visitTreatment =
                            scanner.nextLine();

                    Visit visit =
                            new Visit(
                                    visitId,
                                    visitDate,
                                    visitDoctor,
                                    diagnosis,
                                    visitTreatment
                            );

                    visitList.addVisit(visit);

                    System.out.println(
                            "Visit added successfully."
                    );

                    break;

                case 12:

                    System.out.print(
                            "Enter Visit ID to search: "
                    );

                    int searchVisitId =
                            scanner.nextInt();

                    Visit foundVisit =
                            visitList.searchVisit(
                                    searchVisitId
                            );

                    if (foundVisit != null) {

                        System.out.println(
                                "Visit Found:"
                        );

                        System.out.println(foundVisit);

                    } else {

                        System.out.println(
                                "Visit not found."
                        );
                    }

                    break;

                case 13:

                    System.out.println();
                    System.out.println(
                            "Patient Visit History"
                    );

                    visitList.displayVisits();

                    break;

                case 14:

                    System.out.print(
                            "Enter Visit ID to remove: "
                    );

                    int removeVisitId =
                            scanner.nextInt();

                    visitList.removeVisit(
                            removeVisitId
                    );

                    System.out.println(
                            "Visit removal completed."
                    );

                    break;

                case 15:

                    System.out.println();
                    System.out.println(
                            "Patient History"
                    );

                    patientHistory.displayHistory();

                    break;

                case 0:

                    System.out.println();
                    System.out.println(
                            "Thank you for using Hospital Emergency System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }
}