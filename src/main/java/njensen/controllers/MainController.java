package njensen.controllers;

import njensen.tools.SearchFolders;

/**
 * Main controller.
 * Created by njensen on 6/12/17.
 */
public class MainController {

    private SearchFolders searchFolders;

    /**
     * The initial process for the program.
     *
     * @param regexFilename The string pattern for which to search
     */
    public void init(String regexFilename) {

        systemOut("- Find Files / Directories-");

        // start the search of files
        int numberFound = getSearchFolders().search(getPublicWorkingDirectory(), regexFilename);

        systemOut(numberFound + " found");
        if (numberFound == 0) {
            systemOut("The search uses regex (Java). \nTry modifying your search.");
        }

    }

    /**
     * Get the folder search object.
     *
     * @return Folder search object
     */
    public SearchFolders getSearchFolders() {
        if (searchFolders == null) searchFolders = new SearchFolders();
        return searchFolders;
    }

    /**
     * Returns the current directory.
     *
     * @return String of the current directory
     */
    private String getPublicWorkingDirectory() {
        return System.getProperty("user.dir");
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
