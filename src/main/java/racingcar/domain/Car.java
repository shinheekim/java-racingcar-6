package racingcar.domain;

public class Car {
    public String carName;

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
