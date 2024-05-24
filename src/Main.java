import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        String filePath = "./src/files/testing.txt";
        File file = new File(filePath);


        System.out.println(file.exists());
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        System.out.println("Working Directory = " + new File("").getCanonicalPath());

        for(File f : File.listRoots()){
            System.out.println(f);
        }


        Path path = Paths.get("./src/files/testing.txt");
        if(!Files.exists(path)){
            System.out.println("The file does not exist.");
        }
        System.out.println("The file exists.");

    }


    private static void testFile(String filename){

        Path path = Paths.get(filename);
        FileReader reader = null;
        try {
           // List<String> lines = Files.readAllLines(path);
            reader = new FileReader(filename);
        }
        catch(IOException e) {
            int i = 1/0;
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("This code will execute whether there is an exception or not.");
        }
        System.out.println("The file exists and is ready to be used as a resource.");
    }
    private static void testFile2(String fileName){

        // Check if the file is valid before entering the try block
        try (FileReader reader = new FileReader(fileName)) {
        }
        // Use multiple catch blocks for different types of exceptions
        catch (FileNotFoundException e) {
            System.out.println("File '" + fileName + "' does not exist.");
            throw new RuntimeException(e);
        }catch(NullPointerException | IllegalArgumentException badData){
            System.out.println("The user has provided corrupted data: " + badData.getMessage());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        catch (Exception e){
            System.out.println("exception");
        }
        // The finally block can still be used to print logs even if not needed for closing resources
        finally {
            System.out.println("log log log");
        }

        System.out.println("File exists and we are able to use it as a resources");
    }
}
