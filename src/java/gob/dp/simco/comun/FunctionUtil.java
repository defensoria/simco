/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.dp.simco.comun;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import javax.servlet.http.Part;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author carlos
 */
public class FunctionUtil {
    
    private static final Logger log = Logger.getLogger(FunctionUtil.class);
    
    public static String uploadArchive(Part fil) {
            String nameArchive = getFilename(fil);
            String extencion = getFileExtension(getFilename(fil));
            if (StringUtils.isNoneBlank(nameArchive)) {
                String formato = RandomStringUtils.random(32, 0, 20, true, true, "qw32rfHIJk9iQ8Ud7h0X".toCharArray());
                String ruta = formato + extencion;
                File file = new File(ConstantesUtil.FILE_SYSTEM + ruta);
                try (InputStream input = fil.getInputStream()) {
                    Files.copy(input, file.toPath());
                } catch (IOException ex) {
                    log.error(ex);
                }
                return ruta;
            }
        return null;
    }
    
    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf("=") + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1);
            }
        }
        return null;
    }

    private static String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf("."));
        } catch (Exception e) {
            return "";
        }
    }
    
    public static final double redondear( double numero, int decimales ) {
        return Math.round(numero*Math.pow(10,decimales))/Math.pow(10,decimales);
    }
    
}
