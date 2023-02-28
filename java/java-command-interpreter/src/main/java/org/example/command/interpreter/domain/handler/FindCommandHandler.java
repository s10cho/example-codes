package org.example.command.interpreter.domain.handler;

import lombok.extern.slf4j.Slf4j;
import org.example.command.interpreter.domain.CommandHandler;
import org.example.command.interpreter.domain.InputData;
import org.example.command.interpreter.domain.OutputData;
import org.example.command.interpreter.domain.output.FindOutput;

@Slf4j
public class FindCommandHandler implements CommandHandler {

    @Override
    public OutputData handleCommand(InputData inputData) {
        log.info("handler: {}", getClass().getSimpleName());
        return new FindOutput("item01");
    }
}
