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

        Name name;
        do {
            name = InputView.inputShowResult();
            showResult(name, ladderResult);
        } while (!isEnd(name));
    }

    private static void showResult(Name name, Map<Name, String> ladderResult) {
        if (name.equals(ALL)) {
            ResultView.printAllResult(ladderResult);
            return;
        }
        ResultView.printPersonResult(ladderResult.get(name));
    }

    private static boolean isEnd(Name input) {
        return input.equals(ALL);
    }
}
