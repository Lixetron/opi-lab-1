import domain.Marathoner;
import domain.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MarathonResultTests {

    @Test
    public void bestTimeTest() {
        List<Marathoner> marathoners = new ArrayList<>();
        Arrays.stream(Utility.MARATHONERS_STRINGS).map(marathonerString -> marathonerString.split("\\s+"))
                .forEach(marathonerStringsData -> {
                    Marathoner marathoner = new Marathoner();
                    marathoner.setNumber(Integer.parseInt(marathonerStringsData[0]));
                    marathoner.setSurname(marathonerStringsData[1]);
                    marathoner.setName(marathonerStringsData[2]);
                    marathoner.setPatronymic(marathonerStringsData[3]);
                    marathoner.setStartTime(LocalTime.parse(marathonerStringsData[4]));
                    marathoner.setFinishTime(LocalTime.parse(marathonerStringsData[5]));
                    marathoner.setClubName(marathonerStringsData[6]);
                    marathoners.add(marathoner);
                });
        Duration bestTime = ChronoUnit.FOREVER.getDuration();
        for (Marathoner marathoner : marathoners) {
            if (marathoner.getDurationRun().compareTo(bestTime) < 0) {
                bestTime = marathoner.getDurationRun();
            }
        }
        Assertions.assertEquals(Duration.ofSeconds(LocalTime.parse("02:01:09").toSecondOfDay()), bestTime);
    }
}
