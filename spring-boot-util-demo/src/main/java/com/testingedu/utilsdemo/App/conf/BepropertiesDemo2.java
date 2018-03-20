package com.testingedu.utilsdemo.App.conf;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BepropertiesDemo2 {

    @Value("${test.file.file_1}")
    private String file1;

    @Value("${test.file.file_2}")
    private String file2;

    @Value("${test.url_1}")
    private String url1;

    public void showDemo2(){
        System.out.println("file_1="+file1);
        System.out.println("file_2"+file2);
    }
}
