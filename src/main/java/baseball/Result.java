package baseball;

import java.util.HashMap;

public class Result {
    private final HashMap<Type, Integer> count;

    public Result() {
        this.count = new HashMap<>();
        init();
    }

    public void init() {
        this.count.put(Type.None, 0);
        this.count.put(Type.Ball, 0);
        this.count.put(Type.Strike, 0);
    }

    public void put(Type type) {
        count.put(type, count.get(type) + 1);
    }

    public String make() {
        if (count.get(Type.None) == 3) {
            return Type.None.getName();
        }
        String result = Type.Ball.getResult(count.get(Type.Ball));
        if (!result.isEmpty())
            result += " ";
        result += Type.Strike.getResult(count.get(Type.Strike));
        return result;
    }

    public boolean isEnd() {
        return count.get(Type.Strike) == 3;
    }
}
