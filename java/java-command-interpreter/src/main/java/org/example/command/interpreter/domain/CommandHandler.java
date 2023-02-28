package org.example.command.interpreter.domain;

public interface CommandHandler {

    OutputData handleCommand(InputData inputData);
}
