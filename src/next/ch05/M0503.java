package next.ch05;

import next.Z;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Shotaro.S on 2016/03/08.
 */
public class M0503 {
    public static void main(String... args) {
        Z.p(LocalDateTime.now().toString());
        Z.p(LocalDateTime.now(ZoneId.of("Asia/Tokyo")).toString());
        Z.p(LocalDateTime.now(Clock.systemDefaultZone()).toString());
        Z.l();
        Z.s();

        Z.p(LocalDateTime.of(2016, 2, 29, 23, 59, 59).toString());
        Z.p(LocalDateTime.of(2015, Month.APRIL, 30, 19, 12).toString());
        Z.p(LocalDateTime.of(LocalDate.now(), LocalTime.now()).toString());
        LocalDateTime ldt1 = LocalDateTime.now();
        Z.p(LocalDateTime.from(ldt1).toString());
        Z.l();
        Z.s();

        LocalDateTime dt = LocalDateTime.now();

        int year = dt.getYear();
        Month month = dt.getMonth();
        int monthValue = dt.getMonthValue();
        int dayOfYear = dt.getDayOfYear();
        int dayOfMonth = dt.getDayOfMonth();
        DayOfWeek dayOfWeek = dt.getDayOfWeek();
        int hour = dt.getHour();
        int minute = dt.getMinute();
        int second = dt.getSecond();
        int nano = dt.getNano();
        Z.p(dt.toString());
        Z.p("Year:" + year + ", month:" + month.getValue() + ", monthValue:" + monthValue + ", dayOfYear:" + dayOfYear + ", dayOfMonth:" + dayOfMonth + ", dayOfWeek:" + dayOfWeek.getValue() + ", hour:" + hour + ", minute:" + minute + ", second:" + second + ", nano:" + nano);
        Z.l();
        Z.s();

        Z.p("firstDayOfMonth:  " + LocalDateTime.now().with(TemporalAdjusters.firstDayOfMonth()).toString());
        Z.p("firstDayOfNextMonth:  " + LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextMonth()).toString());
        Z.p("firstDayOfYear:  " + LocalDateTime.now().with(TemporalAdjusters.firstDayOfYear()).toString());
        Z.p("firstDayOfNextYear:  " + LocalDateTime.now().with(TemporalAdjusters.firstDayOfNextYear()).toString());
        Z.p("firstInMonth(DayOfWeek.SATURDAY):  " + LocalDateTime.now().with(TemporalAdjusters.firstInMonth(DayOfWeek.SATURDAY)).toString());
        Z.s();
        Z.p("lastDayOfMonth:  " + LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).toString());
        Z.p("lastDayOfYear:  " + LocalDateTime.now().with(TemporalAdjusters.lastDayOfYear()).toString());
        Z.p("lastInMonth(DayOfWeek.SUNDAY):  " + LocalDateTime.now().with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY)).toString());
        Z.s();
        Z.p("next(DayOfWeek.MONDAY):  " + LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY)).toString());
        Z.p("previous(DayOfWeek.WEDNESDAY):  " + LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.WEDNESDAY)).toString());
        Z.l();
        Z.s();

        LocalDateTime ldm = dt.with(TemporalAdjusters.lastDayOfMonth());
        Z.p(ldm.plusMonths(1).toString());
        Z.p(ldm.plusMonths(2).toString());
        Z.p(ldm.plusMonths(3).toString());
        Z.p(ldm.plusMonths(4).toString());
        Z.p(ldm.plusMonths(5).toString());
        Z.s();
        Z.p(ldm.minusMonths(1).toString());
        Z.l();
        Z.s();

        Z.p("BASIC_ISO_DATE:  "+ldm.format(DateTimeFormatter.BASIC_ISO_DATE));
        Z.p("ISO_DATE:  "+ldm.format(DateTimeFormatter.ISO_DATE));
        Z.p("ISO_DATE_TIME:  "+ldm.format(DateTimeFormatter.ISO_DATE_TIME));
        Z.p("ISO_LOCAL_DATE:  "+ldm.format(DateTimeFormatter.ISO_LOCAL_DATE));
        Z.p("ISO_LOCAL_DATE_TIME:  "+ldm.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        Z.p("ISO_LOCAL_TIME:  "+ldm.format(DateTimeFormatter.ISO_LOCAL_TIME));
        Z.p("ISO_ORDINAL_DATE:  "+ldm.format(DateTimeFormatter.ISO_ORDINAL_DATE));
        Z.p("ISO_TIME:  "+ldm.format(DateTimeFormatter.ISO_TIME));
        Z.p("ISO_WEEK_DATE:  "+ldm.format(DateTimeFormatter.ISO_WEEK_DATE));

    }
}
