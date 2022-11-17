package ladder;

import ladder.domain.*;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;
import java.util.Map;

public class App {
    private static final String ALL = "all";

    public static void main(String[] args) {
        List<Name> names = InputView.inputPeople();
        Results results = new Results(InputView.inputResults(), names.size());
        int height = InputView.inputHeight();

        Ladder ladder = new Ladder(height, names.size(), new RandomLadderConnectDecider());

        ResultView.printNames(names);
        ResultView.printLadder(ladder, names.size(), height);
        ResultView.printResults(results);

        Map<Name, String> ladderResult = new LadderRunner(names, ladder).run(height, results);

        boolean end = false;
        while (!end) {
            end = showResult(ladderResult);
        }
    }

    private static boolean showResult(Map<Name, String> ladderResult) {
        Name name = InputView.inputShowResult();
        if (name.equals(ALL)) {
            ResultView.printAllResult(ladderResult);
            return true;
        }
        ResultView.printPersonResult(ladderResult.get(name));
        return false;
    }
}
