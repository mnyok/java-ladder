package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderRunnerTest {

    @Test
    @DisplayName("가능한 모든 길이 연결된 사다리 결과 테스트")
    void run() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d"), new Name("e"));
        Ladder ladder = new Ladder(height, names.size(), () -> true);
        Results results = new Results(List.of("1", "2", "3", "4", "5"), names.size());

        LadderRunResult ladderResult = new LadderRunner(names, ladder).run(height, results);

        assertThat(ladderResult.get(new Name("a"))).containsExactly("4");
        assertThat(ladderResult.get(new Name("b"))).containsExactly("5");
        assertThat(ladderResult.get(new Name("c"))).containsExactly("2");
        assertThat(ladderResult.get(new Name("d"))).containsExactly("3");
        assertThat(ladderResult.get(new Name("e"))).containsExactly("1");
    }
}
