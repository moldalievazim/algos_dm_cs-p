class MyQueue {
    private Stack<Integer> input;
    private Stack<Integer> output;

    public MyQueue() {
        input = new Stack();
        output = new Stack();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        int x = peek();
        output.pop();
        return x;
    }
    
    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek();
    }
    
    public boolean empty() {
        return input.empty() && output.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */