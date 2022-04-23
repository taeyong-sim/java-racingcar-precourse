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

    private static Input input;
    private static Cars cars;
    private static List<Car> carList;
    private static Game game;
    private static CarService carService;

    public static void run() {
        init();
        inputBeforeGame();
        processGame();
        showResult();
    }

    private static void init() {
        carService = new CarService();
    }

    private static void inputBeforeGame() {
        inputCarName();
        inputRound();
    }

    private static void inputCarName() {
        Output.printMessage(InfoMessage.INPUT_CAR_NAME);
        input = new Input();
        try{
            carList = input.splitCarNames(input.getInput());
            cars = new Cars(carList);
        }catch (IllegalArgumentException e){
            Output.printMessageWithLineSpacing(e.getMessage());
        }

    }

    private static void inputRound() {
        Output.printMessageWithLineSpacing(InfoMessage.INPUT_MOVEMENT_LIMIT);
        input = new Input();
        Round round = new Round(input.getInput());
        game = new Game(cars, round);
    }

    private static void processGame() {
        for (int i = 0; i < game.getRound().getRoundNum(); i++) {
            carService.playGame(cars);
            Output.printLineSpacing();
        }
    }

    private static void showResult(){
        carService.determineMaxPosition(cars);
        carService.determineWinners(cars);
        Output.printWinners(carService.getWinners());
    }

}
