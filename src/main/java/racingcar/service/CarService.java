package racingcar.service;

import racingcar.common.InfoMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Position;
import racingcar.domain.Winners;
import racingcar.ui.Output;

public class CarService {

    private Position maxPosition;
    private Winners winners;

    public void playGame(Cars cars) {
        cars.moveCars();
        Output.printMessageWithLineSpacing(InfoMessage.OUTPUT_RUN_RESULT);
        Output.printInterimResult(cars);
    }

    public void determineMaxPosition(Cars cars) {
        winners = new Winners();
        maxPosition = new Position(0);
        for (Car car : cars.getCarList()) {
            maxPosition.setCarPosition(Math.max(maxPosition.getCarPosition(), car.getPosition().getCarPosition()));
        }
    }

    public void determineWinners(Cars cars) {
        for (Car car : cars.getCarList()) {
            addEachWinner(car);
        }
    }

    private void addEachWinner(Car car) {
        if (car.getPosition().getCarPosition() == maxPosition.getCarPosition()) {
            winners.addWinnerList(car);
        }
    }

    public Winners getWinners() {
        return this.winners;
    }

}
