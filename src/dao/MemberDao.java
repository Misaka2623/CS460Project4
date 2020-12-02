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

    /**
     * check whether the specified username is in the member table.
     *
     * @param username the username that should be checked.
     * @return {@code true} if there is a member's username that matches the specified username; {@code false}
     * otherwise.
     */
    boolean containsUsername(String username);
}
