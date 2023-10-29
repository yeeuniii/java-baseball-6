package baseball;

public class Game {
    public static final String END = "3스트라이크";

    public void start() {
        boolean willRestart = true;

        Screen.displayGameStart();
        while (willRestart) {
            playOneGame();
            willRestart = Screen.askRestart();
        }
    }

    private void playOneGame() {
        Numbers computer = new Numbers();
        String result = "";

        while (!result.equals(END)) {
            Numbers user = new Numbers(Screen.inputUserNumber());
            result = user.makeResult(computer);
            Screen.displayGameResult(result);
        }
    }
}
