package commandline;
import java.util.Scanner;

public class CommandLineInterface extends FileAndDirectoryOperations {

	public  static void main(String[] args) {
//		FileAndDirectoryOperations operations = new FileAndDirectoryOperations();
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to GROUP E Commandline simulator!");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ", 2);
            String cmd = parts[0];
            String argument = parts.length > 1 ? parts[1] : "";

            switch (cmd) {
                case "create_file":
                    createFile(argument);
                    break;
                case "touch":
                    String[] writeArgs = argument.split(" ", 2);
                    if (writeArgs.length < 2) {
                        System.out.println("Usage: touch <filename> <content>");
                    } else {
                        writeFile(writeArgs[0], writeArgs[1]);
                    }
                    break;
                case "read":
                    readFile(argument);
                    break;
                case "rm":
                    deleteFile(argument);
                    break;
                case "mkdir":
                    createDirectory(argument);
                    break;
                case "cd":
                	changeWorkingDirectory(argument);
                	break;
                case "delete_directory":
                    deleteDirectory(argument);
                    break;
                case "pwd":
                    showCurrentDirectory();
                    break;
                case "help":
                	System.out.println(
                			"Available commands"+"\n"
                			+"pwd - Show current directory"+"\n"
                			+"mkdir <directoryName> - create a directory"+"\n"
                			+"touch <fileName>- to read a file"+"\n"
                			+"read <fileName> - to read a file"+"\n"
                			+"rm <fileName> - to delete a file"+"\n"
                			+"cd <directoryName> - to change working directory"+"\n"
                			+"ls - ti list out the contents of the current directory"
                			);
                	break;
                case "ls":
                	listCurrentDirectoryContents();
                	break;                		
                case "exit":
                    System.out.println("Exiting File Manager. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command: " + cmd);
            }
        }
	}

}
