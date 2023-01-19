package domain;

import java.util.Comparator;

public class MarathonerTimeComparator implements Comparator<Marathoner> {

    @Override
    public int compare(Marathoner o1, Marathoner o2) {
        return o1.getDurationRun().compareTo(o2.getDurationRun());
    }
}
