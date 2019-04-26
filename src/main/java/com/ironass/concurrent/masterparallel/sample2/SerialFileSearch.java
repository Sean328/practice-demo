package com.ironass.concurrent.masterparallel.sample2;

import java.io.File;

/**
 * 串行搜索文件
 *
 * @author lixin
 * @date 2019-04-25 16:53
 **/
public class SerialFileSearch {

    public static void searchFiles(File file, String fileName, Result result) {
        File[] contents;
        contents = file.listFiles();
        if ((contents == null) || (contents.length == 0)) {
            return;
        }
        for (File content : contents) {
            if (content.isDirectory()) {
                searchFiles(content, fileName, result);
            } else {
                if (content.getName().equals(fileName)) {
                    result.setPath(content.getAbsolutePath());
                    result.setFound(true);
                    System.out.printf("Serial Search: Path: %s%n",
                            result.getPath());
                    return;
                }
            }
            if (result.isFound()) {
                return;
            }
        }
    }
}


