package org.telegram.messenger.exoplayer2.upstream;

import org.telegram.messenger.exoplayer2.upstream.DataSource.Factory;
import org.telegram.messenger.exoplayer2.util.PriorityTaskManager;

public final class PriorityDataSourceFactory implements Factory {
    private final int priority;
    private final PriorityTaskManager priorityTaskManager;
    private final Factory upstreamFactory;

    public PriorityDataSourceFactory(Factory factory, PriorityTaskManager priorityTaskManager, int i) {
        this.upstreamFactory = factory;
        this.priorityTaskManager = priorityTaskManager;
        this.priority = i;
    }

    public PriorityDataSource createDataSource() {
        return new PriorityDataSource(this.upstreamFactory.createDataSource(), this.priorityTaskManager, this.priority);
    }
}
