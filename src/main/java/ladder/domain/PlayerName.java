package ladder.domain;

import java.util.Objects;

public class PlayerName {
    private static final String NAME_CONTAIN_SPACE_ERROR = "이름 공백 포함 오류";
    private static final String NAME_LENGTH_ERROR = "이름 길이 5초과 오류";
    private static final String EMPTY_NAME_ERROR = "빈 이름 오류";
    private static final String WHITE_SPACE = " ";
    private static final int NAME_UPPER_BOUND = 5;
    private static final int NAME_LOWER_BOUND = 0;
    private String name;

    public PlayerName(String name) {
        checkEmptyName(name);
        checkNameLength(name);
        checkNameContainSpace(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkEmptyName(String name) {
        if (name.length() == NAME_LOWER_BOUND) {
            throw new IllegalArgumentException(EMPTY_NAME_ERROR);
        }
    }

    private void checkNameLength(String name) {
        if (name.length() > NAME_UPPER_BOUND) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR);
        }
    }

    private void checkNameContainSpace(String name) {
        if(name.contains(WHITE_SPACE)){
            throw new IllegalArgumentException(NAME_CONTAIN_SPACE_ERROR);
        }
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerName)) return false;
        PlayerName that = (PlayerName) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return String.format("%6s",this.name);
    }
}
