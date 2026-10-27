package mediapresentation.model.simple;

import mediapresentation.model.MediaObject;
import mediapresentation.util.Indentation;

/** Leaf. */
public class Text implements MediaObject {
    private final String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public void play(int indent) {
        System.out.println(Indentation.of(indent) + "displaying text: " + text);
    }
}