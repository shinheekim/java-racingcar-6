package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Car {

    private static final int FORWARD_NUM = 4;
    private static final int FORWARD_POSITION = 1;
    Map<String, Integer> carPositions = new HashMap<>();
    String[] carNames;
    List<String> winnerCars;
    public void printCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    }

    public void inputCarName(){
        carNames= Console.readLine().split(",");
        // 예외 처리
        validateCarName(carNames);

        //초기화 시킴
//        Map<String, Integer> carPositions = new HashMap<>();
        for (String carName : carNames) {
            carPositions.put(carName, 0);
        }

    }

    public void validateCarName(String[] carNames){
        for (String carName : carNames) {
            if(carName.length() > 5){
                throw new IllegalArgumentException("자동차 이름은 5글자 이하로 만들어 주세요.");
            }
            if(carName.length() < 1){
                throw new IllegalArgumentException("자동차 이름은 1글자 이상으로 만들어 주세요.");
            }
        }
    }

    public void printMoveCount(){
        System.out.println("시도할 회수는 몇 회인가요?");
    }

    public int inputMoveCount(){
        int moveCount = Integer.parseInt(Console.readLine());
        validateMoveCount(moveCount);
        return moveCount;
    }

    public void validateMoveCount(int moveCount){
        if (moveCount < 1) {
            throw new IllegalArgumentException(("시도 횟수는 1 이상이어야 합니다."));
        }
    }

    public int createRandomNum(){
       return Randoms.pickNumberInRange(0, 9);
    }

    public void playGame(String[] carNames, Map<String, Integer> carPositions){
        //몇회 시도
        int tryCount = inputMoveCount();
        System.out.println("실행 결과");
        /*
        * 1.몇회 시도 -> for문
        * 2.자동차 별로 주사위를 굴린다 <- for문으로 할 수 있음 ok? <- 메서드로 분리? 해야할듯
        * 3.4이상일 때 전진 -> if문
        * */
        for(int i = 0; i< tryCount; i++) {
            // 여기서 주사위 굴리고
            carForward(carNames);
            iterCarPositions(carNames,carPositions);
            System.out.println();
        }
    }

    public void carForward(String[] carNames){
        // 2번 for 문
        for(String carName : carNames){
            int randomNum = createRandomNum();
            if (randomNum >= FORWARD_NUM){
                carPositions.put(carName, carPositions.get(carName) + FORWARD_POSITION);
            }
        }
}

    public void iterCarPositions(String[] carNames, Map<String,Integer> carPositions){
        for (String carName : carNames) {
            printCarPositions(carName,carPositions);
        }
    }

    public void printCarPositions(String carName, Map<String,Integer> carPositions){
        System.out.print(carName + " : ");
        for(int i = 0; i < carPositions.get(carName); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public String[] getCarName(){
        return carNames;
    }
    public Map<String, Integer> getCarPositions(){
        return carPositions;
    }

    public List<String> getWinnerCars(){
        return winnerCars;
    }

    public void winnerCar(String[] carNames, Map<String,Integer> carPositions){

        int maxValue = Collections.max(carPositions.values());
        winnerCars = new ArrayList<>();
        for (String carName : carNames){
            if (carPositions.get(carName) == maxValue) {
                winnerCars.add(carName);
            }
        }
    }

    public void printWinnerList(List<String> winnerCars){

        System.out.println("최종 우승자 : " + String.join(", " , winnerCars));
    }
}