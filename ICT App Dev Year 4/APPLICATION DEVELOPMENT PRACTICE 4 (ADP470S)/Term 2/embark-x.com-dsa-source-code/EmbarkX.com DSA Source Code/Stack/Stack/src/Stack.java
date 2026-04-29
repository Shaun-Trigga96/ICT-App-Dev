public class Stack {

    private int[] stack;
    private int size;
    private int top;

    public Stack(int size) {
        this.size = size;
        stack = new int[this.size];
        top = -1;
    }

    public boolean push(int data) {
        if(top == size - 1) {
            return false;
        }
        else {
            stack[++top] = data;
            return true;
        }
    }

    public int pop() {
        if(top < 0) {
            return 0;
        }
        else {
            int ret = stack[top--];
            return ret;
        }
    }

    public int peek() {
        if(top < 0) {
            return 0;
        }
        else {
            int ret = stack[top];
            return ret;
        }
    }

    public Boolean isEmpty() {
        return top < 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        System.out.println("IS STACK EMPTY: " + stack.isEmpty());
        System.out.println("PUSH: " + stack.push(32));
        System.out.println("IS STACK EMPTY: " + stack.isEmpty());
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(64));
        System.out.println("POP: " + stack.pop());
        System.out.println("PEEK: " + stack.peek());
        System.out.println("POP: " + stack.pop());
        System.out.println("POP: " + stack.pop());
        System.out.println("IS STACK EMPTY: " + stack.isEmpty());
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(12));
        System.out.println("PUSH: " + stack.push(12));
    }
}