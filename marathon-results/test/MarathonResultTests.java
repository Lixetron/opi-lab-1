import domain.Marathoner;
import domain.Utility;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MarathonResultTests {
    List<Marathoner> marathoners;

    @BeforeEach
    public void init() {
        marathoners = new ArrayList<>();
        Arrays.stream(Utility.MARATHONERS_STRINGS).map(marathonerString -> marathonerString.split("\\s+"))
                .forEach(marathonerStringsData -> {
                    Marathoner marathoner = new Marathoner();
                    marathoner.setNumber(Integer.parseInt(marathonerStringsData[0]));
                    marathoner.setSurname(marathonerStringsData[1]);
                    marathoner.setName(marathonerStringsData[2]);
                    marathoner.setPatronymic(marathonerStringsData[3]);
                    marathoner.setStartTime(LocalTime.parse(marathonerStringsData[4]));
                    marathoner.setFinishTime(LocalTime.parse(marathonerStringsData[5]));
                    IntStream.range(6, marathonerStringsData.length)
                            .forEach(i -> marathoner.setClubName(marathoner.getClubName() != null
                                    ? "%s %s".formatted(marathoner.getClubName(), marathonerStringsData[i])
                                    : marathonerStringsData[i]));
                    marathoners.add(marathoner);
                });
    }

    @AfterEach
    public void clear() {
        marathoners.clear();
    }

    @Test
    public void bestTimeTest() {
        Assertions.assertEquals(Duration.ofSeconds(LocalTime.parse("02:01:09").toSecondOfDay()),
                Utility.bestResult(marathoners));
    }

    @Test
    public void bestTimeNotBestTest() {
        Assertions.assertNotEquals(Duration.ZERO, Utility.bestResult(marathoners));
    }

    @Test
    public void bestTimeNull() {
        marathoners.clear();
        Assertions.assertNull(Utility.bestResult(marathoners));
    }
}
