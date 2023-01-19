package domain;

import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

@Data
public class Marathoner {
    private int number;
    private String surname;
    private String name;
    private String patronymic;
    private LocalTime startTime;
    private LocalTime finishTime;
    private String clubName;

    public Duration getDurationRun() {
        return Duration.between(this.getStartTime(), this.getFinishTime());
    }
}
