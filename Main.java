
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
      readFile();
    
    }
     
    public static void readFile(){
      try {
        File myObj = new File("numberArray.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
          String data = myReader.nextLine();
          System.out.println(data);
        }
        myReader.close();
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
    }
}
// public class ReadFile {
//     public static void main(String[] args) {
//      
//     }
//   }