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
import internal.GlobalVariable
import keywordContainer.ForgotLoginInfoPage

import org.openqa.selenium.Keys as Keys

int time = 5

try {

	//navigate to the target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.PageBaseKeyword.navigateToFeature'(findTestObject('Object Repository/Forgot login info/Forgot login info button'),
		 findTestObject('Object Repository/Forgot login info/Forgot login info heading'),
		 time)
	
	
	//fetch test data from test sheet
	String firsName = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "First Name", GlobalVariable.SecondRowNo)
	
	String lastName = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "Last Name", GlobalVariable.SecondRowNo)
	
	String address = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "Address", GlobalVariable.SecondRowNo)
	
	String city = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "City", GlobalVariable.SecondRowNo)
	
	String state = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "State", GlobalVariable.SecondRowNo)
	
	String zipCode = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Update profile info", "Zip Code", GlobalVariable.SecondRowNo)
	
	String ssn = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Sign up", "SSN", GlobalVariable.FirstRowNo)
	
	String scenarioSuccessMessage = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("", "", GlobalVariable)
	
	//initiate an object of ForgotLoginInfoPage class
	ForgotLoginInfoPage forgotLoginInfo = new ForgotLoginInfoPage()
	
	//using the new object, call fillOutUserInfo method to fill out the user logon info
	forgotLoginInfo.fillOutUserInfo(firsName, lastName, address, city, state, zipCode, ssn)
		
	//click on send button
	CustomKeywords.'keywordContainer.PageBaseKeyword.clickOnbutton'(findTestObject('Object Repository/Forgot login info/Find my login info button'))
	
}catch(Exception e) {
	
	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("Register scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()
	
}

