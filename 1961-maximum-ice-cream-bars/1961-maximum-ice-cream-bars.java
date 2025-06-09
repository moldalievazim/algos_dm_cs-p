class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = costs[0];
        for(int c : costs) {
            max = Math.max(max, c);
        }
        int[] count = new int[max+1];

        for(int c : costs) {
            count[c]++;
        }

        int idx = 0;
        for(int i = 0; i < count.length; i++) {
            while(count[i] > 0){
                costs[idx++] = i;
                count[i]--;
            }
        }


        int iceCream = 0;
        while(iceCream < costs.length && costs[iceCream] <= coins) {
            coins -= costs[iceCream++];
        }
        return iceCream;
    }
}