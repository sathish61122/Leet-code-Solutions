import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    /**
     * @param result  The final list to store valid combinations
     * @param current The current string being built
     * @param open    The number of open parentheses used
     * @param close   The number of close parentheses used
     * @param max     The total pairs required (n)
     */
    private void backtrack(List<String> result, StringBuilder current, int open, int close, int max) {
        // Base case: If the current string length reaches 2 * n, it's a complete combination
        if (current.length() == max * 2) {
            result.add(current.toString());
            return;
        }

        // Rule 1: We can always add an opening parenthesis if we haven't reached the limit 'n'
        if (open < max) {
            current.append("(");
            backtrack(result, current, open + 1, close, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }

        // Rule 2: We can only add a closing parenthesis if there are more open ones than closed ones
        if (close < open) {
            current.append(")");
            backtrack(result, current, open, close + 1, max);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
