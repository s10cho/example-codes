package org.example.person;

import org.example.person.domain.BotInfo;
import org.example.person.domain.PersonInfo;
import org.example.person.service.PersonService;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        personService.say(new PersonInfo("hong", 20));
        personService.say(new BotInfo("bot", 3));
    }
}
