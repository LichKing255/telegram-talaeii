package org.telegram.messenger.exoplayer2.source.chunk;

import java.util.List;

public interface ChunkSource {
    void getNextChunk(MediaChunk mediaChunk, long j, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j, List<? extends MediaChunk> list);

    void maybeThrowError();

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z, Exception exception);
}
