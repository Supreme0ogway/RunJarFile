import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String jarFileName = "FindAndPrintFiles.jar";

        try {
            // Get the current directory
            String currentDir = System.getProperty("user.dir");

            // Create a File object for the JAR file in the current directory
            File jarFile = new File(currentDir, jarFileName);

            // Check if the JAR file exists
            if (!jarFile.exists()) {
                System.out.println("JAR file does not exist: " + jarFileName);
                return;
            }

            // Check if desktop operations are supported on this platform
            if (!Desktop.isDesktopSupported()) {
                System.out.println("Desktop operations not supported on this platform.");
                return;
            }

            // Get the Desktop instance
            Desktop desktop = Desktop.getDesktop();

            // Check if opening files is supported on this platform
            if (!desktop.isSupported(Desktop.Action.OPEN)) {
                System.out.println("Open operation not supported on this platform.");
                return;
            }

            // Open the JAR file
            desktop.open(jarFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

