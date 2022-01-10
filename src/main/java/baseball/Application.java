package baseball;

import nextstep.utils.Randoms;
import nextstep.utils.Console;

public class Application {

    // 컴퓨터 난수 생성
    public String[] getRandomNumber() {
        String[] arr = new String[3];
        while (true){
            for(int i = 0; i < 3; i++){
                arr[i] = String.valueOf(Randoms.pickNumberInRange(1, 9));
                System.out.println(arr[i]);
            }
            if (!arr[0].equals(arr[1]) && !arr[1].equals(arr[2]) && !arr[0].equals(arr[2])){
                break;
            }
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

    // 비교 결과 출력
    public boolean printCounts(int[] counts) {
        int countStrike = counts[0];
        int countBall = counts[1];

        if (countStrike == 3) {
            System.out.println(countStrike + "스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            return true;
        }
        if (countStrike == 0 && countBall == 0) {
            System.out.println("낫싱");
        }
        else if (countStrike != 0 && countBall != 0){
            System.out.println(countStrike + "스트라이크 " + countBall + "볼");
        }
        else if (countBall != 0){
            System.out.println(countBall + "볼");
        }
        else {
            System.out.println(countStrike + "스트라이크");
        }

        return false;
    }

    // 게임 종료 여부
    public boolean stopGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int regameNumber = Integer.parseInt(Console.readLine());

        if (regameNumber == 1) {
            return false;
        } else {
            System.out.println("게임 끝");
            return true;
        }
    }

    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        Application application = new Application();
        String[] randomNumberArr = application.getRandomNumber();

        while (true) {
            String[] inputNumberArr = application.getInputNumber();
            int[] counts = application.getCounts(inputNumberArr, randomNumberArr);
            boolean isCorrect = application.printCounts(counts);
            if (!isCorrect){
                continue;
            }
            boolean stopGame = application.stopGame();
            if (stopGame) {
                break;
            } else {
                randomNumberArr = application.getRandomNumber();
            }
        }
    }

}
