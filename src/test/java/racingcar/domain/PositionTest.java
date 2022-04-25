package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.enums.Action;


class PositionTest {

    @Test
    void 포지션_이동_테스트() {
        Position position = new Position(0);
        position.addCarPosition(Action.STOP);
        assertThat(position.getCarPosition()).isEqualTo(0);
        position.addCarPosition(Action.MOVE);
        assertThat(position.getCarPosition()).isEqualTo(1);
        position.addCarPosition(Action.MOVE);
        position.addCarPosition(Action.MOVE);
        assertThat(position.getCarPosition()).isEqualTo(3);
    }

}