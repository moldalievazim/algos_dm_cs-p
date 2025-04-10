class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        for (int x : asteroids) {
          if (x > 0) {
            stack.push(x);
          } else {
            if (stack.isEmpty()){
              result.add(x);
            } else {
              while (!stack.isEmpty()) {
                int top = stack.peek();
                if (Math.abs(x) > top) {
                  stack.pop();
                  if (stack.isEmpty()) {
                    result.add(x);
                  }
                } else if (Math.abs(x) == top) {
                  stack.pop();
                  break;
                } else {
                  break;
                }
              }
            }
          }
        }

        int answerSize = result.size() + stack.size();
        int[] answer = new int[answerSize];
        for (int i = 0; i < result.size(); i++) {
          answer[i] = result.get(i);
        }
        int index = answerSize - 1;
        while (!stack.isEmpty()) {
          answer[index] = stack.pop();
          index--;
        }
        return answer;
    }
}