class Solution {
    /**
     * Decodes a string encoded with the rule k[encoded_string].
     *
     * @param s The encoded string.
     * @return The decoded string.
     */
    public String decodeString(String s) {
        // Stack to store the repetition counts (k values)
        Stack<Integer> countStack = new Stack<>();
        // Stack to store the string built *before* encountering a '['
        Stack<StringBuilder> stringStack = new Stack<>();
        // StringBuilder to construct the current segment of the decoded string
        StringBuilder currentString = new StringBuilder();
        // Variable to accumulate the current repetition count (can be multi-digit)
        int k = 0;
 
        // Iterate through each character of the input string
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Build the repetition count k (handles multi-digit numbers)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // --- Entering a new encoded segment ---
 
                // 1. Push the current repetition count onto the count stack.
                //    This is the 'k' for the segment we are about to process.
                countStack.push(k);
 
                // 2. Push the current state of the string builder onto the string stack.
                //    This saves the string built *before* this new segment.
                stringStack.push(currentString);
 
                // 3. Reset k for the next potential number inside the brackets.
                k = 0;
 
                // 4. Reset currentString to start building the string *inside* the brackets.
                currentString = new StringBuilder();
 
            } else if (ch == ']') {
                // --- Exiting an encoded segment ---
 
                // 1. Pop the repetition count for the segment just finished.
                int repeatCount = countStack.pop();
 
                // 2. Pop the string builder that stored the string *before* this segment.
                StringBuilder whereILeftOff = stringStack.pop();
 
                // 3. The 'currentString' now holds the decoded content *inside* the brackets.
                //    Repeat this content 'repeatCount' times.
                for (int i = 0; i < repeatCount; i++) {
                    whereILeftOff.append(currentString);
                }
 
                // 4. Update currentString to be the result of the concatenation.
                //    This effectively brings the decoded segment back into the outer context.
                currentString = whereILeftOff;
 
            } else {
                // Character is a letter
                // Append the letter to the current string being built.
                currentString.append(ch);
            }
        }
 
        // After iterating through the entire string, currentString holds the final result.
        return currentString.toString();
    }
}
 
// String s <==> "423"
// int k = 0;
// for (int i = 0; i < s.length(); i++) {
//   k = k * 10 + (s.charAt(i) - '0');
// }
// System.out.println(k); // 423
// k = 0 * 10 + 4 = 4
// k = 4 * 10 + 2 = 42
// k = 42 * 10 + 3 = 423
 
/*
 
Stack<Integer> stackNumbers
Stack<StringBuilder> stackStrings
 
1. the character is a digit (think "...239[...")
  -> stop and start processing a number until a '['
    -> k = 0
    -> ...k = k * 10 + (digit - '0'), do it one-by-one to parse the number...
    -> k = 239
  -> stackNumbers.push(k)
 
2. the character is a '['
  -> stackStrings.push(currentString);
  -> currentString = new StringBuilder();
 
3. the character is a ']'
  -> int repeatCount = stackNumbers.pop();
  -> String repeatedCurrentString = ... // in a for loop, append current string repeatCount times to a new StringBuilder and form it into a String;
  -> StringBuilder whereILeftOff = stackStrings.pop();
  -> whereILeftOff.appendAll(repeatedCurrentString);
  -> currentString = whereILeftOff;
 
4. the character is a letter
  -> currentString.append(ch);
 
*/