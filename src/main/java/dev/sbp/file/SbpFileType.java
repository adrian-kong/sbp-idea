package dev.sbp.file;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import dev.sbp.language.SbpLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class SbpFileType extends LanguageFileType {

    public static final SbpFileType INSTANCE = new SbpFileType();

    protected SbpFileType() {
        super(SbpLanguage.INSTANCE);
    }

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
}
