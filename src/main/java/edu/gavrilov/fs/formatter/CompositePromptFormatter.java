package edu.gavrilov.fs.formatter;

public class CompositePromptFormatter implements PromptFormatter {

    private final PromptFormatter[] formatters;

    public CompositePromptFormatter(PromptFormatter... formatters) {
        this.formatters = formatters;
    }

    @Override
    public String formatPrompt() {
        StringBuilder result = new StringBuilder();
        for (PromptFormatter formatter : formatters) {
            result.append(formatter.formatPrompt());
        }
        return result.toString();
    }
}
