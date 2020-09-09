package com.zc.editor.whole.pickvideo.callback;

import com.zc.editor.whole.pickvideo.beans.BaseFile;
import com.zc.editor.whole.pickvideo.beans.Directory;

import java.util.List;



public interface FilterResultCallback<T extends BaseFile> {
    void onResult(List<Directory<T>> directories);
}
