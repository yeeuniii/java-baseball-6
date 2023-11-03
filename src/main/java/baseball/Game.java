package baseball;

public class Game {
    public static final String END = "3스트라이크";
    private Result result;

    public void start() {
        boolean willRestart = true;

        Screen.displayGameStart();
        while (willRestart) {
            playOneGame();
            willRestart = Screen.askRestart();
        }
    }

    private void playOneGame() {
        Numbers guessingNumber = new Numbers();
        result = new Result();

        while (!isEnd()) {
            Numbers askingNumber = new Numbers(Screen.inputUserNumber());
            result = new Result(guessingNumber, askingNumber);
            Screen.displayGameResult(result.make());
        }
    }

    private boolean isEnd() {
        return result.getContent().equals(END);
    }
}
