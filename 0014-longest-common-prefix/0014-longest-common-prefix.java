class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is null or empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start by assuming the first string is the common prefix
        String prefix = strs[0];

        // Iterate through the rest of the strings in the array
        for (int i = 1; i < strs.length; i++) {
            // While the current string (strs[i]) does not start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
