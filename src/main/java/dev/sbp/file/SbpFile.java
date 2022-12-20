//package dev.sbp.file;
//
//import com.intellij.lang.Language;
//import com.intellij.navigation.ItemPresentation;
//import com.intellij.openapi.fileTypes.FileType;
//import com.intellij.openapi.util.TextRange;
//import com.intellij.psi.FileViewProvider;
//import com.intellij.psi.PsiElement;
//import com.intellij.psi.PsiElementVisitor;
//import com.intellij.psi.impl.PsiFileEx;
//import com.intellij.psi.impl.PsiManagerImpl;
//import com.intellij.psi.impl.file.PsiBinaryFileImpl;
//import com.intellij.psi.impl.source.PsiFileWithStubSupport;
//import com.intellij.psi.stubs.StubTree;
//import dev.sbp.language.SbpLanguage;
//import org.jetbrains.annotations.NonNls;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//import javax.swing.*;
// TODO: editable sbp file
//public class SbpFile extends PsiBinaryFileImpl implements PsiFileWithStubSupport, PsiFileEx {
//    public SbpFile(@NotNull PsiManagerImpl manager, @NotNull FileViewProvider viewProvider) {
//        super(manager, viewProvider);
//        System.out.println(this);
//    }
//
//    @Override
//    public TextRange getTextRange() {
//        return TextRange.EMPTY_RANGE;
//    }
//
//    @Override
//    public boolean isContentsLoaded() {
//        return true;
//    }
//
//    @Override
//    public int getTextLength() {
//        return 0;
//    }
//
//    @Override
//    public int getStartOffsetInParent() {
//        return 0;
//    }
//
//    @Override
//    public @NotNull Language getLanguage() {
//        return SbpLanguage.INSTANCE;
//    }
//
//    @Override
//    public @NotNull FileType getFileType() {
//        return SbpFileType.INSTANCE;
//    }
//
//    @Override
//    public PsiElement @NotNull [] getChildren() {
//        System.out.println("accessing children");
//        return super.getChildren();
//    }
//
//    @Override
//    public void accept(@NotNull PsiElementVisitor visitor) {
//        System.out.println("accepting");
//        super.accept(visitor);
//    }
//
//    @Override
//    public @NonNls String toString() {
//        return "SbpFile:" + getName();
//    }
//
//    @Override
//    public @Nullable StubTree getStubTree() {
//        return null;
//    }
//}
