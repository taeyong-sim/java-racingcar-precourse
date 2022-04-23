package racingcar.controller;

import racingcar.common.InfoMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.Round;
import racingcar.service.CarService;
import racingcar.ui.Input;
import racingcar.ui.Output;

import java.util.List;

public class CarController {

    private Input input;
    private Cars cars;
    private List<Car> carList;
    private Game game;
    private CarService carService;

    public void run() {
        initCarService();
        inputToStartGame();
        processGame();
        showResult();
    }

    private void initCarService() {
        carService = new CarService();
    }

    private void inputToStartGame() {
        inputCarName();
        inputRound();
    }

    private void inputCarName() {
        Output.printMessage(InfoMessage.INPUT_CAR_NAME);
        input = new Input();
        try {
            carList = input.splitCarNames(input.getInput());
            cars = new Cars(carList);
        } catch (IllegalArgumentException e) {
            Output.printMessageWithLineSpacing(e.getMessage());
        }
    }

    private void inputRound() {
        Output.printMessageWithLineSpacing(InfoMessage.INPUT_MOVEMENT_LIMIT);
        input = new Input();
        Round round = new Round(input.getInput());
        game = new Game(cars, round);
    }

    private void processGame() {
        for (int i = 0; i < game.getRound().getRoundNum(); i++) {
            carService.playGame(cars);
            Output.printLineSpacing();
        }
    }

    private void showResult() {
        carService.determineMaxPosition(cars);
        carService.determineWinners(cars);
        Output.printWinners(carService.getWinners());
    }

}
