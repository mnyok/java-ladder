package ladder.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LadderRunResult implements Iterable<Map.Entry<Name, String>> {
    private final List<Map.Entry<Name, String>> list = new ArrayList<>();

    public void add(Name name, String value) {
        list.add(new AbstractMap.SimpleEntry<>(name, value));
    }

    @Override
    public Iterator<Map.Entry<Name, String>> iterator() {
        return list.iterator();
    }

    public List<String> get(Name name) {
        return list.stream()
                .filter(entry -> entry.getKey().equals(name))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
