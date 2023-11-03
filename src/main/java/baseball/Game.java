package baseball;

public class Game {

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
        Result result = new Result();

        while (!result.isEnd()) {
            Numbers askingNumber = new Numbers(Screen.inputUserNumber());
            result = guessingNumber.getResult(askingNumber);
            Screen.displayGameResult(result);
        }
    }
}
