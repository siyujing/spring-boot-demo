package com.testingedu.objectprogrammingfivedesignprinciples.状态模式.workDemo;

import org.springframework.stereotype.Service;

@Service
public class WorkDemoService {

    public void serviceMethod(){
        Work work = new Work();
        work.setHour(9.0);
        work.writeProgrammer();

        work.setHour(11.0);
        work.writeProgrammer();

        work.setHour(12.0);
        work.writeProgrammer();

        work.setHour(13.0);
        work.writeProgrammer();

        work.setHour(14.0);
        work.writeProgrammer();

        work.setHour(17.0);
        work.writeProgrammer();

        work.setHour(18.0);
        work.writeProgrammer();
    }
}
