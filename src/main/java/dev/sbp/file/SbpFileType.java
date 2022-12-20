package dev.sbp.file;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SbpFileType implements FileType {

    public static final SbpFileType INSTANCE = new SbpFileType();

    @Override
    public @NonNls @NotNull String getName() {
        return "SBP";
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return "Swift Binary Protocol";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return "sbp";
    }

    @Override
    public @Nullable Icon getIcon() {
        return null;
    }

    @Override
    public boolean isBinary() {
        return true;
    }

}
