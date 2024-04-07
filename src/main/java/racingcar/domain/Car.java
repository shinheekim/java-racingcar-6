package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Car {
    public String carName;

    private static final int FORWARD_NUM = 4;
    private static final int FORWARD_POSITION = 1;
    String[] carNames;
    List<String> winnerCars;

    private String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}
