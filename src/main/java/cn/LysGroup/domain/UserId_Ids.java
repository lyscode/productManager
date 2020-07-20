package cn.LysGroup.domain;

import java.util.Arrays;
import java.util.List;

public class UserId_Ids {
    private int userId;
    private List<Integer> ids;

    @Override
    public String toString() {
        return "UserId_Ids{" +
                "userId=" + userId +
                ", ids=" + ids +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}
