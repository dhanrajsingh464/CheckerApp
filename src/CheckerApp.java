import java.util.Scanner;

public class CheckerApp {

    // PalindromeChecker class encapsulates all palindrome logic
    static class PalindromeChecker {

        // Node class for singly linked list
        static class Node {
            char data;
            Node next;

            Node(char data) {
                this.data = data;
                this.next = null;
            }
        }

        // --- Linked List Palindrome ---
        private Node stringToLinkedList(String word) {
            Node head = null, tail = null;
            for (char c : word.toCharArray()) {
                Node newNode = new Node(c);
                if (head == null) {
                    head = newNode;
                    tail = newNode;
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
            }
            return head;
        }

        private Node reverseLinkedList(Node head) {
            Node prev = null;
            Node current = head;
            while (current != null) {
                Node nextNode = current.next;
                current.next = prev;
                prev = current;
                current = nextNode;
            }
            return prev;
        }

        private Node findMiddle(Node head) {
            Node slow = head, fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public boolean checkLinkedListPalindrome(String word) {
            Node head = stringToLinkedList(word);
            if (head == null || head.next == null) return true;

            Node middle = findMiddle(head);
            Node secondHalf = reverseLinkedList(middle.next);

            Node p1 = head, p2 = secondHalf;
            boolean isPalindrome = true;

            while (p2 != null) {
                if (p1.data != p2.data) {
                    isPalindrome = false;
                    break;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // Restore original list
            middle.next = reverseLinkedList(secondHalf);
            return isPalindrome;
        }

        // --- Recursive Palindrome ---
        public boolean checkRecursivePalindrome(String word, int start, int end) {
            if (start >= end) return true;
            if (word.charAt(start) != word.charAt(end)) return false;
            return checkRecursivePalindrome(word, start + 1, end - 1);
        }

        // --- Unified method with normalization ---
        public boolean checkPalindrome(String input, int method) {
            // Normalize: remove spaces & punctuation, convert to lowercase
            String normalized = input.replaceAll("[\\W_]+", "").toLowerCase();

            switch (method) {
                case 1: return checkLinkedListPalindrome(normalized);
                case 2: return checkRecursivePalindrome(normalized, 0, normalized.length() - 1);
                default: return checkLinkedListPalindrome(normalized);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Palindrome Checker Application");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string to check for palindrome: ");
            String input = scanner.nextLine();

            System.out.println("Choose method to check palindrome:");
            System.out.println("1. Linked List");
            System.out.println("2. Recursive");

            int choice = 1; // default
            if (scanner.hasNextInt()) {
                int temp = scanner.nextInt();
                if (temp == 1 || temp == 2) {
                    choice = temp;
                } else {
                    System.out.println("Invalid choice. Defaulting to Linked List method.");
                }
            } else {
                System.out.println("Invalid input. Defaulting to Linked List method.");
            }

            // Check palindrome
            PalindromeChecker checker = new PalindromeChecker();
            boolean isPalindrome = checker.checkPalindrome(input, choice);

            if (isPalindrome) {
                System.out.println("The string \"" + input + "\" is a Palindrome (ignoring spaces, punctuation & case).");
            } else {
                System.out.println("The string \"" + input + "\" is not a Palindrome (ignoring spaces, punctuation & case).");
            }
        }
    }
}