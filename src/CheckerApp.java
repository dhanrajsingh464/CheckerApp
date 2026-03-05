public class CheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Application");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");

        // Hardcoded string
        String word = "madam";

        // Reverse the string
        String reversed = new StringBuilder(word).reverse().toString();

        // Check if the string is palindrome
        if (word.equals(reversed)) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is not a Palindrome.");
        }

    }


}
