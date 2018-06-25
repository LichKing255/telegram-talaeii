package org.telegram.messenger.exoplayer2.upstream;

import org.telegram.messenger.exoplayer2.upstream.DataSource.Factory;

public final class FileDataSourceFactory implements Factory {
    private final TransferListener<? super FileDataSource> listener;

    public FileDataSourceFactory() {
        this(null);
    }

    public FileDataSourceFactory(TransferListener<? super FileDataSource> transferListener) {
        this.listener = transferListener;
    }

    public DataSource createDataSource() {
        return new FileDataSource(this.listener);
    }
}
