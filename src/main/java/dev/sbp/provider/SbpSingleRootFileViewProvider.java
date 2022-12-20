package dev.sbp.provider;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SingleRootFileViewProvider;
import com.intellij.psi.impl.PsiManagerImpl;
import dev.sbp.file.SbpFile;
import dev.sbp.file.SbpFileEx;
import dev.sbp.file.SbpFilePlain;
import dev.sbp.file.SbpFileType;
import dev.sbp.language.SbpLanguage;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class SbpSingleRootFileViewProvider extends SingleRootFileViewProvider {

    public SbpSingleRootFileViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile file) {
        super(manager, file);
    }

    @Override
    protected @NotNull PsiFile createFile(@NotNull VirtualFile file, @NotNull FileType fileType, @NotNull Language language) {
        return new SbpFilePlain(this);
    }
}
