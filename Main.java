import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Shonobi", 100, 200);
        player1.setWeapon("R301");
        System.out.println(player1);
        System.out.println();

        ISaveable Werewolf = new Monster("Werewolf",20,40);
        System.out.println(Werewolf);
    }
    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
    //take the ArrayList of each object saved for stores to the device
    public static void saveObject(ISaveable objectToSave){
        for(int i=0; i<objectToSave.write().size(); i+=i){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device");
        }

    }
    //take the Values saved to the ArrayList for each Object and return
    public static void objectToLoad(ISaveable objectToLoad){
        ArrayList values = readValues();
        objectToLoad.read(values);
    }
}
