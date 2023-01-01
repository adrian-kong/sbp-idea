package dev.sbp.language;

import com.intellij.json.JsonParserDefinition;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IFileElementType;
import dev.sbp.file.BinaryVirtualFile;
import dev.sbp.file.SbpFile;
import dev.sbp.file.SbpFileType;
import dev.sbp.provider.BinarySingleRootFileViewProvider;
import org.jetbrains.annotations.NotNull;

public class BinaryParserDefinition extends JsonParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(SbpLanguage.INSTANCE);

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider provider) {
        var bfile = new BinaryVirtualFile(provider.getVirtualFile());
        var hookedProvider = new BinarySingleRootFileViewProvider(provider.getManager(), bfile);
        return hookedProvider.createFile(bfile, bfile.getFileType(), SbpLanguage.INSTANCE);
    }


    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

}
