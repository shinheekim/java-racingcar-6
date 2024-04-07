package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Cars {


    private List<Car> cars;

    private static final int FORWARD_NUM = 4;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void inputCarName(String[] carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        //초기화 시킴
//        Map<String, Integer> carPositions = new HashMap<>();
//        for (String carName : carName) {
//            carPositions.put(carName, 0);
//        }

    }
    public List<Car> getCars(){
        return cars;
    }
//    public int inputMoveCount(){
//        int moveCount = Integer.parseInt(Console.readLine());
//        return moveCount;
//    }

//    public void raceStart(int moveCount){
//        // 실행 결과
//        for (int i = 0; i < moveCount; i++) {
//            carForward();
//            // babo, bobo, boba ~~ : --
//        }
//        List<Car> winnerCars = findWinners();
//    }

    public void carForward() {
        for (Car car : cars) {
            if (createRandomNum() >= FORWARD_NUM) {
                car.moveForward(); // position++;
            }
        }
    }

    public int createRandomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Car> findWinners() {
        int maxPosition = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
