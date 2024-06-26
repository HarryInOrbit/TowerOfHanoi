import java.util.Scanner;

public class RecursiveTowerOfHanoi {
    public static void main(String[] args) {
        int n = disks(); // Number of disks
        towerOfHanoi(n, 'A', 'C', 'B'); // A, B and C are rod names
    }

    public static void towerOfHanoi(int n, char from_rod, char to_rod, char aux_rod) {
        if (n == 1) {
            System.out.println("Move disk 1 from rod " + from_rod + " to rod " + to_rod);
            return;
        }

        towerOfHanoi(n - 1, from_rod, aux_rod, to_rod);
        System.out.println("Move disk " + n + " from rod " + from_rod + " to rod " + to_rod);
        towerOfHanoi(n - 1, aux_rod, to_rod, from_rod);
    }

    private static int disks() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int n = userInput.nextInt();
        userInput.close();
        return n;
    }
}