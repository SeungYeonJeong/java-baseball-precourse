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

    // 랜덤값, 입력값 비교 후 볼, 스트라이크 개수 반환
    public int[] getCounts(String[] inputValue, String[] randomValue) {
        int[] counts = new int[2];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if (i == j && inputValue[i].equals(randomValue[j])){
                    counts[0]++;
                    break;
                }
                if (i != j && inputValue[i].equals(randomValue[j])){
                    counts[1]++;
                    break;
                }
            }
        }

        return counts;
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Application application = new Application();
        String[] randomNumberArr = application.getRandomNumber();

        while (true) {
            String[] inputNumberArr = application.getInputNumber();
            int[] counts = application.getCounts(inputNumberArr, randomNumberArr);
        }
    }

}
