import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import keywordContainer.RegisterPage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.testng.Assert
import org.testng.Assert as Keys

int time = 5

try {

	//navigate to the target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.PageBaseKeyword.navigateToFeature'(findTestObject('Object Repository/Register/Register button'),
			findTestObject('Object Repository/Register/Sign up heading'),
			time)

	//fetch first name from test data sheet
	String firsName = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "First Name", GlobalVariable.FirstRowNo)

	//fetch last name from test data sheet
	String lastName = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Last Name", GlobalVariable.FirstRowNo)

	//fetch address from test data sheet
	String address = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Address", GlobalVariable.FirstRowNo)

	//fetch city from test data sheet
	String City = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "City", GlobalVariable.FirstRowNo)

	//fetch state from test data sheet
	String State = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "State", GlobalVariable.FirstRowNo)

	//fetch zip_code from test data sheet
	String Zip_Code = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Zip Code", GlobalVariable.FirstRowNo)

	//fetch phone from test data sheet
	String phone = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Phone", GlobalVariable.FirstRowNo)

	//fetch ssn from test data sheet
	String ssn = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)

	//fetch username from test data sheet
	String userName = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Username", GlobalVariable.FirstRowNo)

	//store username value in GlobalVariable "CreatedUseName"
	GlobalVariable.CreatedUseName = userName

	//fetch pass from test data sheet
	String pass = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Password", GlobalVariable.FirstRowNo)

	//store pass value in GlobalVariable "CreatedPassWord"
	GlobalVariable.CreatedPassWord = pass

	//fetch confirm pass from test data sheet
	String confirmPass = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Confirm", GlobalVariable.FirstRowNo)

	//fetch register success message from test data sheet
	String scenarioSuccessMessage = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "Sign up_Success message", GlobalVariable.FirstRowNo)

	RegisterPage registerObject = new RegisterPage()
	

	registerObject.fulfillRegisterForm(firsName, lastName, address, City, State, Zip_Code, phone, ssn, userName, confirmPass, confirmPass)


	//validate that test case is passed
	CustomKeywords.'keywordContainer.PageBaseKeyword.validateTestCaseIsPassed'(findTestObject('Object Repository/Register/Welcome message'), time, scenarioSuccessMessage)

}catch(Exception e) {

	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("Register scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}