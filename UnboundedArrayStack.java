public class UnboundedArrayStack {

    private int[] arr;
    private int top;
    private int capacity;

    public UnboundedArrayStack() {
        capacity = 2;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int x) {
        if (top == capacity - 1) {
            resize(capacity * 2);
        }
        arr[++top] = x;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }

        int val = arr[top--];

        if (top > 0 && top == capacity / 4) {
            resize(capacity / 2);
        }

        return val;
    }

    private void resize(int newCapacity) {
        int[] newArr = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        UnboundedArrayStack s = new UnboundedArrayStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
