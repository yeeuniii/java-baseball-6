package baseball;

import java.util.LinkedHashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Numbers {
    private LinkedHashSet<Integer> content;

    public Numbers() {
        content = new LinkedHashSet<>();
        setRandomContent();
    }
    public Numbers(String numbers) {
        content = new LinkedHashSet<>();
        setContent(numbers);
    }

    public void setContent(String numbers) {
        if (numbers.length() != 3 || !numbers.matches("\\d+"))
            throw new IllegalArgumentException("Invalid input");
        for (char number : numbers.toCharArray())
            content.add((int)number - '0');
        if (content.size() != 3 || content.contains(0))
            throw new IllegalArgumentException("Invalid input");
    }

    public void setRandomContent() {
        List<Integer> numbers = new ArrayList<>();

        for (int idx = 1; idx < 10; idx++)
            numbers.add(idx);
        Collections.shuffle(numbers);
        numbers = numbers.subList(0, 3);
        content.addAll(numbers);
    }

    public String makeResult(Numbers other) {
        int index = 0;
        HashMap<Type, Integer> count = new HashMap<>();

        count.put(Type.None, 0);
        count.put(Type.Ball, 0);
        count.put(Type.Strike, 0);
        for (Integer number : this.content) {
            Type type = getResultType(index++, number, other);
            count.put(type, count.get(type) + 1);
        }
        if (count.get(Type.None) == 3)
            return Type.None.getName();
        String result = Type.Ball.getResult(count.get(Type.Ball));
        result += Type.Strike.getResult(count.get(Type.Strike));
        return result;
    }

    private Type getResultType(int index, Integer number, Numbers other) {
        List<Integer> otherNumbers = new ArrayList<>(other.content);

        if (number.equals(otherNumbers.get(index)))
            return Type.Strike;
        if (otherNumbers.contains(number))
            return Type.Ball;
        return Type.None;
    }
}
