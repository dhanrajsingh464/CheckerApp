import java.util.Scanner;

public class CheckerApp {

    // Node class for singly linked list
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // Linked List Methods
    static Node reverse(Node head) {
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

    static Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static Node stringToLinkedList(String word) {
        Node head = null, tail = null;
        for (int i = 0; i < word.length(); i++) {
            Node newNode = new Node(word.charAt(i));
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

    static boolean isPalindromeLinkedList(Node head) {
        if (head == null || head.next == null) return true;

        Node middle = findMiddle(head);
        Node secondHalf = reverse(middle.next);

        Node p1 = head, p2 = secondHalf;
        boolean palindrome = true;

        while (p2 != null) {
            if (p1.data != p2.data) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the original list
        middle.next = reverse(secondHalf);

        return palindrome;
    }

    // Recursive Method
    static boolean isPalindromeRecursive(String word, int start, int end) {
        if (start >= end) return true;
        if (word.charAt(start) != word.charAt(end)) return false;
        return isPalindromeRecursive(word, start + 1, end - 1);
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Palindrome Checker Application");
        System.out.println("Application Name : Palindrome Checker App");
        System.out.println("Application Version : 1.0");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check for palindrome: ");
        String input = scanner.nextLine();

        // Normalize input
        String word = input.replaceAll("\\s+", "").toLowerCase();

        // Let user choose method
        System.out.println("Choose method:");
        System.out.println("1. Linked List");
        System.out.println("2. Recursive");
        System.out.print("Enter choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.close();

        boolean isPalindrome = false;

        if (choice == 1) {
            Node head = stringToLinkedList(word);
            isPalindrome = isPalindromeLinkedList(head);
        } else if (choice == 2) {
            isPalindrome = isPalindromeRecursive(word, 0, word.length() - 1);
        } else {
            System.out.println("Invalid choice. Defaulting to Linked List method.");
            Node head = stringToLinkedList(word);
            isPalindrome = isPalindromeLinkedList(head);
        }

        if (isPalindrome) {
            System.out.println("The string \"" + input + "\" is a Palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a Palindrome.");
        }
    }

}