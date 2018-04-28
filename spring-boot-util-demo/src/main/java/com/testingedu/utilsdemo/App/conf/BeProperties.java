package com.testingedu.utilsdemo.App.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * 引入配置文件参数
 * */
@Data
@Component
@ConfigurationProperties(prefix = "test.file")
public class BeProperties {
    @NotNull
    private String file_1;
    @NotNull
    private String file_2;

    public void show(){
        String url = String.format(file_1,"xiaoming");
        System.out.println("file_1="+file_1);
        System.out.println("file_2"+file_2);
        System.out.println("url="+url);
    }
}
