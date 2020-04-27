package cn.szh.enums;


public enum Sex {
    /**
     * @Desc：性别枚举
     */
    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");
        //类型
    public final Integer type;
        //  数据库的值
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
