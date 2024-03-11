package excercise.userlog;

import javax.swing.plaf.SpinnerUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    /**
     * Suppose we have an unsorted log file of accesses to web resources. Each log entry consists of an access time,
     * the ID of the user making the access, and the resource ID.
     *
     * The access time is represented as seconds since 00:00:00, and all times are assumed to be in the same day.
     *
     * We would like to compute user sessions, specifically:
     * write a function that takes the logs and returns a
     * data structure that associates to each user their earliest and latest access times.
     */

    public static void main(String[] argv) {
        String[][] logs = new String[][] {
                { "58523", "user_1", "resource_1" },
                { "62314", "user_2", "resource_2" },
                { "54001", "user_1", "resource_3" },
                { "200", "user_6", "resource_5" },
                { "215", "user_6", "resource_4" },
                { "54060", "user_2", "resource_3" },
                { "53760", "user_3", "resource_3" },
                { "58522", "user_22", "resource_1" },
                { "53651", "user_5", "resource_3" },
                { "2", "user_6", "resource_1" },
                { "100", "user_6", "resource_6" },
                { "400", "user_7", "resource_2" },
                { "100", "user_8", "resource_6" },
                { "54359", "user_1", "resource_3"},
        };

        getUserSession(logs)
                .stream()
                .forEach(userSession -> System.out.println(userSession.toString()));
    }

    public static List<UserSession> getUserSession(String[][] logs) {
        final HashMap<String,List<Integer>> sessionsPerUser = new HashMap<>();

        for (final String[] log : logs) {
            String userId = log[1];
            int session = Integer.valueOf(log[0]);

            if (sessionsPerUser.containsKey(userId)) {
                sessionsPerUser.get(userId).add(Integer.valueOf(log[0]));
            } else {
                sessionsPerUser.put(userId, new ArrayList<>() {{
                    add(session);
                }});
            }
        }

        return sessionsPerUser.keySet()
                .stream()
                .map(s -> new UserSession(s, sessionsPerUser.get(s)))
                .collect(Collectors.toList());
    }
}
