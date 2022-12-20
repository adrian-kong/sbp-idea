package dev.sbp.decompiler;

import com.intellij.openapi.fileTypes.BinaryFileDecompiler;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;

public class SbpDecompiler implements BinaryFileDecompiler {
    @Override
    public @NotNull CharSequence decompile(@NotNull VirtualFile file) {
        return "todo:";
    }
}
