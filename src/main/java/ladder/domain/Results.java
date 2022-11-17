package ladder.domain;

import java.util.List;
import java.util.stream.Stream;

public class Results {
    private final List<String> results;

    public Results(List<String> results, int size) {
        validate(results, size);
        this.results = results;
    }

    private void validate(List<String> results, int size) {
        if (results.size() != size) {
            throw new IllegalArgumentException("결과와 인원 수가 다릅니다");
        }
    }

    public Stream<String> stream() {
        return results.stream();
    }

    public int size() {
        return results.size();
    }

    public String get(int i) {
        return results.get(i);
    }
}
