package v2.push;

public interface BroadCastListener<T> {

    void onMessage(T message);
}
