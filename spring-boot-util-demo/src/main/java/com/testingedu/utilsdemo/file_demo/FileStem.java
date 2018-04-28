package com.testingedu.utilsdemo.file_demo;


import com.google.common.collect.Lists;
import com.testingedu.utilsdemo.App.utils.FormatUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileStem {

    public static void main(String[] args) {
        try {
            readFile2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 读 .json 文件并输出
    public static String readAndWrite() {
        try {
            String url = "all_files/json_file.json";
            InputStream inputStream = new ClassPathResource(url).getInputStream();
            List<String> list = IOUtils.readLines(inputStream);
            StringBuilder stringBuilder = new StringBuilder();
            list.forEach(stringBuilder::append);
            System.out.println(stringBuilder);

            // 写到hello.txt文件
            Writer writer = new FileWriter(new File("/Users/boxfish/IdeaProjects/spring-boot-demo/spring-boot-util-demo/src/main/resources/all_files/hello2.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(stringBuilder.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            writer.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
        return "ok";
    }

    public static void readFile() throws IOException {
        File file = new File("/Users/boxfish/IdeaProjects/spring-boot-demo/spring-boot-util-demo/src/main/resources/all_files/json_file.json");
        String readFile = FileUtils.readFileToString(file, "utf-8");
        System.out.println("readFileString=" + readFile);

        Json_file json_file = FormatUtils.fromJson(readFile, Json_file.class);
        System.out.println("key=" + json_file.keyName);
        System.out.println("value=" + json_file.valueName);

    }

    public static void readFile2() throws IOException {
        File_list file_list2 = new File_list();
        file_list2.setList(Lists.newArrayList("qwe", "ert"));
        String toJsonNoException = FormatUtils.toJsonNoException(file_list2);
        System.out.println(toJsonNoException);

        // 读文件
        File file = new File("/Users/boxfish/IdeaProjects/spring-boot-demo/spring-boot-util-demo/src/main/resources/all_files/test1.txt");
        List<String> lineList = FileUtils.readLines(file, "utf-8");

        File_list file_list1 = new File_list();
        file_list1.setList(lineList);
        System.out.println(file_list1.getList().size());

        System.out.println(file_list1.toString());

        System.out.println(FormatUtils.toJsonNoException(file_list1));
    }

    // 读文件流,适用于打包成 jar包
    public void readFile3() {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/all_files/test1.txt");
            String inputString = IOUtils.toString(inputStream, "UTF-8");

            Json_file result = FormatUtils.fromJson(inputString, Json_file.class);

        } catch (IOException e) {
            log.error("Task properties, load res grade error.", e);
        }
    }


    @Data
    public static class Json_file {
        String keyName;
        String valueName;
    }

    @Data
    public static class File_list {
        List<String> list = new ArrayList<>();
    }

}
