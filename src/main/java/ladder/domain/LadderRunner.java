package ladder.domain;

import java.util.*;

public class LadderRunner {
    private final List<Name> names;
    private final Ladder ladder;

    public LadderRunner(List<Name> names, Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public LadderRunResult run(int height, Results results) {
        LadderRunResult ladderRunResult = new LadderRunResult();
        for (int currentLine = 0; currentLine < names.size(); currentLine++) {
            Name name = names.get(currentLine);
            ladderRunResult.add(name, results.get(ladder.getPersonResult(currentLine, height)));
        }

        return ladderRunResult;
    }
}
