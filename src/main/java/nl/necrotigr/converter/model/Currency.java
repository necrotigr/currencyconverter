package nl.necrotigr.converter.model;

public enum Currency {

    EUR(""), USD(""), RUB(""), CZK(""), THB("");

    private String name;
    private String code;

    Currency(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.name();
    }

    public String getName() {
        return name;
    }
}
