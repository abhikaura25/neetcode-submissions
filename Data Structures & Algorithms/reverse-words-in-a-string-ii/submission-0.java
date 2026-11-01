class Solution {
    public void reverseWords(char[] s) {

        String input = String.valueOf(s);

        String[] inputArray = input.split("\\s+");

        int start = 0;
        int end = inputArray.length - 1;

        while (start < end) {
            String temp = inputArray[start];
            inputArray[start] = inputArray[end];
            inputArray[end] = temp;

            start++;
            end--;
        }

        String result = String.join(" ", inputArray);

        for (int k=0; k < s.length; k++) {
            s[k] = result.charAt(k);
        }
    }
}
