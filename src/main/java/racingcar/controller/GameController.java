package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.validate.CarNameValidate;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

// 연결 다리
public class GameController {

    private final Cars cars = new Cars();
    int repeat;

    public void gameStart(){
       String[] carNames = InputView.inputCarName();
       CarNameValidate.validateCarName(carNames);
       cars.inputCarName(carNames);
       repeat =InputView.printMoveCount();
       Racing(repeat);
    }

    public void Racing(int repeat){
        OutputView.outputMessage();
        for(int round = 0; round < repeat; round++){
            cars.carForward();
            OutputView.printCar(cars);
            sl
        }
        //구현중
//        List<Car> winnerCars = cars.findWinners();
        // 여기서 winner들 출력해주는 거 가져와 OutputView에서

    }

}
