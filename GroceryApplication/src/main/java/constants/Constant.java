package constants;

public class Constant {

	public static final String CONFIGFILE = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";
	public static final String EXCELFILE = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\GroceryTestData.xlsx";
	public static final String VALIDCREDENTIALERROR = "User was unable to Login with valid credentials";
	public static final String VALIDUSERNAMEINVALIDPASSWORDERROR = "user was able to login with Invalid credentials";
	public static final String INVALIDUSERNAMEVALIDPASSWORD = "user is able to login with invalid credentials";
	public static final String INUSERNAMEINPASSWORD = "user is able to login with invalid credentials";
	public static final String HOMEVALIDCREDENTIAL = "user is unable to logout";
	public static final String USERABLETOSEARCH = "search not happened";
	public static final String USERISABLETORESET = "reset has not happened";
	public static final String ADMINTESTADDNEWUSER = "User not added successfully";
	public static final String SEARCHADDEDNEWS = "Searched News is not available in the List";
	public static final String UnabletoAddNewsError = "Error in Adding News";
	public static final String UnabletoSearchNewsError = "Error in Searching News";

}
