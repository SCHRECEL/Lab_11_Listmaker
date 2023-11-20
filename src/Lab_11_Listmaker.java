import java.util.ArrayList;
import java.util.Scanner;

public class Lab_11_Listmaker {

    private static ArrayList<String> itemList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char choice;

        do {
            System.out.println("Menu:");
            System.out.println("A - Add item");
            System.out.println("D - Delete item");
            System.out.println("P - Print list");
            System.out.println("Q - Quit");

            choice = SafeInput.getRegExString(scanner, "Enter choice (A/D/P/Q): ", "[AaDdPpQq]").toUpperCase().charAt(0);

            if (choice == 'A') {
                String newItem = SafeInput.getNonZeroLenString(scanner, "Enter item to add: ");
                itemList.add(newItem);
                System.out.println("Item added.");
            } else if (choice == 'D') {
                if (!itemList.isEmpty()) {
                    displayNumberedItemList();

                    int index = SafeInput.getRangedInt(scanner, "Enter item number to delete: ", 1, itemList.size());
                    itemList.remove(index - 1);
                    System.out.println("Item deleted.");
                } else {
                    System.out.println("Nothing to delete.");
                }
            } else if (choice == 'P') {
                displayList();
            } else if (choice == 'Q') {
                if (confirmQuit()) {
                    System.out.println("Exiting program.");
                    System.exit(0);
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 'Q');
    }

    private static void displayList() {
        if (!itemList.isEmpty()) {
            System.out.println("Numbered list:");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    private static void displayNumberedItemList() {
        if (!itemList.isEmpty()) {
            System.out.println("Numbered list:");
            for (int i = 0; i < itemList.size(); i++) {
                System.out.println((i + 1) + ". " + itemList.get(i));
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    private static boolean confirmQuit() {
        return SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
    }
}
