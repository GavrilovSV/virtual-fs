package edu.gavrilov.fs.formatter;

public class DefaultPromptFormatter implements PromptFormatter {
    @Override
    public String formatPrompt() {
        return "> ";
    }
}
