package commandline;

import java.io.*;

public class FileAndDirectoryOperations {

    public static String createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                return "File created: " + fileName;
            } else {
                return "File already exists.";
            }
        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public static String writeFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            writer.newLine();
            return "Content written to " + fileName;
        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public static String readFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            return content.toString();
        } catch (FileNotFoundException e) {
            return "File not found: " + fileName;
        } catch (IOException e) {
            return "An error occurred: " + e.getMessage();
        }
    }

    public static String deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.delete()) {
            return "File deleted: " + fileName;
        } else {
            return "Failed to delete file: " + fileName;
        }
    }

    public static String createDirectory(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdir()) {
            return "Directory created: " + dirName;
        } else {
            return "Failed to create directory.";
        }
    }

    public static String changeWorkingDirectory(String dirName) {
        File directory = new File(dirName);
        if (directory.exists() && directory.isDirectory()) {
            System.setProperty("user.dir", directory.getAbsolutePath());
            return "Changed current directory to: " + directory.getAbsolutePath();
        } else {
            return "Invalid directory: " + dirName;
        }
    }

    public static String deleteDirectory(String dirName) {
        File dir = new File(dirName);
        if (dir.isDirectory() && dir.delete()) {
            return "Directory deleted: " + dirName;
        } else {
            return "Failed to delete directory.";
        }
    }

    public static String listCurrentDirectoryContents() {
        File currentDir = new File(System.getProperty("user.dir"));
        String[] contents = currentDir.list();
        if (contents != null && contents.length > 0) {
            StringBuilder result = new StringBuilder("Contents of the current directory:\n");
            for (String content : contents) {
                result.append(content).append("\n");
            }
            return result.toString();
        } else {
            return "The current directory is empty.";
        }
    }

    public static String showCurrentDirectory() {
        return "Current Directory: " + System.getProperty("user.dir");
    }
}