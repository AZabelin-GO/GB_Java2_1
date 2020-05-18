package go.azabelin.homework1;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    private static final Random rnd = new Random();

    private static final String[] names = {"Bella", "Simba", "Chloe", "Luna", "Max", "Lucy", "Lily", "John", "David", "Bender"};

    private static ArrayList<Participant> participants = new ArrayList<>();
    private static ArrayList<Obstacle> obstacles = new ArrayList<>();

    public static void init(int participantCount, int obstaclesCount) {

        ParticipantFactory participantFactory = new ParticipantFactory();

        for (int i = 0; i < participantCount; i++) {
            switch (rnd.nextInt(3)) {
                case 0:
                    participants.add(participantFactory.getParticipant(ParticipantType.HUMAN, names[rnd.nextInt(names.length)]));
                    break;
                case 1:
                    participants.add(participantFactory.getParticipant(ParticipantType.ROBOT, names[rnd.nextInt(names.length)]));
                    break;
                case 2:
                    participants.add(participantFactory.getParticipant(ParticipantType.CAT, names[rnd.nextInt(names.length)]));
                    break;
            }
        }

        for (int i = 0; i < obstaclesCount; i++) {
            switch (rnd.nextInt(2)) {
                case 0:
                    obstacles.add(new Threadmill(rnd.nextInt(100)));
                    break;
                case 1:
                    obstacles.add(new Wall(rnd.nextInt(10)));
                    break;
            }
        }
    }

    public static void main(String[] args) {
        init(rnd.nextInt(10) + 1, rnd.nextInt(10) + 1);
        System.out.println("Participants: " + participants.size());
        System.out.println("Obstacles: " + obstacles.size());

        System.out.println();

        for (Participant participant: participants) {
            participant.enterArena();

            for (Obstacle obstacle: obstacles) {
                if (obstacle.getType() == ObstacleType.THREADMILL) {
                    if (!participant.run(obstacle.getValue())) {
                        break;
                    }
                } else if(obstacle.getType() == ObstacleType.WALL) {
                    if (!participant.jump(obstacle.getValue())) {
                        break;
                    }
                }
            }
            System.out.println();
        }
    }
}
