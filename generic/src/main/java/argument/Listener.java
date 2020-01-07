package argument;

/**
 * This method allows to specify more generic event type in concrete listeners
 */
public interface Listener<E extends Event> {

    void doOnEvent(E event);
}
