package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.BmpReader;
import com.javarush.task.task16.task1631.common.ImageReader;
import com.javarush.task.task16.task1631.common.JpgReader;
import com.javarush.task.task16.task1631.common.PngReader;
import com.javarush.task.task16.task1631.common.ImageTypes;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) {
        if (imageTypes == imageTypes.JPG) {
            return new JpgReader();
        }
        if (imageTypes == imageTypes.PNG) {
            return new PngReader();
        }
        if (imageTypes == imageTypes.BMP) {
            return new BmpReader();
        } else {
            throw new IllegalArgumentException();
        }
    }
}
