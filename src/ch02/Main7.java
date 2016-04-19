package ch02;

import java.io.IOException;
import java.nio.file.*;

/**
 * Created by Shotaro.S on 2015/12/28.
 */
public class Main7 {

    public static void main(String[] args) throws IOException {

        WatchService ws = FileSystems.getDefault().newWatchService();
        Path p = Paths.get("C:\\temp");
        WatchKey register = p.register(ws,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_MODIFY,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.OVERFLOW);
        while(true){
            try {
                WatchKey key = ws.take();
                for(WatchEvent<?> ev : key.pollEvents()){
                    if(ev.kind() == StandardWatchEventKinds.OVERFLOW){
                        key.reset();
                        continue;
                    }
                    System.out.println(ev.count() + " " + ev.kind() + " " + ev.context());
                    if(!key.reset()){
                        key.reset();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}
