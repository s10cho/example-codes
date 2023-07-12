package com.example.command.interpreter.domain.handler;

import com.example.command.interpreter.domain.CommandHandler;
import com.example.command.interpreter.domain.InputData;
import com.example.command.interpreter.domain.OutputData;
import com.example.command.interpreter.domain.output.FindOutput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindCommandHandler implements CommandHandler {

    @Override
    public OutputData handleCommand(InputData inputData) {
        log.info("handler: {}", getClass().getSimpleName());
        return new FindOutput("item01");
    }
}
