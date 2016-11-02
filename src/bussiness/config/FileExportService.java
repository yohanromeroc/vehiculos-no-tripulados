/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bussiness.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Administrador
 */
public class FileExportService {

    public static void exportLogToFile(String fileLocation, String fileName, String log) throws FileNotFoundException, IOException, Exception {
        File file = new File(fileLocation + File.separator + fileName);
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(log);
        bw.close();
    }
}
