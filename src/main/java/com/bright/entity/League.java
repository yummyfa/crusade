package com.bright.entity;

/**
 * @author wangliang
 * @date 2022/2/27 19:28
 */
public enum League {

    FRENCH_ARMOUR("法甲","法甲"),
    SERIE_A("意甲","意甲"),
    BUNDESLIGA("德甲","德甲"),
    PREMIER_LEAGUE("英超","英超"),
    LA_LIGA("西甲","西甲"),
    EUROPEAN_CUP("欧洲杯","欧洲杯"),
    CHAMPIONS_LEAGUE("欧冠","欧冠"),
    WORLD_CUP("世界杯","世界杯"),
            ;

    private String name;

    private String value;

    private League(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public static boolean contains(String name){
        for(League league : values()){
            if (league.equals(name)){
                return true;
            }
        }
        return false;
    }
}
