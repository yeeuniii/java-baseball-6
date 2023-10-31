package baseball;

import java.util.HashMap;

public class Result {
    private final HashMap<Type, Integer> count = new HashMap<>();

    public Result() {
        init();
    }

    private void init() {
        count.put(Type.None, 0);
        count.put(Type.Ball, 0);
        count.put(Type.Strike, 0);
    }

    public void countIt(Type type) {
        count.put(type, count.get(type) + 1);
    }

    public boolean isEnd() {
        return count.get(Type.Strike) == 3;
    }

    public String getResult() {
        if (count.get(Type.None) == 3)
            return Type.None.getName();
        String result = Type.Ball.getResult(count.get(Type.Ball));
        result += Type.Strike.getResult(count.get(Type.Strike));
        return result;
    }
}
