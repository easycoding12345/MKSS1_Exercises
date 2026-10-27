package mediapresentation.model.composite;

import mediapresentation.model.MediaObject;

/** Composite. */
public class Parallel extends CompositeMedia {
    public Parallel(MediaObject... objects) {
        super(objects);
    }

    @Override
    protected String message() {
        return "playing in parallel";
    }
}