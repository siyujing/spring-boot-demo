package com.testingedu.utilsdemo.enums;


import lombok.Data;

@Data
public class UserPeotocol {


    public enum Group {
        GROUP_1("1", "一班"),
        GROUP_2("2", "二班");

        private String index;
        private String name;

        Group(String index, String name) {
            this.index = index;
            this.name = name;
        }

        public String getIndex() {
            return index;
        }

        public String getName() {
            return name;
        }

        // 通过name 获取枚举值
        public static Group parseByName(String name) {
            for (Group gr : Group.values()) {
                if (gr.getName().equals(name)) {
                    return gr;
                }
            }
            throw new RuntimeException();
        }

        // 通过索引进行拼接 转化成枚举
        public static Group parseByIndex(String index) {
            Group group = Group.valueOf("GROUP_" + index);
            return group;
        }
    }
}
