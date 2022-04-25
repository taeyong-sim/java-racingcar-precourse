package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.common.ErrorMessage;

class RoundTest {
    @Test
    void 실행횟수_0_입력시_예외(){
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> new Round("0"));
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_ROUND_POSITIVE);
    }

    @Test
    void 실행횟수_음수_입력시_예외(){
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> new Round("-1"));
        assertThat(throwable.getMessage()).isEqualTo(ErrorMessage.ERROR_ROUND_POSITIVE);
    }
}