
class MinStack {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> min = new Stack<>();

    public void push(int val) {
        stack.push(val);
        min.push(min.isEmpty() ? val : Math.min(min.peek(), val));
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
