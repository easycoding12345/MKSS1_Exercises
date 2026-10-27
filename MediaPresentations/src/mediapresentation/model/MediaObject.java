package mediapresentation.model;

/** Component : interface commune aux objets simples (feuilles) et complexes (composites). */
public interface MediaObject {
    void play(int indent);

    default void play() {
        play(0);
    }
}