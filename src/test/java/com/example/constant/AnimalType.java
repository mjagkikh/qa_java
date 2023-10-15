package com.example.constant;

public enum AnimalType {
    HERBIVORE("Травоядное"),
    PREDATOR("Хищник"),
    UNKNOW("Неизвестный тип");

    private String type;
    AnimalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}