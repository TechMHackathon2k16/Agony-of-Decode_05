package com.gdg.aman.umyhacker;

import java.io.Serializable;

/**
 * Created by MANOJ on 02-06-2016.
 */
public class UmyhackerPojo implements Serializable {

    /*private int images;
    private String name;

    public UmyhackerPojo(int images, String name)
    {
        this.images = images;
        this.name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    private int image1;
    private String name1;
    private int image2;
    private String name2;

    public UmyhackerPojo(int image1, String name1, int image2, String name2)
    {
        this.image1 = image1;
        this.name1 = name1;
        this.image2 = image2;
        this.name2 = name2;
    }

    public int getImage1() {
        return image1;
    }

    public void setImage1(int image1) {
        this.image1 = image1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public int getImage2() {
        return image2;
    }

    public void setImage2(int image2) {
        this.image2 = image2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }
}
