package mediapresentation.model.simple;

import mediapresentation.model.MediaObject;
import mediapresentation.util.Indentation;

/** Leaf. */
public class Video implements MediaObject {
    private final int number;

    public Video(int number) {
        this.number = number;
    }

    @Override
    public void play(int indent) {
        System.out.println(Indentation.of(indent) + "playing video no. " + number);
    }
}