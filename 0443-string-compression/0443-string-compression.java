class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int streakStart = 0;
        int indexAnswer = 0;
        
        while (streakStart < n) {
            char streakChar = chars[streakStart];
            int streakEnd = streakStart;
            int count = 1;

            while (streakEnd + 1 < n && chars[streakEnd + 1] == streakChar) {
                streakEnd++;
                count++;
            }

            chars[indexAnswer++] = streakChar;

            if (count != 1) {
                char[] countAsChars = Integer.toString(count).toCharArray();
                for (char digit : countAsChars) {
                    chars[indexAnswer++] = digit;
                }
            }

            streakStart = streakEnd + 1;
        }

        return indexAnswer;
    }
}