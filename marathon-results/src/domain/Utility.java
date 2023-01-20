package domain;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Utility {
    public static final String[] MARATHONERS_STRINGS = {"5 Иванов Иван Иванович 09:00:00 11:53:23 \"Спартак\"",
            "6 Петров Пётр Петрович 09:00:00 11:02:24 \"Селестина\"",
            "7 Клавдеев Пётр Петрович 09:00:00 11:51:56 \"БелСпорт\"",
            "1 Петров Дмитрий Петрович 09:00:00 11:02:28 \"Кольт\"",
            "3 Сидоров Сидор Сидорович 09:00:00 11:28:32 \"Спартак\"",
            "9 Алексеев Иван Иванович 09:00:00 11:32:09 \"Селестина\"",
            "8 Смирнов Иван Иванович 09:00:00 11:01:09 \"Спартак\"",
            "4 Петров Иван Петрович 09:00:00 11:15:01 \"Кольт\"",
            "2 Арешкин Пётр Петрович 09:00:00 11:45:00 \"БелСпорт\""};

    public static Duration bestResult(List<Marathoner> marathoners) {
        if (!marathoners.isEmpty()) {
            Duration best = ChronoUnit.FOREVER.getDuration();
            for (Marathoner marathoner : marathoners) {
                if (marathoner.getDurationRun().compareTo(best) < 0) {
                    best = marathoner.getDurationRun();
                }
            }
            return best;
        }
        return null;
    }
}
