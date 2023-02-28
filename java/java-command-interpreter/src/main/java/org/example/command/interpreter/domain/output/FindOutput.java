package org.example.command.interpreter.domain.output;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.command.interpreter.domain.OutputData;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FindOutput implements OutputData {

    private String itemName;

    @Override
    public String toString() {
        return "FindOutput{" +
            "itemName='" + itemName + '\'' +
            '}';
    }
}
