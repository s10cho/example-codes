package org.example.command.interpreter.domain.handler;

import static org.example.command.interpreter.domain.Command.FIND;

import lombok.extern.slf4j.Slf4j;
import org.example.command.interpreter.domain.Command;
import org.example.command.interpreter.domain.CommandHandler;
import org.example.command.interpreter.domain.InputData;
import org.example.command.interpreter.domain.OutputData;
import org.example.command.interpreter.domain.output.FindOutput;

@Slf4j
public class FindCommandHandler implements CommandHandler {

    @Override
    public Command getCommand() {
        return FIND;
    }

    @Override
    public OutputData handleCommand(InputData inputData) {
        log.info("command: {}", getCommand());
        return new FindOutput("item01");
    }
}
