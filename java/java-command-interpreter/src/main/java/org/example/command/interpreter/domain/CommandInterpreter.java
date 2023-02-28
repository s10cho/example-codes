package org.example.command.interpreter.domain;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommandInterpreter {

    private Map<String, CommandHandler> handlers;

    public CommandInterpreter(CommandHandler... handlers) {
        this.handlers = stream(handlers).collect(toMap(
            handler -> handler.getClass().getSimpleName().replace("CommandHandler", "").toLowerCase(),
            identity()
        ));
    }

    public OutputData execute(String command, InputData inputData) {
        return Optional.ofNullable(handlers.get(command))
            .orElseThrow(() -> new NoSuchElementException("Not found command. command: " + command))
            .handleCommand(inputData);
    }
}
