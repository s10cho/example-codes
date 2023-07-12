package com.example.command.interpreter.domain.output;

import com.example.command.interpreter.domain.OutputData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
