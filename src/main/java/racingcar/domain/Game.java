package racingcar.domain;

public class Game {
    private Cars cars;
    private Round round;

    public Game(Cars cars, Round round) {
        this.cars = cars;
        this.round = round;
    }

    public Cars getCars() {
        return cars;
    }

    public Round getRound() {
        return round;
    }

}
