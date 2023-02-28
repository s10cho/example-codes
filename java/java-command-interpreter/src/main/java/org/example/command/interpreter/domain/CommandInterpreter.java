package org.example.command.interpreter.domain;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommandInterpreter {

    private Map<Command, CommandHandler> handlers;

    public CommandInterpreter(CommandHandler... handlers) {
        this.handlers = stream(handlers).collect(toMap(CommandHandler::getCommand, identity()));
    }

    public OutputData execute(Command command, InputData inputData) {
        return handlers.get(command).handleCommand(inputData);
    }
}
