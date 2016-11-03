package bussiness;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class is for file export purposes
 * @author Yohan Romero
 */
public class FileExportService {

    /**
     * Creates a file with the contents of the log, in the specified location
     *
     * @param fileLocation Is the path to the folder that contains the file to
     * be exported
     * @param fileName Is the name of the file to be exported
     * @param log Is a string with the contents to be saved in the file
     * @throws FileNotFoundException If the specified file location not exists
     * @throws IOException If there any problem writing file on disk
     *
     */
    public static void exportLogToFile(String fileLocation, String fileName, String log) throws FileNotFoundException, IOException {
        File file = new File(fileLocation + File.separator + fileName);
        file.createNewFile();
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(log);
        bw.close();
    }
}
