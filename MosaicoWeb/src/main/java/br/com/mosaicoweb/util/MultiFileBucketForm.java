package br.com.mosaicoweb.util;

import java.util.ArrayList;
import java.util.List;

public class MultiFileBucketForm {
	List<FileBucket> files = new ArrayList<FileBucket>();
        
    public List<FileBucket> getFiles() {
        return files;
    }
 
    public void setFiles(List<FileBucket> files) {
        this.files = files;
    }
}
