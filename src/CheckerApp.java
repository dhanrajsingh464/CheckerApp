public class CheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Application");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");

        // Hardcoded string
        String word = "madam";

        // Convert string to character array
        char[] chars = word.toCharArray();

        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        // Two-pointer technique
        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is not a Palindrome.");
        }

    }

}
