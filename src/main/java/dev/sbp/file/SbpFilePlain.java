package dev.sbp.file;

import com.intellij.psi.FileViewProvider;
import com.intellij.psi.impl.source.PsiPlainTextFileImpl;

public class SbpFilePlain extends PsiPlainTextFileImpl {
    public SbpFilePlain(FileViewProvider viewProvider) {
        super(viewProvider);
    }
}
