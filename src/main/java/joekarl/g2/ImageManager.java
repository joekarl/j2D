/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package joekarl.g2;

import java.awt.Image;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author karl_ctr_kirch
 */
public class ImageManager {

    private static ImageManager instance = null;

    public static ImageManager getInstance() {
        if (instance == null) {
            instance = new ImageManager();
        }
        return instance;
    }
    private Map<String, Image> imageCache = new HashMap<String, Image>();

    private ImageManager() {
    }

    public Image loadImage(String resourceName) {
        if (imageCache.containsKey(resourceName)) {
            return imageCache.get(resourceName);
        }
        URL resource = getClass().getClassLoader().getResource(resourceName);
        Image image = new ImageIcon(resource).getImage();
        if (image != null) {
            imageCache.put(resourceName, image);
        }
        return image;
    }

    public Image getImage(String resourceName) {
        return imageCache.get(resourceName);
    }

    public void clearImage(String resourceName) {
        imageCache.remove(resourceName);
    }

    public void clearCache() {
        imageCache.clear();
    }
}
