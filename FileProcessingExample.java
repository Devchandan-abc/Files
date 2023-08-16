import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileProcessingExample {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\devch\\OneDrive\\Desktop\\Folders";
        String imageFolderPath = "C:\\Users\\devch\\OneDrive\\Desktop\\Folders\\imagefolderpath";
        String textFolderPath = "C:\\Users\\devch\\OneDrive\\Desktop\\Folders\\textfolderpath";

        String[] imageExtensions = {".png", ".csv"};
        String[] textExtensions = {".txt", ".text"};

        ExecutorService executor = Executors.newFixedThreadPool(5);

        File folder = new File(folderPath);
        for (File file : folder.listFiles()) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (endsWithAny(fileName, imageExtensions)) {
                    executor.submit(() -> processImage(file, imageFolderPath));
                } else if (endsWithAny(fileName, textExtensions)) {
                    executor.submit(() -> processText(file, textFolderPath));
                }
            }
        }

        executor.shutdown();
    }

    private static boolean endsWithAny(String str, String[] suffixes) {
        for (String suffix : suffixes) {
            if (str.endsWith(suffix)) {
                return true;
            }
        }
        return false;
    }

    private static void processImage(File imageFile, String imageFolderPath) {
        // Process image metadata and save to appropriate folder
    }

    private static void processText(File textFile, String textFolderPath) {
        // Save text file to appropriate folder
    }
}
