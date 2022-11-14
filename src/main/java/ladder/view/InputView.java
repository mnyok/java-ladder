package ladder.view;

import ladder.domain.Name;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public static List<Name> inputPeople() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");

        String peopleString = new Scanner(System.in).nextLine();
        return Arrays.stream(peopleString.split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public static List<String> inputResults() {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");

        String input = new Scanner(System.in).nextLine();
        return Arrays.stream(input.split(","))
                .collect(Collectors.toList());

    }

    public static int inputHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요.");

        int height;
        try {
            height =  new Scanner(System.in).nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.", e);
        }
        return height;
    }

    public static Name inputShowResult() {
        System.out.println("결과를 보고 싶은 사람은?");

        String name = new Scanner(System.in).next();
        return new Name(name);
    }
}
