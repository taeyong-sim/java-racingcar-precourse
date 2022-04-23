package racingcar.service;

import racingcar.domain.Cars;

public class InputService {
    private Cars cars;

    public InputService(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }
}
