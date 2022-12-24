package dev.sbp.provider;

import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.SingleRootFileViewProvider;
import dev.sbp.file.SbpFile;
import org.jetbrains.annotations.NotNull;

public class BinarySingleRootFileViewProvider extends SingleRootFileViewProvider {

    public BinarySingleRootFileViewProvider(@NotNull PsiManager manager, @NotNull VirtualFile file) {
        super(manager, file);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull VirtualFile file, @NotNull FileType fileType, @NotNull Language language) {
        return new SbpFile(this);
    }
}
