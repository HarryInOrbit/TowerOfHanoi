import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TowerOfHanoiCustom {
    public static void main(String[] args) {
        start();
    }

    private static void start() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of disks: ");
        int disks = scan.nextInt();

        System.out.println("Enter the number of rods: ");
        int rods = scan.nextInt();
        scan.close();

        if (rods < 3) {
            System.out.println("You need at least 3 rods to play Tower of Hanoi.");
            return;
        }

        List<Character> rodNames = new ArrayList<>();
        for (char rod = 'A'; rod < 'A' + rods; rod++) {
            rodNames.add(rod);
        }

        System.out.println("Solving with " + disks + " disks and " + rods + " rods.");
        towerOfHanoi(disks, rodNames, 0, rods - 1);
    }

    private static void towerOfHanoi(int disks, List<Character> rodNames,
                                     int fromRod, int toRod) {
        if (disks == 0) {
            return;
        }

        int auxRod = findAuxiliaryRod(fromRod, toRod, rodNames.size());

        towerOfHanoi(disks - 1, rodNames, fromRod, auxRod);

        System.out.println("Move disk " + disks + " from rod " + rodNames.get(fromRod) +
                " to rod " + rodNames.get(toRod));

        towerOfHanoi(disks - 1, rodNames, auxRod, toRod);
    }

    private static int findAuxiliaryRod(int fromRod, int toRod, int numRods) {
        for (int i = 0; i < numRods; i++) {
            if (i != fromRod && i != toRod) {
                return i;
            }
        }
        return -1; // Should never reach here if numRods >= 3
    }
}
