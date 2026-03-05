import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CheckerApp {

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Application");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");

        // Hardcoded string
        String word = "madam";

        // Create a Queue (FIFO) and a Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Enqueue and push characters
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            queue.add(c);  // FIFO
            stack.push(c); // LIFO
        }

        // Compare dequeue vs pop
        boolean isPalindrome = true;
        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (!queue.poll().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Display result
        if (isPalindrome) {
            System.out.println("The string \"" + word + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + word + "\" is not a Palindrome.");
        }

    }

}