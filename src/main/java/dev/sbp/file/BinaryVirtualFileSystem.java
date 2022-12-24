package dev.sbp.file;

import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.vfs.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BinaryVirtualFileSystem extends VirtualFileSystem implements DumbAware {

    private static final String PROTOCOL = "sbpbin";
    private static final String ERROR_INVALID_OPERATION = "Invalid operation";
    private static final BinaryVirtualFileSystem INSTANCE = new BinaryVirtualFileSystem();
    private final List<VirtualFileListener> fileListeners = new ArrayList<>();

    @NotNull
    public static BinaryVirtualFileSystem getInstance() {
        return INSTANCE;
    }

    @NotNull
    @Override
    public String getProtocol() {
        return PROTOCOL;
    }

    @Nullable
    @Override
    public VirtualFile findFileByPath(@NotNull String s) {
        return null;
    }

    @Override
    public void refresh(boolean b) {
    }

    @Nullable
    @Override
    public VirtualFile refreshAndFindFileByPath(String s) {
        return null;
    }

    @Override
    public void addVirtualFileListener(VirtualFileListener virtualFileListener) {
        fileListeners.add(virtualFileListener);
    }

    @Override
    public void removeVirtualFileListener(VirtualFileListener virtualFileListener) {
        fileListeners.remove(virtualFileListener);
    }

    @Override
    protected void deleteFile(Object o, VirtualFile virtualFile) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @Override
    protected void moveFile(Object o, VirtualFile virtualFile, VirtualFile virtualFile1) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @Override
    protected void renameFile(Object o, VirtualFile virtualFile, String s) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @NotNull
    @Override
    protected VirtualFile createChildFile(Object o, VirtualFile virtualFile, String s) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @NotNull
    @Override
    protected VirtualFile createChildDirectory(Object o, VirtualFile virtualFile, String s) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @NotNull
    @Override
    protected VirtualFile copyFile(Object o, VirtualFile virtualFile, VirtualFile virtualFile1, String s) throws IOException {
        throw new RuntimeException(ERROR_INVALID_OPERATION);
    }

    @Override
    public boolean isReadOnly() {
        return false;
    }
}