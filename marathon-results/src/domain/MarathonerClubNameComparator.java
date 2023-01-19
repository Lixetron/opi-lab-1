package domain;

import java.util.Comparator;

public class MarathonerClubNameComparator implements Comparator<Marathoner> {
    @Override
    public int compare(Marathoner o1, Marathoner o2) {
        return o1.getClubName().compareTo(o2.getClubName());
    }
}
