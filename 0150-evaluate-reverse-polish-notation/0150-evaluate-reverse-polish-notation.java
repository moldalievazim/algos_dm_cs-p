class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<Integer>();
    int a, b; // for adding and multiplying order of integers from stack doesn't matter, but for division and subtracting order matters, that's why we need these two int a, int b variables;
    
    for (String s : tokens) {
      if (s.equals("+")) { 
        stack.push(stack.pop() + stack.pop());
      } else if (s.equals("/")) {
        b = stack.pop();
        a = stack.pop(); 
        stack.push(a / b);
      } else if (s.equals("*")) {
        stack.push(stack.pop() * stack.pop());
      } else if (s.equals("-")) {
        b = stack.pop();
        a = stack.pop(); 
        stack.push(a - b);
      } else {
        stack.push(Integer.parseInt(s));
      }
    }

    return stack.pop();
  }
}