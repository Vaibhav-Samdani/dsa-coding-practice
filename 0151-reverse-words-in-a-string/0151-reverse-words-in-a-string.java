class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return String.join(" ", arr);
    }
}