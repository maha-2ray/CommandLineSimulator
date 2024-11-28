package commandline;

import java.io.*;


public class FileAndDirectoryOperations {
	public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("File created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
            System.out.println("Content written to " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    public static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            System.out.println("File deleted: " + fileName);
        } else {
            System.out.println("Failed to delete file: " + fileName);
        }
    }

    public static void createDirectory(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdir()) {
            System.out.println("Directory created: " + dirName);
        } else {
            System.out.println("Failed to create directory.");
        }
    }
    public static void changeWorkingDirectory(String dirName) {
        File directory = new File(dirName);
        if (directory.exists() && directory.isDirectory()) {
            System.setProperty("user.dir", directory.getAbsolutePath());
            System.out.println("Changed current directory to: " + directory.getAbsolutePath());
        } else {
            System.out.println("Invalid directory: " + dirName);
        }
    }

    public static void deleteDirectory(String dirName) {
        File dir = new File(dirName);
        if (dir.isDirectory() && dir.delete()) {
            System.out.println("Directory deleted: " + dirName);
        } else {
            System.out.println("Failed to delete directory.");
        }
    }
    public static void listCurrentDirectoryContents() {
        File currentDir = new File(System.getProperty("user.dir"));
        String[] contents = currentDir.list();
        if (contents != null && contents.length > 0) {
            System.out.println("Contents of the current directory:");
            for (String content : contents) {
                System.out.println(content);
            }
        } else {
            System.out.println("The current directory is empty.");
        }
    }

    public static void showCurrentDirectory() {
        System.out.println("Current Directory: " + System.getProperty("user.dir"));
    }
}
