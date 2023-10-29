package baseball;

import java.util.*;

public class Numbers {
    private LinkedHashSet<Integer> content;

    public Numbers() {
        setRandomContent();
    }
    public Numbers(String numbers) {
        setContent(numbers);
    }

    public void setContent(String numbers) {
        if (numbers.length() != 3 || !numbers.matches("\\d+"))
            throw new IllegalArgumentException("Invalid input");
        content = new LinkedHashSet<>();
        for (char number : numbers.toCharArray())
            content.add((int)number + '0');
        if (content.size() != 3 || content.contains(0))
            throw new IllegalArgumentException("Invalid input");
    }

    public void setRandomContent() {
        List<Integer> numbers = new ArrayList<>();

        for (int idx = 1; idx < 10; idx++)
            numbers.add(idx);
        Collections.shuffle(numbers);
        numbers.subList(0, 2);
        content = new LinkedHashSet<>(numbers);
    }
}
