package edu.gavrilov.fs.formatter;

import edu.gavrilov.fs.state.FileSystemState;

public class FileSystemPromptFormatter implements PromptFormatter {

    private final FileSystemState fileSystemState;

    public FileSystemPromptFormatter(FileSystemState fileSystemState) {
        this.fileSystemState = fileSystemState;
    }

    @Override
    public String formatPrompt() {
        return fileSystemState.getCurrentFolder() + " ";
    }
}
