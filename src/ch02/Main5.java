package ch02;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;

/**
 * Created by Shotaro.S on 2015/12/28.
 */
public class Main5 {

    public static void main(String[] args) throws IOException {

        Path p = Paths.get("src\\ch02\\fl.txt");
        List<String> lines = Files.readAllLines(p);
        lines.parallelStream().forEach(System.out::println);

        FileTime lastModifiedTime = Files.getLastModifiedTime(p);
        o(lastModifiedTime);
        UserPrincipal owner = Files.getOwner(p);
        o(owner);
        long size = Files.size(p);
        o(size);

        OperatingSystemMXBean mxBean = ManagementFactory.getOperatingSystemMXBean();
        String osname = mxBean.getName();
        o(osname);
        o(mxBean.getArch());
        o(mxBean.getAvailableProcessors());
        o(mxBean.getSystemLoadAverage());
        o(mxBean.getVersion());
        o(mxBean.getObjectName());

    }

    private static void o(Object o){
        System.out.println(o);
    }

}
