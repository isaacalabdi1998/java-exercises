
import java.util.List;
import java.nio.file.Path;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.io.BufferedWriter;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;


public class FileWriting
{
    // ------------------------- Write String -------------------------
    /**
     * Writes a string to a file, creating the file if it doesn't exist or overwriting it if it does.
     * @param filePath the path to the file
     * @param content  the content to write
     *  @throws IOException if writing fails
     */
    public static void writeString(String filePath, String content) throws IOException
    {
        Files.writeString(Path.of(filePath), content);
    }



    // ------------------------- Append To File -------------------------
    /**
     * Appends text to an existing file. Adds a newline before the text.
     * @param filePath the path to the file
     * @param text     the text to append
     * @throws IOException if writing fails
     */
    public static void appendToFile(String filePath, String text) throws IOException
    {
        Files.writeString(Path.of(filePath), "\n" + text, StandardOpenOption.APPEND);
    }



    // ------------------------- Write Lines -------------------------
    /**
     * Writes a list of strings to a file, one per line.
     * @param filePath the path to the file
     * @param lines    the list of strings to write
     * @throws IOException if writing fails
     */
    public static void writeLines(String filePath, List<String> lines) throws IOException {
        Files.write(Path.of(filePath), lines);
    }


  
    // ------------------------- Write With Buffered Writer -------------------------
    /**
     * Writes to a file using BufferedWriter in a try-with-resources block.
     * Writes three lines of text.
     * @param filePath the path to the file
     * @throws IOException if writing fails
     */
    public static void writeWithBufferedWriter(String filePath) throws IOException
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)))
        {
            writer.write("Line 1");
            writer.newLine();
            writer.write("Line 2");
            writer.newLine();
            writer.write("Line 3");
        }
    }


  
    // ------------------------- Copy File -------------------------
    /**
     * Copies the contents of one file to another.
     * @param sourcePath      the source file path
     * @param destinationPath the destination file path
     * @throws IOException if reading or writing fails
     */
    public static void copyFile(String sourcePath, String destinationPath) throws IOException
    {
        Files.copy(
                Path.of(sourcePath),
                Path.of(destinationPath),
                StandardCopyOption.REPLACE_EXISTING
        );
    }



    // ------------------------- Write CSV -------------------------
    /**
     * Writes formatted CSV data to a file.
     * @param filePath the path to the file
     * @param headers  the column headers
     * @param rows     the data rows (each row is an array of values)
     * @throws IOException if writing fails
     */
    public static void writeCsv(String filePath, String[] headers, String[][] rows) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        sb.append(String.join(",", headers)).append("\n");
        for (String[] row : rows)
        {
            sb.append(String.join(",", row)).append("\n");
        }

        Files.writeString(Path.of(filePath), sb.toString());
    }





  
    ///  ============================== Main Method ==============================
    public static void main(String[] args) throws IOException
    {

        String baseDir = "test-output";
        Files.createDirectories(Path.of(baseDir));

        System.out.println("=== Write String ===");
        writeString(baseDir + "/write-test.txt", "Hello, File!");
        System.out.println("Written. Content: " + Files.readString(Path.of(baseDir + "/write-test.txt")));

      
        System.out.println("\n=== Append to File ===");
        appendToFile(baseDir + "/write-test.txt", "This was appended!");
        System.out.println("Appended. Content:\n" + Files.readString(Path.of(baseDir + "/write-test.txt")));

      
        System.out.println("\n=== Write Lines ===");
        writeLines(baseDir + "/lines-test.txt", List.of("Apple", "Banana", "Cherry"));
        System.out.println("Lines written:");
        Files.readAllLines(Path.of(baseDir + "/lines-test.txt")).forEach(System.out::println);

      
        System.out.println("\n=== BufferedWriter ===");
        writeWithBufferedWriter(baseDir + "/buffered-test.txt");
        System.out.println("BufferedWriter output:");
        Files.readAllLines(Path.of(baseDir + "/buffered-test.txt")).forEach(System.out::println);

      
        System.out.println("\n=== Copy File ===");
        copyFile(baseDir + "/write-test.txt", baseDir + "/copy-test.txt");
        System.out.println("Copied. Content:\n" + Files.readString(Path.of(baseDir + "/copy-test.txt")));

      
        System.out.println("\n=== Write CSV ===");
        String[] headers = {"Name", "Age", "City"};
        String[][] rows = {
                {"Alice", "30", "London"},
                {"Bob", "25", "Paris"},
                {"Charlie", "35", "Tokyo"}
        };
        writeCsv(baseDir + "/data.csv", headers, rows);
        System.out.println("CSV written:");
        System.out.println(Files.readString(Path.of(baseDir + "/data.csv")));

        // Clean up
        Files.walk(Path.of(baseDir))
                .sorted(java.util.Comparator.reverseOrder())
                .forEach(p -> { try { Files.delete(p); } catch (IOException ignored) {} });


    }
}
