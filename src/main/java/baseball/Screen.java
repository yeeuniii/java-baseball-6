package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Screen {
    static public void displayGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    static public String inputUserNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return Console.readLine();
    }
    static public void displayGameResult(String result) {
        System.out.println(result);
        if (result.equals(Game.END))
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }



    static public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String willRestart = Console.readLine();
        if (!willRestart.equals("1") && !willRestart.equals("2"))
            throw new IllegalArgumentException("Invalid input");
        return willRestart.equals("1");
    }
}
