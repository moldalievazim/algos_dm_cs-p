class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        // loop through every character of the string
        for (int i = 0; i < s.length(); i++) {
          char ch = s.charAt(i);

          // if character is opening bracket push it to the stack
          if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
          } else {
          // if character is closing bracket, first check the stack if we have opening bracket
            if (stack.isEmpty()) {
              // we don't have an opening bracket, return false
              return false;
            } else {
              // otherwise take the character on the top of the stack and compare to current character
              char top = stack.peek();
              if ((ch == ')' && top == '(') || (ch == ']' && top == '[') || (ch == '}' && top == '{')) {
                 stack.pop();
              } else {
                return false;
              }
            }
          }
        }

        // if the stack is empty at the end it means our brackets are valid.
        return stack.isEmpty();
    }
}