package ladder.domain;

import ladder.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    @DisplayName("가능한 모든 길이 연결된 사다리 결과 테스트")
    void run() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d"), new Name("e"));
        Ladder ladder = new Ladder(height, names.size(), () -> true);
        Results results = new Results(List.of("1", "2", "3", "4", "5"), names.size());

        LadderRunResult ladderResult = new Players(names).run(ladder, height, results);

        assertThat(ladderResult.get(new Name("a"))).containsExactly("4");
        assertThat(ladderResult.get(new Name("b"))).containsExactly("5");
        assertThat(ladderResult.get(new Name("c"))).containsExactly("2");
        assertThat(ladderResult.get(new Name("d"))).containsExactly("3");
        assertThat(ladderResult.get(new Name("e"))).containsExactly("1");
    }

    @Test
    @DisplayName("같은 이름이 2개인 케이스")
    void run_samePerson() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("a"), new Name("d"), new Name("e"));
        Ladder ladder = new Ladder(height, names.size(), () -> true);
        Results results = new Results(List.of("1", "2", "3", "4", "5"), names.size());

        LadderRunResult ladderResult = new Players(names).run(ladder, height, results);

        assertThat(ladderResult.get(new Name("a"))).containsExactly("4", "2");
        assertThat(ladderResult.get(new Name("b"))).containsExactly("5");
        assertThat(ladderResult.get(new Name("d"))).containsExactly("3");
        assertThat(ladderResult.get(new Name("e"))).containsExactly("1");
    }

    @Test
    @DisplayName("3회당 한번 연결하는 사다리 테스트")
    void run_third() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d"), new Name("e"));
        AtomicInteger count = new AtomicInteger();
        Ladder ladder = new Ladder(height, names.size(), () -> count.incrementAndGet() % 3 == 0);
        Results results = new Results(List.of("1", "2", "3", "4", "5"), names.size());

        LadderRunResult ladderResult = new Players(names).run(ladder, height, results);

        assertThat(ladderResult.get(new Name("a"))).containsExactly("5");
        assertThat(ladderResult.get(new Name("b"))).containsExactly("3");
        assertThat(ladderResult.get(new Name("c"))).containsExactly("4");
        assertThat(ladderResult.get(new Name("d"))).containsExactly("1");
        assertThat(ladderResult.get(new Name("e"))).containsExactly("2");
    }

    @Test
    @DisplayName("4회당 한번 연결하는 사다리 테스트")
    void run_fourth() {
        int height = 6;
        List<Name> names = List.of(new Name("a"), new Name("b"), new Name("c"), new Name("d"), new Name("e"));
        AtomicInteger count = new AtomicInteger();
        Ladder ladder = new Ladder(height, names.size(), () -> count.incrementAndGet() % 5 == 0);
        Results results = new Results(List.of("1", "2", "3", "4", "5"), names.size());

        LadderRunResult ladderResult = new Players(names).run(ladder, height, results);

        assertThat(ladderResult.get(new Name("a"))).containsExactly("3");
        assertThat(ladderResult.get(new Name("b"))).containsExactly("1");
        assertThat(ladderResult.get(new Name("c"))).containsExactly("5");
        assertThat(ladderResult.get(new Name("d"))).containsExactly("2");
        assertThat(ladderResult.get(new Name("e"))).containsExactly("4");
    }
}
