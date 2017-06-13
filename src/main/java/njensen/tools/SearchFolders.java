package njensen.tools;

import java.io.File;

/**
 * Search directories and files for a filename in regex format.
 * Created by Nicholas Jensen on 6/12/17.
 */
public class SearchFolders {

    private int numberFound = 0;

    /**
     * Starts the search of files and directories.
     * This is based in the public working directory (pwd).
     */
    public int search(String folderToSearch, String findFileName) {

        File folder = new File(folderToSearch);
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles != null) {

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {

                    if (listOfFiles[i].getName().matches(findFileName)) {
                        numberFound++;
                        systemOut(listOfFiles[i].getAbsolutePath());
                    }

                } else if (listOfFiles[i].isDirectory()) {

                    if (listOfFiles[i].getName().matches(findFileName)) {
                        numberFound++;
                        systemOut(listOfFiles[i].getAbsolutePath());
                    }
                    search(listOfFiles[i].getAbsolutePath(), findFileName);

                }

            }

        }

        return numberFound;

    }

    /**
     * Print text in the console.
     *
     * @param message The message to print.
     */
    public static void systemOut(String message) {
        if (message != null)
            if (message.trim().length() > 0)
                System.out.println(message);
    }

}
