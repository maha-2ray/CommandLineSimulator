# User Guide for Command Line Simulator

Welcome to the **Command Line Simulator** developed by Group E! This program allows users to interact with their file system using a simulated command-line interface. Below are instructions for running the simulator, a list of commands, and examples with expected outputs.

## Getting Started
### Prerequisites
- Java Development Kit (JDK) installed (minimum version 8).
- A command-line terminal or Integrated Development Environment (IDE).

### Running the Simulator
1. Copy the `CommandLineInterface` and `FileAndDirectoryOperations` classes into your IDE or a text editor.
2. Compile the files using `javac`:
   ```bash
   javac CommandLineInterface.java
   javac FileAndDirectoryOperations.java
   ```
3. Run the program:
   ```bash
   java CommandLineInterface
   ```

### Output After Running
```plaintext
Welcome to GROUP E Commandline simulator!
> 
```

You can now enter commands in the prompt (`>`).

## Available Commands and Examples
Here’s a list of supported commands with their functionalities and example usage:

1. **pwd**
   - Description: Displays the current directory.
   - Example:
     ```plaintext
     > pwd
     Current Directory: /path/to/your/current/directory
     ```

2. **mkdir <directoryName>**
   - Description: Creates a new directory.
   - Example:
     ```plaintext
     > mkdir testDir
     Directory created: testDir
     ```

3. **create_file <fileName>**
   - Description: Creates a new file.
   - Example:
     ```plaintext
     > create_file example.txt
     File created: example.txt
     ```

4. **touch <fileName> <content>**
   - Description: Writes content to a file. Creates the file if it doesn't exist.
   - Example:
     ```plaintext
     > touch example.txt Hello World
     Content written to example.txt
     ```

5. **read <fileName>**
   - Description: Reads the content of a file.
   - Example:
     ```plaintext
     > read example.txt
     Hello World
     ```

6. **rm <fileName>**
   - Description: Deletes a file.
   - Example:
     ```plaintext
     > rm example.txt
     File deleted: example.txt
     ```

7. **cd <directoryName>**
   - Description: Changes the current directory to the specified directory.
   - Example:
     ```plaintext
     > cd testDir
     Changed current directory to: /path/to/testDir
     ```

8. **delete_directory <directoryName>**
   - Description: Deletes an empty directory.
   - Example:
     ```plaintext
     > delete_directory testDir
     Directory deleted: testDir
     ```

9. **ls**
   - Description: Lists the contents of the current directory.
   - Example:
     ```plaintext
     > ls
     Contents of the current directory:
     example.txt
     testDir
     ```

10. **help**
    - Description: Displays the list of available commands.
    - Example:
      ```plaintext
      > help
      Available commands:
      pwd - Show current directory
      mkdir <directoryName> - create a directory
      touch <fileName> <content> - to write to a file
      read <fileName> - to read a file
      rm <fileName> - to delete a file
      cd <directoryName> - to change working directory
      ls - to list the contents of the current directory
      delete_directory <directoryName> - delete an empty directory
      create_file <fileName> - create a new file
      exit - quit the command-line simulator
      ```

11. **exit**
    - Description: Exits the simulator.
    - Example:
      ```plaintext
      > exit
      Exiting File Manager. Goodbye!
      ```

---

## Design Overview

### Classes
1. **CommandLineInterface**:
   - Entry point of the application.
   - Handles user input and command parsing.
   - Inherits functionality from `FileAndDirectoryOperations`.

2. **FileAndDirectoryOperations**:
   - Contains methods for performing file and directory operations.
   - Each method maps directly to a command (e.g., `createFile` for `create_file`, `readFile` for `read`).

### Key Methods
- **File Operations:**
  - `createFile(String fileName)`: Creates a file in the current directory.
  - `writeFile(String fileName, String content)`: Appends content to a file.
  - `readFile(String fileName)`: Reads and prints the content of a file.
  - `deleteFile(String fileName)`: Deletes a file.

- **Directory Operations:**
  - `createDirectory(String dirName)`: Creates a new directory.
  - `deleteDirectory(String dirName)`: Deletes an empty directory.
  - `changeWorkingDirectory(String dirName)`: Changes the working directory.
  - `listCurrentDirectoryContents()`: Lists the files and subdirectories in the current directory.

### Data Structures
- **`File` Class (java.io):** Used extensively for file and directory operations.
- **String Arrays:** Used to split and parse user input into commands and arguments.

### Algorithms
- **Command Parsing:**
  - User input is split into command and arguments using `String.split()`. Commands are matched using a `switch` statement.

- **Directory Management:**
  - The current directory is tracked using Java’s `System.getProperty("user.dir")`. Methods dynamically operate within the context of this directory.

---

This structured design ensures simplicity and modularity, making the program extensible and easy to maintain.

