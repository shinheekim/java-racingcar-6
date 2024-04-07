package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public static void outputMessage(){
        System.out.println("실행 결과");
    }

    public static void printCar(Cars cars){
        List<Car> participants = cars.getCars();
        for (Car car : participants) {
            System.out.print(car.getName() + " : ");
            printCarPosition(car);
        }
    }
    public static void printCarPosition(Car car){
        for(int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }
    public static void printWinnerCars(List<Car> winners){
        System.out.println("최종 우승자 : ");

    }
}
