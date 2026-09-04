package hospital;

public class VisitLinkedList {

    private VisitNode head;

    public void addVisit(Visit visit) {

        VisitNode newNode = new VisitNode(visit);

        if (head == null) {
            head = newNode;
            return;
        }

        VisitNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    public void displayVisits() {

        if (head == null) {
            System.out.println("No visit history.");
            return;
        }

        VisitNode temp = head;

        while (temp != null) {
            System.out.println(temp.visit);
            temp = temp.next;
        }
    }

    public Visit searchVisit(int visitId) {

        VisitNode temp = head;

        while (temp != null) {

            if (temp.visit.getVisitId() == visitId)
                return temp.visit;

            temp = temp.next;
        }

        return null;
    }

    public void removeVisit(int visitId) {

        if (head == null)
            return;

        if (head.visit.getVisitId() == visitId) {
            head = head.next;
            return;
        }

        VisitNode temp = head;

        while (temp.next != null) {

            if (temp.next.visit.getVisitId() == visitId) {
                temp.next = temp.next.next;
                return;
            }

            temp = temp.next;
        }
    }
}