public class CircularDoublyLinkedList {

    private class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head = null;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;
            newNode.next = head;
            newNode.prev = last;
            last.next = newNode;
            head.prev = newNode;
        }
    }

    public void delete(int data) {
        if (head == null) return;

        Node temp = head;
        do {
            if (temp.data == data) {
                if (temp.next == temp) {
                    head = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == head) {
                        head = temp.next;
                    }
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);
    }

    public void display() {
        if (head == null) return;

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.display();
        list.delete(20);
        list.display();
    }
}
