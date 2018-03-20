package com.testingedu.utilsdemo.App.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@Component
@ConfigurationProperties(prefix = "test.file")
public class BeProperties {
    @NotNull
    private String file_1;
    @NotNull
    private String file_2;

    public void show(){
        System.out.println("file_1="+file_1);
        System.out.println("file_2"+file_2);
    }
}
