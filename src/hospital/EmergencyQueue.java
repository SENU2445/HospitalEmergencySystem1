package hospital;

public class EmergencyQueue {

    private QueueNode front;
    private QueueNode rear;

    public EmergencyQueue() {
        front = null;
        rear = null;
    }

    // Enqueue
    public void enqueue(Patient patient) {

        QueueNode newNode = new QueueNode(patient);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    public Patient dequeue() {

        if (front == null) {
            return null;
        }

        Patient patient = front.patient;
        front = front.next;

        if (front == null) {
            rear = null;
        }

        return patient;
    }

    // Display Queue
    public void displayQueue() {

        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        QueueNode temp = front;

        while (temp != null) {
            System.out.println(temp.patient);
            temp = temp.next;
        }
    }

    // Check Empty
    public boolean isEmpty() {
        return front == null;
    }
}