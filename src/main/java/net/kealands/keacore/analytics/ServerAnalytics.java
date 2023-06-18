package net.kealands.keacore.analytics;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;

@Getter
public class ServerAnalytics implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private HashSet<Long> sessions;
    private HashMap<String, Integer> entityDeaths;
    private HashMap<String, Integer> commandCount;
    private int totalLogins;
    private int discordSize;
    private int averageSession;

}
