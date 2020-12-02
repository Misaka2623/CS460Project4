package dao;

import bean.Member;

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

    /**
     * insert a line of specified member object into the table. the id field of the specified member is not filled,
     * so to implement this method should find the appropriate id of this member.
     *
     * @param member the member that should be inserted.
     * @return the id of the member.
     */
    long insert(Member member);
}
