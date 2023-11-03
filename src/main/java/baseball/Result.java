package baseball;

import java.util.HashMap;
import java.util.List;

public class Result {
    private final Numbers guessing;
    private final Numbers asking;
    private final HashMap<Type, Integer> count;
    private String content;

    public Result() {
        guessing = new Numbers();
        asking = new Numbers();
        count = new HashMap<>();
        this.content = "";
    }

    public Result(Numbers guessing, Numbers asking) {
        this.guessing = guessing;
        this.asking = asking;
        this.count = new HashMap<>();
        this.count.put(Type.None, 0);
        this.count.put(Type.Ball, 0);
        this.count.put(Type.Strike, 0);
    }

    public String getContent() {
        return content;
    }

    public String make() {
        countType();
        if (count.get(Type.None) == 3) {
            content = Type.None.getName();
            return content;
        }
        content = Type.Ball.getResult(count.get(Type.Ball));
        if (!content.isEmpty())
            content += " ";
        content += Type.Strike.getResult(count.get(Type.Strike));
        return content;
    }

    private void countType() {
        int index = 0;
        for (Integer number : asking.getContent()) {
            Type type = getResultType(index++, number);
            count.put(type, count.get(type) + 1);
        }
    }

    private Type getResultType(int index, Integer number) {
        List<Integer> guessingNumber = guessing.getContent();

        if (number.equals(guessingNumber.get(index)))
            return Type.Strike;
        if (guessingNumber.contains(number))
            return Type.Ball;
        return Type.None;
    }
}
