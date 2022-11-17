package ladder.domain;

import java.util.*;

public class Players {
    private final List<Name> names;

    public Players(List<Name> names) {
        this.names = names;
    }

    public LadderRunResult run(Ladder ladder, int height, Results results) {
        LadderRunResult ladderRunResult = new LadderRunResult();
        for (int currentLine = 0; currentLine < names.size(); currentLine++) {
            Name name = names.get(currentLine);
            ladderRunResult.add(name, results.get(ladder.getPersonResult(currentLine, height)));
        }

        return ladderRunResult;
    }
}
