package dao;

public interface MemberDao {
    /**
     * check whether the given username and password is in the member table.
     *
     * @param username the username
     * @param password the password (encrypted)
     * @return {@code true} if the username and password pair is in the member table; {@code false} otherwise.
     */
    boolean checkUsernameAndPassword(String username, String password);
}
