package org.example.command.interpreter.domain;

import static org.example.command.interpreter.domain.Command.FIND;
import static org.example.command.interpreter.domain.Command.SEARCH;

import lombok.extern.slf4j.Slf4j;
import org.example.command.interpreter.domain.handler.FindCommandHandler;
import org.example.command.interpreter.domain.handler.SearchCommandHandler;
import org.junit.jupiter.api.Test;

@Slf4j
class CommandInterpreterTest {

    @Test
    void interpreterTest() {
        CommandInterpreter interpreter = new CommandInterpreter(
            new SearchCommandHandler(),
            new FindCommandHandler()
        );

        OutputData findOutput = interpreter.execute(FIND, null);
        OutputData searchOutput = interpreter.execute(SEARCH, null);

        log.debug("findOutput = " + findOutput);
        log.debug("searchOutput = " + searchOutput);
    }
}
