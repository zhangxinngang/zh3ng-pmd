package com.zh3ng.club.pmd.custom.version;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * @author zhangxingang
 * @created on 2020-06-29
 */
public class VersionManager {
    private static String VERSION_PROP_FILE = "/version.prop";

    public String getVersion(){
        InputStream stream = getClass().getResourceAsStream(VERSION_PROP_FILE);
        if (stream == null){
            return null;
        }

        Properties props = new Properties();
        try {
            props.load(stream);
            stream.close();
            return (String) props.get("version");
        } catch (IOException e) {
            return null;
        }
    }
}
