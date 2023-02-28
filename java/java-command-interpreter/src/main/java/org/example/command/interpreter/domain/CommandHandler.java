package org.example.command.interpreter.domain;

public interface CommandHandler {

    Command getCommand();

    OutputData handleCommand(InputData inputData);
}
