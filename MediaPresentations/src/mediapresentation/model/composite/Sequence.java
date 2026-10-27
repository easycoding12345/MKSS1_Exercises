package mediapresentation.model.composite;

import mediapresentation.model.MediaObject;

/** Composite. */
public class Sequence extends CompositeMedia {
    public Sequence(MediaObject... objects) {
        super(objects);
    }

    @Override
    protected String message() {
        return "playing in sequence";
    }
}