package racingcar.domain;

import racingcar.enums.Action;

public class Position {
    private int carPosition;

    public Position(int carPosition) {
        this.carPosition = carPosition;
    }

    public void setCarPosition(int carPosition) {
        this.carPosition = carPosition;
    }

    public int getCarPosition() {
        return carPosition;
    }

    public void addCarPosition(Action action){
        if(isMoving(action)){
            carPosition++;
        }
    }

    private boolean isMoving(Action action){
        return action == Action.MOVE;
    }
}
