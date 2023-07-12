package com.example.command.interpreter.domain.handler;

import java.util.Arrays;

import com.example.command.interpreter.domain.CommandHandler;
import com.example.command.interpreter.domain.InputData;
import com.example.command.interpreter.domain.OutputData;
import com.example.command.interpreter.domain.output.SearchOutput;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchCommandHandler implements CommandHandler {

    @Override
    public OutputData handleCommand(InputData inputData) {
        log.info("handler: {}", getClass().getSimpleName());
        return new SearchOutput(Arrays.asList("item01", "item02"));
    }
}
