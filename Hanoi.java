//Name: Huy Truong Ngo
// CS 145
// Tower of Hanoi
// This program will solve the game of tower of hanoi which works on custom amount of rods
import java.util.Scanner;

public class Hanoi {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of disk: ");
        int disk = scan.nextInt();
        towerOfHanoi(disk, "A", "C", "B");
    }

    // Number of disk, origin rod, destination rod, remainding rod
    public static void towerOfHanoi(int disk, String from, String to, String remain) {
        if (disk == 1) {
            System.out.printf("\nMove disk %d from rod %s to rod %s", disk, from, to);
            return;
        }
        towerOfHanoi(disk - 1, from, remain, to);
        System.out.printf("\nMove disk %d from rod %s to rod %s", disk, from, to);
        towerOfHanoi(disk - 1, remain, to, from);

    }
}