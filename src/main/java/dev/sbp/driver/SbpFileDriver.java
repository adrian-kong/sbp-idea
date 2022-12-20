package dev.sbp.driver;

import com.swiftnav.sbp.client.SBPDriver;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SbpFileDriver implements SBPDriver {

    private final byte[] content;

    private int offset;

    public SbpFileDriver(byte[] content) {
        this.content = content;
    }

    @Override
    public byte[] read(int len) throws IOException {
        if (offset >= 0 && offset + len < content.length) {
            byte[] slice = Arrays.copyOfRange(content, offset, offset + len);
            offset += len;
            return slice;
        }
        throw new IOException("eof");
    }

    @Override
    public void write(byte[] data) throws IOException {
        // TODO: write data
        throw new IOException("read only IO");
    }
}
