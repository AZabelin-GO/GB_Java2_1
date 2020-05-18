package go.azabelin.homework1;

public class Obstacle {
    private int value;
    private ObstacleType type;

    public Obstacle(int value, ObstacleType type) {
        this.value = value;
        this.type = type;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ObstacleType getType() {
        return type;
    }

    public void setType(ObstacleType type) {
        this.type = type;
    }
}
