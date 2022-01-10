package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    // 컴퓨터 난수 생성
    public String[] getRandomNumber() {
        String[] arr = new String[3];
        for(int i = 0; i < 3; i++){
            arr[i] = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }

        return arr;
    }

    // 사용자 입력
    public String[] getInputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
        String inputNumber = Console.readLine();
        String[] arr = inputNumber.split("");

        return arr;
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Application application = new Application();
        String[] randomNumberArr = application.getRandomNumber();
    }

}
