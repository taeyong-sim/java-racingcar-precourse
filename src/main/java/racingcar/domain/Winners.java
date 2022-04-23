package racingcar.domain;

import racingcar.common.Constant;
import racingcar.common.ErrorMessage;
import racingcar.common.InfoMessage;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<Car> winnerList;

    public Winners() {
        this.winnerList = new ArrayList<>();
    }

    public List<Car> getWinnerList() {
        return winnerList;
    }

    public void addWinnerList(Car car) {
        winnerList.add(car);
    }

    @Override
    public String toString() {
        StringBuilder winnerString = new StringBuilder(InfoMessage.OUTPUT_FINAL_WINNER);
        for (Car car : winnerList) {
            winnerString.append(car.getName().getCarName())
                    .append(InfoMessage.OUTPUT_COMMA);
        }
        return winnerString.toString()
                    .replaceAll(", $","");
    }
}
