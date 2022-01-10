package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    public String[] random() {
        String[] arr = new String[3];
        for(int i = 0; i < 3; i++){
            arr[i] = String.valueOf(Randoms.pickNumberInRange(1, 9));
        }

        return arr;
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Application application = new Application();
        String[] randomNumberArr = application.random();
    }
}
