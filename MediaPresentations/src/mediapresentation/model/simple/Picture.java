package mediapresentation.model.simple;

import mediapresentation.model.MediaObject;
import mediapresentation.util.Indentation;

/** Leaf. */
public class Picture implements MediaObject {
    private final int number;

    public Picture(int number) {
        this.number = number;
    }

    @Override
    public void play(int indent) {
        System.out.println(Indentation.of(indent) + "showing picture no. " + number);
    }
}