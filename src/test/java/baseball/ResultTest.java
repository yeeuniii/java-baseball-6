package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {
    @Test
    void 결과_잘_나오는지_확인() {
        Numbers guessing = new Numbers("217");
        Numbers asking = new Numbers("241");
        Result result = new Result(asking, guessing);

        result.make();
        String content = result.getContent();
        assertThat(content).isEqualTo("1볼 1스트라이크");
    }

}
