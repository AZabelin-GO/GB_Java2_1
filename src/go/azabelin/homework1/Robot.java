package go.azabelin.homework1;

public class Robot implements Participant{
    private String name;
    private int jumpLimit;
    private int runLimit;

    public Robot(String name, int jumpLimit, int runLimit) {
        this.name = name;
        this.jumpLimit = jumpLimit;
        this.runLimit = runLimit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpLimit() {
        return jumpLimit;
    }

    public void setJumpLimit(int jumpLimit) {
        this.jumpLimit = jumpLimit;
    }

    public int getRunLimit() {
        return runLimit;
    }

    public void setRunLimit(int runLimit) {
        this.runLimit = runLimit;
    }

    @Override
    public void enterArena() {
        System.out.println("Robot " + this.name + " enters the arena");
    }

    @Override
    public boolean run(int distance) {
        if (distance > this.runLimit) {
            System.out.println("Robot " + this.name + " was not able to run " + distance + " meter(s) and leaves the arena");
            return false;
        } else {
            System.out.println("Robot " + this.name + " successfully ran " + distance + " meter(s)");
        }
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (height > this.jumpLimit) {
            System.out.println("Robot " + this.name + " was not able to jump " + height + " meter(s) and leaves the arena");
            return false;
        } else {
            System.out.println("Robot " + this.name + " successfully jumped " + height + " meter(s)");
        }
        return true;
    }
}
