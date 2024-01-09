package org.cloverTest.com.context;

/***
 * This class is for constants
 *
 *
 * @author UdayaDuvvuri
 */
public class Constants {
    /**
     * The Constant WORKING_DIRECTORY.
     */
    public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

    /**
     * The Constant REPORT_DIRECTORY.
     */
    public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";

    /**
     * The Constant PROJECT_NAME.
     */
    public final static String PROJECT_NAME = "TAKEHOME_ASSIGNMENT";

    /**
     * The Constant EXTENT_CONFIG_PATH.
     */
    public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/main/resources/config/extent-config.xml";

    /**
     * The Constant PROPERTY_FILE_PATH.
     */
    public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/main/resources/config/test.properties";


    /**
     * The Constant TEST_PROPERTY_FILE_PATH.
     */
    public final static String TEST_PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/main/resources/config/testLogin.properties";


}

