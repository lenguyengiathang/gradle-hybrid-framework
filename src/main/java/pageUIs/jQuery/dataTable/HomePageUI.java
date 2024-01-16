package pageUIs.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "Xpath=//a[contains(@class,'pagination-page-link') and text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVE_BY_NUMBER = "Xpath=//a[contains(@class,'pagination-page-link active') and text()='%s']";
	public static final String HEADER_TEXTBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGINATION = "css=li.qgrd-pagination-page";
	public static final String NUMBER_OF_ROWS_EACH_PAGE = "xpath=//tbody/tr";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "Xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_AND_COLUMN_INDEX = "Xpath=//tbody/tr[%s]/td[%s]/div/select";
	public static final String ICON_BY_ROW_NUMBER = "xpath=//tbody/tr[1]//button[@title='Insert Row Above']";
}
