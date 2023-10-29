package baseball;

public enum Type {
    None(""),
    Ball("볼"),
    Strike("스트라이크");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getResult(int time) {
        if (time > 0)
            return String.format("%d%s", time, this.name);
        return "";
    }





}

