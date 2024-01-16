package commons;

import java.io.File;

public class GlobalConstants {

	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_AND_DROP_HTML5 = PROJECT_PATH + File.separator + "dragAndDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGScreenShots"
			+ File.separator;
	public static final String JAVA_VERSION = System.getProperty("java.version");

	public static final String DB_DEV_URL = "";
	public static final String DB_DEV_USERNAME = "";
	public static final String DB_DEV_PASSWORD = "";

	public static final String DB_TEST_URL = "";
	public static final String DB_TEST_USERNAME = "";
	public static final String DB_TEST_PASSWORD = "";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_FAILED_TEST = 3;

}
