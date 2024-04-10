import java.util.Scanner;

public class Main {
    static class Node {
        //Declares the data and represents
        // the node in the linked list
        int data;
        Node next;
        //Constructor to initialize the node with
        //data
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //SinglyLinkedClass to represent the singly linked list
    static class SinglyLinkedList {
        Node head;

        //Method to insert a new node with the data
        //at the end of the list
        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();

        //New instances of SinglyLinkedList
        //for prime numbers and prime numbers with
        //the digit 3.
        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primeWithThreeList = new SinglyLinkedList();

        //Generating the prime numbers up to
        //n and filling the list.
        for (int i = 2; i <= n; i++) {
            //Checking if the number is prime number
            if (isPrime(i)) {
                primeList.insert(i);

                //checking if the prime have the digit 3
                //putting the said prime into the list
                if (digitThree(i)) {
                    primeWithThreeList.insert(i);
                }
            }
        }

        //Calculating the sum with that contains
        //any prime numbers with the digit 3
        int sum = 0;
        Node temp = primeWithThreeList.head;
        while (temp != null) {
            sum += temp.data;
            temp = temp.next;
        }
        //Printing the sum
        System.out.println("Sum of prime numbers with digit 3 between 0 and " + n + ": " + sum);
    }
    //Method to check if number is prime that being used in the
    //main class.
    static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
    //Method to check if number is prime with
    // the digit 3 that being used in the
    //main class.
    static boolean digitThree(int num) {
        while (num > 0) {
            if (num % 10 == 3) {
                return true;
            }
            num /= 10;
        }
        return false;
    }
}