class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        combiner(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }

    private static void combiner(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
        if (k == 0) {
            combs.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= n; i++) {
            comb.add(i);
            combiner(combs, comb, i + 1, n, k - 1);
            comb.remove(comb.size() - 1);
        }
    }
}