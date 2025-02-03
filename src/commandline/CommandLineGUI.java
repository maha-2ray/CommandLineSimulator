package commandline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommandLineGUI extends JFrame {

    private JTextArea terminalArea;
    private JTextField commandField;

    public CommandLineGUI() {
        setTitle("Command Line Interface");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        terminalArea = new JTextArea();
        terminalArea.setEditable(false);
        terminalArea.setBackground(Color.BLACK);
        terminalArea.setForeground(Color.WHITE);
        terminalArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(terminalArea);

        commandField = new JTextField();
        commandField.setBackground(Color.BLACK);
        commandField.setForeground(Color.WHITE);
        commandField.setFont(new Font("Monospaced", Font.PLAIN, 14));
        commandField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                processCommand(commandField.getText());
                commandField.setText("");
            }
        });

        // Layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(commandField, BorderLayout.SOUTH);

        add(mainPanel);

        // Welcome message
        terminalArea.append("Welcome to the Command Line Interface!\n");
        terminalArea.append("Type 'help' for a list of commands.\n\n");
    }

    private void processCommand(String command) {
        terminalArea.append("> " + command + "\n");

        String[] parts = command.split(" ", 2);
        String action = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1] : "";

        switch (action) {
            case "create":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing file name.\n");
                } else {
                    String result = FileAndDirectoryOperations.createFile(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "write":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing file name and content.\n");
                } else {
                    String[] writeArgs = argument.split(" ", 2);
                    if (writeArgs.length < 2) {
                        terminalArea.append("Error: Missing content.\n");
                    } else {
                        String result = FileAndDirectoryOperations.writeFile(writeArgs[0], writeArgs[1]);
                        terminalArea.append(result + "\n");
                    }
                }
                break;

            case "read":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing file name.\n");
                } else {
                    String result = FileAndDirectoryOperations.readFile(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "delete":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing file name.\n");
                } else {
                    String result = FileAndDirectoryOperations.deleteFile(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "mkdir":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing directory name.\n");
                } else {
                    String result = FileAndDirectoryOperations.createDirectory(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "rmdir":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing directory name.\n");
                } else {
                    String result = FileAndDirectoryOperations.deleteDirectory(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "cd":
                if (argument.isEmpty()) {
                    terminalArea.append("Error: Missing directory name.\n");
                } else {
                    String result = FileAndDirectoryOperations.changeWorkingDirectory(argument);
                    terminalArea.append(result + "\n");
                }
                break;

            case "ls":
                String result = FileAndDirectoryOperations.listCurrentDirectoryContents();
                terminalArea.append(result + "\n");
                break;

            case "pwd":
                terminalArea.append(FileAndDirectoryOperations.showCurrentDirectory() + "\n");
                break;

            case "help":
                terminalArea.append("Available commands:\n");
                terminalArea.append("  create <file>          - Create a file\n");
                terminalArea.append("  write <file> <content> - Write content to a file\n");
                terminalArea.append("  read <file>            - Read a file\n");
                terminalArea.append("  delete <file>          - Delete a file\n");
                terminalArea.append("  mkdir <dir>            - Create a directory\n");
                terminalArea.append("  rmdir <dir>            - Delete a directory\n");
                terminalArea.append("  cd <dir>               - Change directory\n");
                terminalArea.append("  ls                     - List directory contents\n");
                terminalArea.append("  pwd                    - Show current directory\n");
                terminalArea.append("  help                   - Show this help message\n");
                break;

            default:
                terminalArea.append("Error: Unknown command. Type 'help' for a list of commands.\n");
                break;
        }

        terminalArea.append("\n");
        terminalArea.setCaretPosition(terminalArea.getDocument().getLength()); // Auto-scroll
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CommandLineGUI().setVisible(true);
            }
        });
    }
}