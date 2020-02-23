import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Searching a word in specific file.
 *
 * @author TeeZ0NE
 */
public class SearchW {
    public static void main(String[] args) {
        String fileName, word = "";
        int count;
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Fill full file name with path:");
            fileName = scanner.nextLine();
            // Check existing file //
            File file = new File(fileName);
            Scanner scanFile = new Scanner(file);
            // Get a word //
            System.out.println("Enter a searching word:");
            word = scanner.nextLine();
            if (word.equals("")) throw new Exception("Word is empty!");
            // Get count of words //
            count = search(scanFile, word);
            System.out.printf("Count of word are/is:%d\r\n", count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.format("Error occur. Message: %s", e.getMessage());
        }
    }

    /**
     * Search word in the file.
     * @param scanFile
     * @param word
     * @return
     */
    private static int search(Scanner scanFile, String word) {
        int count = 0;
        while (scanFile.hasNext()) {
            if (word.equals(scanFile.next())) ++count;
        }
        return count;
    }
}
