package dev.sbp.file;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import dev.sbp.language.SbpLanguage;
import org.jetbrains.annotations.NotNull;

public class SbpFile extends PsiFileBase {

    public SbpFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SbpLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return SbpFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "SBP file";
    }
}
