import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapping of digits to letters based on telephone buttons
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Handle empty input case
        if (digits == null || digits.length() == 0) {
            return result;
        }

        backtrack(result, digits, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(List<String> result, String digits, StringBuilder current, int index) {
        // Base case: if the current combination length matches the input digits length
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters corresponding to the current digit
        String letters = KEYPAD[digits.charAt(index) - '0'];

        // Iterate through the letters and recurse
        for (char c : letters.toCharArray()) {
            current.append(c);             // Choose
            backtrack(result, digits, current, index + 1); // Explore
            current.deleteCharAt(current.length() - 1);    // Un-choose (backtrack)
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23")); 
        // Output: [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}

