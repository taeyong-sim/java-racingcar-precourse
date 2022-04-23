package racingcar.domain;

import racingcar.common.ErrorMessage;

import java.util.regex.Pattern;

public class Round {
    private int roundNum;

    public Round(String round) {
        roundValidation(round);
        this.roundNum = Integer.parseInt(round);
    }

    public int getRoundNum() {
        return roundNum;
    }

    public void setRoundNum(int roundNum) {
        this.roundNum = roundNum;
    }

    private void roundValidation(String round){
        String regex = "^[0-9]$";
        if(!Pattern.matches(regex, round)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_NUMBER_ONLY);
        }
    }
}
