package com.wang.material.material.enums;

public enum RoleEnum {
    WORKER("WORKER", "普通员工"),
    ADMIN("ADMIN", "管理员");

    private String code;

    private String name;

    private RoleEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
