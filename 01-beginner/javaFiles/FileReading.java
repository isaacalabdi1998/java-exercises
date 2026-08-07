package javaFile;

import java.util.List;
import java.nio.file.Path;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.nio.file.NoSuchFileException;


public class FileReading
{
    // ------------------------- Read All Lines -------------------------
    /**
     * Reads all lines from a file and returns them as a List.
     * @param filePath the path to the file
     * @return a list of all lines in the file
     * @throws IOException if the file cannot be read
     */
    public static List<String> readAllLines(String filePath) throws IOException
    {
        return Files.readAllLines(Path.of(filePath));
    }



    // ------------------------- Read With BufferedReader -------------------------
    /**
     * Reads a file using BufferedReader in a try-with-resources block.
     * Prints each line to the console.
     * @param filePath the path to the file
     * @throws IOException if the file cannot be read
     */
    public static void readWithBufferedReader(String filePath) throws IOException
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
    }



    // ------------------------- Count Lines -------------------------
    /**
     * Counts the number of lines in a file.
     * @param filePath the path to the file
     * @return the number of lines
     * @throws IOException if the file cannot be read
     * You can use Files.readAllLines() and call .size(),
     * or use Files.lines() with .count() for a stream-based approach.
     */
    public static long countLines(String filePath) throws IOException
    {
        try (Stream<String> lines = Files.lines(Path.of(filePath)))
        {
            return lines.count();
        }
    }



    // ------------------------- Search Word -------------------------
    /**
     * Searches for a word in a file and returns all lines containing that word.
     * @param filePath the path to the file
     * @param word     the word to search for
     * @return a list of lines containing the word
     * @throws IOException if the file cannot be read
     */
    public static List<String> searchWord(String filePath, String word) throws IOException
    {
        return Files.readAllLines(Path.of(filePath))
                .stream()
                .filter(line -> line.contains(word))
                .collect(Collectors.toList());
    }



    // ------------------------- Read File As String -------------------------
    /**
     * Reads the entire file contents into a single String.
     * @param filePath the path to the file
     * @return the file contents as a single String
     * @throws IOException if the file cannot be read
     */
    public static String readFileAsString(String filePath) throws IOException
    {
        return Files.readString(Path.of(filePath));
    }



    // ------------------------- Handle Missing File -------------------------
    /**
     * Attempts to read a file that does not exist. Handles the exception gracefully.
     * @param filePath the path to a non-existent file
     * @return an error message, or file contents if file actually exists
     */
    public static String handleMissingFile(String filePath)
    {
        try
        {
            return Files.readString(Path.of(filePath));
        }
        catch (NoSuchFileException e)
        {
            return "File not found: " + filePath;
        }
        catch (IOException e)
        {
            return "Error reading file: " + e.getMessage();
        }
    }





  
    ///  ============================== Main Method ==============================

    public static void main(String[] args) throws IOException
    {
        // First, create a test file so the exercises can run
        String testFile = "testFile.txt";
        /*Files.writeString(Path.of(testFile),
                "Hello World\nJava is great\nPractice makes perfect\nHello again\nJava rocks!");*/




        System.out.println("====== Read All Lines ======");
        List<String> lines = readAllLines(testFile);
        if (lines != null) lines.forEach(System.out::println);



        System.out.println("\n====== BufferedReader ======");
        readWithBufferedReader(testFile);



        System.out.println("\n=== Count Lines ===");
        System.out.println("Number of lines: " + countLines(testFile));



        System.out.println("\n=== Search Word ===");
        List<String> results = searchWord(testFile, "Java");
        if (results != null) results.forEach(l -> System.out.println("Found: " + l));



        System.out.println("\n=== Read as String ===");
        String content = readFileAsString(testFile);
        if (content != null) System.out.println(content);


        System.out.println("\n=== Handle Missing File ===");
        System.out.println(handleMissingFile("nonexistent.txt"));
    }


  
}
