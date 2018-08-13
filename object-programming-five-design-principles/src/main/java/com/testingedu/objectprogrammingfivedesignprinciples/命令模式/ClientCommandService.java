package com.testingedu.objectprogrammingfivedesignprinciples.命令模式;

import org.springframework.stereotype.Service;

@Service
public class ClientCommandService {
    public void invokerRequest(){
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        command.execute();
    }
}
