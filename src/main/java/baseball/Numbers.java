package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Numbers {
    private final List<String> numbers;

    private static final List<String> AVAILABLE_NUMBERS = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");

    public Numbers() {
        this.numbers = getRandomNumbers();
    }

    public Numbers(String numbers) {
        this.numbers = toNumbers(numbers);
    }

    private List<String> toNumbers(String numbersString) {
        List<String> numbers = Arrays.asList(numbersString.split(""));
        checkValid(numbers);
        return numbers;
    }

    private void checkValid(List<String> numbers) {
        if (isInvalid(numbers)) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

    private boolean isInvalid(List<String> numbers) {
        HashSet<String> numbersWithoutDuplication = new HashSet<>(numbers);
        return numbersWithoutDuplication.size() != 3 || numbersWithoutDuplication.stream().anyMatch(number -> !AVAILABLE_NUMBERS.contains(number));
    }

    private List<String> getRandomNumbers() {
        List<String> availableNumbers = new ArrayList<>(AVAILABLE_NUMBERS);
        Collections.shuffle(availableNumbers);
        return availableNumbers.subList(0, 3);
    }

    public Result makeResult(Numbers other) {
        int index = 0;
        Result result = new Result();

        for (String number : this.numbers) {
            Type type = other.getResultType(index++, number);
            result.countIt(type);
        }
        return result;
    }

    private Type getResultType(int index, String number) {
        if (number.equals(numbers.get(index))) {
            return Type.Strike;
        }
        if (numbers.contains(number)) {
            return Type.Ball;
        }
        return Type.None;
    }
}
