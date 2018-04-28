package com.testingedu.utilsdemo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootUtilDemoApplicationTests {

    @Test
    public void contextLoads() {
        Multimap<String,String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("a","a1");
        myMultimap.put("a","a2");
        myMultimap.put("b","b1");
        Map<String, Collection<String>> asMap = myMultimap.asMap();
        asMap.forEach((key, value)->{
            System.out.println(key+"--"+value);
        });

        boolean b = myMultimap.containsEntry("a", "a1");
        System.out.println(b);
        Collection<Map.Entry<String, String>> entries = myMultimap.entries();

    }

}
