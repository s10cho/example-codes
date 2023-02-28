package org.example.command.interpreter.domain.input;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.command.interpreter.domain.InputData;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SearchInput implements InputData {

    private String searchText;
}
