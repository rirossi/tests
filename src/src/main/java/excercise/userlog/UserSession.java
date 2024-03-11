package excercise.userlog;

import java.util.List;

public class UserSession {
    final String userId;

    final int[] array = new int[2];
    UserSession(final String id, List<Integer> sessions) {
        this.userId = id;
        sessions.sort((o1, o2) -> o1 - o2);
        array[0] = sessions.get(0);
        array[1] = sessions.get(sessions.size() -1);
    }

    @Override
    public String toString() {
        return String.format("'%s': [%d, %d]", userId, array[0], array[1]);
    }

}
