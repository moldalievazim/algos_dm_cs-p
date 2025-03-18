class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, 0, 0, "", n);
        return res;
    }

    public void backtrack(List<String> res, int openN, int closedN, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }

        if (openN < n) backtrack(res, openN + 1, closedN, s + "(", n);

        if (closedN < openN) backtrack(res, openN, closedN + 1, s + ")", n);
    }
}