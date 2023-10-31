package baseball;

public class Game {

    public void start() {
        boolean isPlaying = true;

        Screen.displayGameStart();
        while (isPlaying) {
            playOneGame();
            isPlaying = Screen.askRestart();
        }
    }

    private void playOneGame() {
        Numbers correctNumbers = new Numbers();
        Result result = new Result();

        while (!result.isEnd()) {
            Numbers questionNumbers = Screen.inputUserNumber();
            result = correctNumbers.makeResult(questionNumbers);
            Screen.displayGameResult(result);
        }
    }
}
