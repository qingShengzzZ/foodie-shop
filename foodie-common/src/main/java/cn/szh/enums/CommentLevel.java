package cn.szh.enums;


public enum CommentLevel {
    /**
     * 商品评价等级 枚举
     */
    GOOD(1,"好评"),
    NOMAL(2,"中评"),
    BAD(3,"差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
