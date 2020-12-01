package bean;

import java.util.Objects;

public class Group {
    private long groupId;
    private String name;

    public Group() {
    }

    public Group(long groupId, String name) {
        this.groupId = groupId;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Group)) {
            return false;
        }
        Group group = (Group) o;
        return groupId == group.groupId;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", name='" + name + '\'' +
                '}';
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
