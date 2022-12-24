package dev.sbp.file;

import com.intellij.openapi.fileEditor.impl.FileEditorManagerImpl;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.util.NlsSafe;
import com.intellij.openapi.vfs.LocalFileSystem;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileSystem;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BinaryVirtualFile extends VirtualFile implements DumbAware {

    public static final String PATH_PREFIX = "bined://";

    private final VirtualFile parentFile;
    private final String displayName;

    private BinaryVirtualFile editorFile;
    private boolean closed = false;

    public BinaryVirtualFile(VirtualFile parentFile) {
        if (parentFile.getPath().startsWith(PATH_PREFIX)) {
            this.parentFile = LocalFileSystem.getInstance().findFileByPath(parentFile.getPath().substring(PATH_PREFIX.length()));
        } else {
            this.parentFile = parentFile;
        }
        String path = parentFile.getPath();
        int lastIndexOf = path.lastIndexOf('/');
        if (lastIndexOf >= 0) {
            this.displayName = path.substring(lastIndexOf + 1);
        } else {
            this.displayName = "";
        }
    }

    @NotNull
    @Override
    public String getName() {
        return parentFile.getName();
    }

    public String getDisplayName() {
        return displayName;
    }

    @NotNull
    @Override
    public VirtualFileSystem getFileSystem() {
        return BinaryVirtualFileSystem.getInstance();
    }

    @NotNull
    @Override
    public String getPath() {
        return PATH_PREFIX + parentFile.getPath();
    }

    @Override
    public boolean isWritable() {
        return parentFile.isWritable();
    }

    @Override
    public boolean isDirectory() {
        return parentFile.isDirectory();
    }

    @Override
    public boolean isValid() {
        return parentFile.isValid();
    }

    @Override
    public VirtualFile getParent() {
        return parentFile.getParent();
    }

    @Override
    public VirtualFile[] getChildren() {
        return parentFile.getChildren();
    }

    @NotNull
    @Override
    public OutputStream getOutputStream(Object requester, long newModificationStamp, long newTimeStamp) throws IOException {
        return parentFile.getOutputStream(requester, newModificationStamp, newTimeStamp);
    }

    @NotNull
    @Override
    public byte[] contentsToByteArray() throws IOException {
        return parentFile.contentsToByteArray();
    }

    @Override
    public long getTimeStamp() {
        return parentFile.getTimeStamp();
    }

    @Override
    public long getLength() {
        return parentFile.getLength();
    }

    @Override
    public void refresh(boolean asynchronous, boolean recursive, @Nullable Runnable postRunnable) {
        parentFile.refresh(asynchronous, recursive, postRunnable);
    }

    @NotNull
    @Override
    public InputStream getInputStream() throws IOException {
        return parentFile.getInputStream();
    }

    public long getModificationStamp() {
        return parentFile.getModificationStamp();
    }

    @Override
    public long getModificationCount() {
        return parentFile.getModificationCount();
    }

    @Override
    public boolean equals(@Nullable Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return getPath().equals(((BinaryVirtualFile) o).getPath());
    }

    @Override
    public int hashCode() {
        return getPath().hashCode();
    }

    public boolean isMoved() {
        Boolean closingToReopen = getUserData(FileEditorManagerImpl.CLOSING_TO_REOPEN);
        return closingToReopen != null && closingToReopen;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}
