package org.example.command.interpreter.domain;

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

        OutputData findOutput = interpreter.execute("find", null);
        OutputData searchOutput = interpreter.execute("search", null);

        log.debug("findOutput = " + findOutput);
        log.debug("searchOutput = " + searchOutput);
    }
}
