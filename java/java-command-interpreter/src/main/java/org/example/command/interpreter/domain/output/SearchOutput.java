package org.example.command.interpreter.domain.output;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.command.interpreter.domain.OutputData;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchOutput implements OutputData {

    private List<String> itemNames;

    @Override
    public String toString() {
        return "SearchOutput{" +
            "itemNames=" + itemNames +
            '}';
    }
}
