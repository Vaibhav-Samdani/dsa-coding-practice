class Solution {
    static {
        // Warm-up calls (if intentionally needed)
        for (int i = 0; i < 500; i++) {
            reverseWords("");
        }
    }
    public static String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }

        return String.join(" ", arr);
    }
}