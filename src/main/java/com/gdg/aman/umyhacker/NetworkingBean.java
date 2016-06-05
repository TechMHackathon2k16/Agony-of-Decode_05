package com.gdg.aman.umyhacker;

import java.io.Serializable;

/**
 * Created by MANOJ on 03-06-2016.
 */
public class NetworkingBean implements Serializable {

    private int networkingBeanImages;
    private String networkingBeanName;

    public NetworkingBean(int networkingBeanImages, String networkingBeanName)
    {
        this.networkingBeanImages = networkingBeanImages;
        this.networkingBeanName = networkingBeanName;
    }

    public int getNetworkingBeanImages()
    {
        return networkingBeanImages;
    }

    public void setNetworkingBeanImages(int networkingBeanImages)
    {
        this.networkingBeanImages = networkingBeanImages;
    }

    public String getNetworkingBeanName()
    {
        return networkingBeanName;
    }

    public void setNetworkingBeanName(String networkingBeanName)
    {
        this.networkingBeanName = networkingBeanName;
    }
}
