package dev.sbp.decompiler;

import com.intellij.openapi.fileTypes.BinaryFileDecompiler;
import com.intellij.openapi.vfs.VirtualFile;
import com.swiftnav.sbp.client.SBPDriver;
import com.swiftnav.sbp.client.SBPFramer;
import dev.sbp.driver.SbpFileDriver;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class SbpDecompiler implements BinaryFileDecompiler {
    @Override
    public @NotNull CharSequence decompile(@NotNull VirtualFile file) {
        try {
            byte[] content = file.contentsToByteArray();
            SBPDriver driver = new SbpFileDriver(content);
            StringBuilder builder = new StringBuilder();
            new SBPFramer(driver).forEach(msg -> builder.append(msg.toJSON().toString()).append("\n"));
            return builder.toString();
        } catch (IOException ex) {
            return ex.toString();
        }
    }
}
