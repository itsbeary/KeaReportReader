package net.kealands;
import net.kealands.keacore.analytics.ServerAnalytics;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;

public class Main {

    private static final HashSet<ServerAnalytics> analytics = new HashSet<>();

    public static void main(String[] args) {
        File[] files = new File("C:\\Users\\Beary\\Desktop\\kealands_server\\plugins\\KeaCore\\reports").listFiles();
        if(files == null) {
            System.out.println("Cannot find files!");
            return;
        }
        for(File file : files) {
            String fileName = file.getPath();
            try (FileInputStream fos = new FileInputStream(fileName)) {
                ObjectInputStream oos = new ObjectInputStream(fos);
                analytics.add((ServerAnalytics) oos.readObject());
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        read();
    }
    private static void read() {
        ServerAnalytics first = analytics.stream().toList().get(0);
        System.out.println(first.getAverageSession()); // in millis
        System.out.println(first.getCommandCount()); // commands
        System.out.println(first.getEntityDeaths()); // mob deaths
        System.out.println(first.getTotalLogins());
    }
}