package mediapresentation.model.composite;

import mediapresentation.model.MediaObject;
import mediapresentation.util.Indentation;

import java.util.ArrayList;
import java.util.List;

/** Composite abstrait : gère les enfants ; les sous-classes définissent le message de l'opérateur. */
public abstract class CompositeMedia implements MediaObject {
    protected final List<MediaObject> children = new ArrayList<>();

    protected CompositeMedia(MediaObject... objects) {
        for (MediaObject o : objects) {
            add(o);
        }
    }

    public CompositeMedia add(MediaObject o) {
        children.add(o);
        return this;
    }

    public CompositeMedia remove(MediaObject o) {
        children.remove(o);
        return this;
    }

    protected abstract String message();

    @Override
    public void play(int indent) {
        System.out.println(Indentation.of(indent) + message());
        for (MediaObject child : children) {
            child.play(indent + 1);
        }
    }
}