package domain;

import lombok.Data;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Марафонец
 *
 * @author Dmitry Khlopchenko
 */
@Data
public class Marathoner {
    /**
     * Номер марафонца
     */
    private int number;
    /**
     * Фамилия марафонца
     */
    private String surname;
    /**
     * Имя марафонца
     */
    private String name;
    /**
     * Отчество марафонца
     */
    private String patronymic;
    /**
     * Время начало забега (марафона)
     */
    private LocalTime startTime;
    /**
     * Время окончание забега (марафона)
     */
    private LocalTime finishTime;
    /**
     * Название клуба, от которого выступает марафонец
     */
    private String clubName;

    /**
     * @return продолжительность забега (марафона)
     */
    public Duration getDurationRun() {
        return Duration.between(this.getStartTime(), this.getFinishTime());
    }
}
