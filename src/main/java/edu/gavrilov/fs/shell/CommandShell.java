package edu.gavrilov.fs.shell;

import edu.gavrilov.fs.command.Command;
import edu.gavrilov.fs.formatter.PromptFormatter;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandShell {

    private final Map<String, Command> supportedCommands = new HashMap<>();
    private final PromptFormatter promptFormatter;
    private final Scanner scanner = new Scanner(System.in);

    public CommandShell(PromptFormatter promptFormatter, Command... supportedCommands) {
        this.promptFormatter = promptFormatter;
        for (Command command : supportedCommands) {
            registerCommand(command);
        }
    }

    public void registerCommand(Command command) {
        this.supportedCommands.put(command.getName(), command);
    }

    public void init() {
        while (true) {
            System.out.print(promptFormatter.formatPrompt());
            String input = scanner.nextLine();
            CommandWithArguments commandWithArguments = CommandWithArguments.build(input);
            Command command = supportedCommands.get(commandWithArguments.getCommand());
            String[] args = commandWithArguments.getArgs();

            if (command != null) {
                command.execute(args);
            } else {
                System.err.println("Command not recognized");
            }
        }
    }

}
