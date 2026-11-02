class Solution {
    public boolean isPalindrome(String s) {

        String result  = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        char[] characters = result.toCharArray();

        int start = 0;
        int end = characters.length - 1;

        while (start < end) {
            char temp = characters[start];
            characters[start] = characters[end];
            characters[end] = temp;
            start++;
            end--;
        }

        String afterReverse = String.valueOf(characters);

        if (result.equals(afterReverse)) {
            return true;
        }

        return false;
        
    }
}
