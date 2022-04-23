package racingcar.domain;

import racingcar.common.Constant;
import racingcar.common.ErrorMessage;
import racingcar.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        carListSizeValidation(carList);
        this.carList = carList;
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Cars from(List<Car> carList){
        return new Cars(carList);
    }

    private void carListSizeValidation(List<Car> carList) {
        if (carList.size() < Constant.MIN_CARS_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_MIN_CARS_COUNT);
        }
    }

    public void moveCars(){
        for(Car car : carList){
            car.determineMovement();
        }
    }

}
