import java.io.IOException;
import java.util.Random;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BubbleSort { 

    public static void printArray(int[] array) {
        for (int a: array) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static int[] createRandomArray(int arrayLength) {
        int[]array = new int[arrayLength];
        Random random = new Random();
        for (int i=0; i < arrayLength; i++) {
            array[i]=random.nextInt(100);
        }
        return array;
    }

    public static void writeArrayToFile(int[] array, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            for(int a: array) {
                fileWriter.write(a+ "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("Encounter an IOException");
            e.printStackTrace();
        }
    }

    public static int[] readArrayFromFile(String fileName) {
        File file = new File(fileName);
        try {
        Scanner scanner = new Scanner(file);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(scanner.hasNextLine()) {
                String str = scanner.nextLine();
                int a = Integer.parseInt(str);
                arrayList.add(a);
        }
        int[] array = new int[arrayList.size()];
        for (int i=0; i< arrayList.size(); i++) {
            array[i]=(int) arrayList.get(i);
        }
        scanner.close();
        return array;
    } catch(FileNotFoundException e) {
        e.printStackTrace();
    }
    return null;
    }

    public static void bubbleSort(int[] array) {
        for(int i=array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(array[j] > array[j+1]) {
                int temp= array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
                }
            }
        printArray(array);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input a filename containg an array: ");
        String fileName = scanner.nextLine();
        System.out.println("Would you like to sort this array? (Yes or No)");
        String input = scanner.nextLine();
        if((input.equals("No"))) {
            scanner.close();
        }
        System.out.println("Please input a filename to store the sorted array: ");
        String sortedFileName = scanner.nextLine();
        int[]array=readArrayFromFile(fileName);
        System.out.println("Would you like to view the content of the sorted array? (Yes or No)");
        String input2 = scanner.nextLine();
        if((input2.equals("No"))) {
            scanner.close();
        }
        bubbleSort(array);
        writeArrayToFile(array,sortedFileName);
        scanner.close();
    }
}
