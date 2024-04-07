package racingcar;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    Car car = new Car();
    car.printCarName();
    car.inputCarName();
    car.printMoveCount();
    car.playGame(car.getCarName(), car.getCarPositions());
    car.winnerCar(car.getCarName(),car.getCarPositions());
    car.printWinnerList(car.getWinnerCars());
    }
}
