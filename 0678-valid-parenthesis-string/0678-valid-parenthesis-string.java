class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> left_indices = new Stack<>();
        Stack<Integer> asterisk_indices = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left_indices.push(i);
            } else if (c == '*') {
                asterisk_indices.push(i);
            } else {
                if (!left_indices.isEmpty()) {
                    left_indices.pop();
                } else if (!asterisk_indices.isEmpty()) {
                    asterisk_indices.pop();
                } else {
                    return false;
                }
            }
        }
        while (!left_indices.isEmpty()) {
            if (!asterisk_indices.isEmpty() &&
                left_indices.peek() < asterisk_indices.peek()) {
                left_indices.pop();
                asterisk_indices.pop();
            } else {
                return false;
            }
        }
        return true;
    }
}