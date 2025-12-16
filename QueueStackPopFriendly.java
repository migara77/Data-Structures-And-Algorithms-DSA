import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();

    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly s = new QueueStackPopFriendly();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
