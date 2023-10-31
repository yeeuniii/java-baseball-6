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
        Numbers correctNumbers = new Numbers();
        Result result = new Result();

        while (!result.isEnd()) {
            Numbers questionNumbers = new Numbers(Screen.inputUserNumber());
            result = correctNumbers.makeResult(questionNumbers);
            Screen.displayGameResult(result);
        }
    }
}
