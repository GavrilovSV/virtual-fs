package edu.gavrilov.fs;

import edu.gavrilov.fs.command.fs.*;
import edu.gavrilov.fs.formatter.CompositePromptFormatter;
import edu.gavrilov.fs.formatter.DefaultPromptFormatter;
import edu.gavrilov.fs.formatter.FileSystemPromptFormatter;
import edu.gavrilov.fs.shell.CommandShell;
import edu.gavrilov.fs.state.FileSystemState;

public class FileSystemMain {
    public static void main(String[] args) {
        FileSystemState fileSystemState = new FileSystemState();

        CommandShell commandShell = new CommandShell(
                new CompositePromptFormatter(
                        new FileSystemPromptFormatter(fileSystemState),
                        new DefaultPromptFormatter()
                ),
                new CreateFileCommand(fileSystemState),
                new CreateFolderCommand(fileSystemState),
                new ListCommand(fileSystemState),
                new ChangeFolderCommand(fileSystemState),
                new PrintWorkingDirectoryCommand(fileSystemState),
                new RemoveCommand(fileSystemState),
                new RenameCommand(fileSystemState)) {
        };

        commandShell.init();
    }
}
