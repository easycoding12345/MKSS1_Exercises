package mediapresentation.model.simple;

import mediapresentation.model.MediaObject;
import mediapresentation.util.Indentation;

/** Leaf. */
public class Music implements MediaObject {
    private final String title;

    public Music(String title) {
        this.title = title;
    }

    @Override
    public void play(int indent) {
        System.out.println(Indentation.of(indent) + "playing music: " + title);
    }
}