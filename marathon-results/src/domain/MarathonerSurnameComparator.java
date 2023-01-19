package domain;

import java.util.Comparator;

public class MarathonerSurnameComparator implements Comparator<Marathoner> {
    @Override
    public int compare(Marathoner o1, Marathoner o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
