package baseball;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Numbers {
    final private List<Integer> content;

    public Numbers() {
        content = new ArrayList<>();
        setRandomContent();
    }

    public Numbers(String numbers) {
        content = new ArrayList<>();
        setContent(numbers);
    }

    public void setContent(String numbers) {
        if (isValid(numbers)) {
            throw new IllegalArgumentException("Invalid input");
        }
        for (char number : numbers.toCharArray()) {
            content.add((int)number - '0');
        }
    }

    private boolean isValid(String numbers) {
        Set<Character> checking = new HashSet<>();

        if (numbers.length() != 3 || !numbers.matches("\\d+")) {
            return false;
        }
        for (char number : numbers.toCharArray()) {
            checking.add(number);
        }
        return checking.size() != 3 || checking.contains('0');
    }

    public void setRandomContent() {
        List<Integer> numbers = new ArrayList<>();

        for (int idx = 1; idx < 10; idx++)
            numbers.add(idx);
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 3);
        content.addAll(numbers);
    }

    public Result getResult(Numbers other) {
        int index = 0;
        Result result = new Result();

        for (Integer number : other.content) {
            Type type = getResultType(index++, number);
            result.put(type);
        }
        return result;
    }

    private Type getResultType(int index, int number) {
        if (number == content.get(index)) {
            return Type.Strike;
        }
        if (content.contains(number)) {
            return Type.Ball;
        }
        return Type.None;
    }
}
