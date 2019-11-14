package com.chinamobile.epic.tinker.common.constants;
/**
 * @Author: wangjunsheng
 * @Date: 2019/11/4
 * @Descrption:
 */
public enum StatusEnum {
    STAGE_ONE("等待事前评估",000),
    STAGE_TWO("等待事中评估",001),
    STAGE_THREE("等待事后评估",002),
    STAGE_OVER("评估结束",003);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private StatusEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.index == index) {
                return c.name;
            }
        }
        return "";
    }

    public static Integer getIndex(String name) {
        for (StatusEnum c : StatusEnum.values()) {
            if (c.name.equals(name)) {
                return c.index;
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
