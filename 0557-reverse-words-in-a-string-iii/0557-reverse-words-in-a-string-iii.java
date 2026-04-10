public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            result.append(new StringBuilder(words[i]).reverse());
            if (i < words.length - 1) {
                result.append(" ");
            }}
        return result.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("Let's take LeetCode contest")); 
        System.out.println(sol.reverseWords("Mr Ding"));        }}            
        