package go.azabelin.homework1;

import java.util.Random;

public class ParticipantFactory {
    private static final Random rnd = new Random();

    public ParticipantFactory() {
    }

    public Participant getParticipant(ParticipantType pType, String name) {
        switch (pType) {
            case HUMAN:
                return new Human(name, rnd.nextInt(10), rnd.nextInt(100));
            case ROBOT:
                return new Robot(name, rnd.nextInt(10), rnd.nextInt(100));
            case CAT:
                return new Cat(name, rnd.nextInt(10), rnd.nextInt(100));
        }
        return null;
    }
}
