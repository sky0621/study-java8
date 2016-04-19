package next.ch05;

import days.Z;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * Created by Shotaro.S on 2016/03/08.
 */
public class M0503b {
    public static void main(String... args){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy' 年 'MM' 月 'dd' 日 'HH' 時 'mm' 分 'ss' 秒 'XXX");

        Z.p(OffsetDateTime.now().format(fmt).toString());
        Z.l();
        Z.s();

        LocalDateTime now = LocalDateTime.now();
        Stream.of("M", "MM", "MMM", "MMMM", "MMMMM").forEach(p -> {
            DateTimeFormatter ja = DateTimeFormatter.ofPattern(p, Locale.JAPAN);
            DateTimeFormatter us = DateTimeFormatter.ofPattern(p, Locale.US);
            Z.p(p + "\t" + now.format(ja) + "\t" + now.format(us));
        });
        Z.l();
        Z.s();

        Z.p(JapaneseDate.of(2016, 3, 8).toString());

    }
}
