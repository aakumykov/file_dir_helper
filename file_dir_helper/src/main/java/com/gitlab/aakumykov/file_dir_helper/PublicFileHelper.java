package com.gitlab.aakumykov.file_dir_helper;

import android.os.Environment;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PublicFileHelper {

    public static List<File> listFilesInDownloads() {

        final File[] files = publicDownloadsDir().listFiles();

        if (null == files)
            return new ArrayList<>();

        return Arrays.asList(files);
    }

    public static List<File> listFilesInDownloads(final @NonNull String fileExtension) {

        final File[] files = publicDownloadsDir().listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(fileExtension.toLowerCase());
            }
        });

        if (null == files)
            return new ArrayList<>();

        return Arrays.asList(files);
    }


    private static File publicDownloadsDir() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    }
}
