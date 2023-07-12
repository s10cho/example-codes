package com.example.person;

import com.example.person.domain.BotInfo;
import com.example.person.domain.PersonInfo;
import com.example.person.service.PersonService;

public class App {

    public static void main(String[] args) {
        PersonService personService = new PersonService();
        personService.say(new PersonInfo("hong", 20));
        personService.say(new BotInfo("bot", 3));
    }
}
