package v2.push;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SuppressWarnings("serial")
public class BroadCaster implements Serializable {

    private static ExecutorService executorService = Executors.newSingleThreadExecutor();

    private static LinkedList<BroadCastListener<?>> listeners = new LinkedList<>();

    public static synchronized void register(BroadCastListener<?> listener) {
        listeners.add(listener);
    }

    public static synchronized void unregister(BroadCastListener<?> listener) {
        listeners.remove(listener);
    }

    public static synchronized void broadcast(final Object message) {
        for (final BroadCastListener listener : listeners) {
            executorService.execute(() -> listener.onMessage(message));
        }
    }

    public static synchronized void close() {
        if (!executorService.isShutdown() && !executorService.isTerminated()) {
            executorService.shutdownNow();
        }
    }
}
