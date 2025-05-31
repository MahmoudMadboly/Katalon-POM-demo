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
import org.openqa.selenium.Keys as Keys

int time = 3

try{
	
	
	//step1: will enter to open a new account screen & check that we are in the right page
	CustomKeywords.'keywordContainer.PageBaseKeyword.navigateToFeature'(findTestObject('Object Repository/Open new account/Open New account button'), 
		findTestObject('Object Repository/Open new account/Open new account heading'), 
		time)

	
	//step2: open account type list
	CustomKeywords.'keywordContainer.PageBaseKeyword.clickOnbutton'(findTestObject('Object Repository/Open new account/account type list'))
	
	//step3: select the requested account type
	CustomKeywords.'keywordContainer.PageBaseKeyword.clickOnbutton'(findTestObject('Object Repository/Open new account/Checking account'))
	
	//step4: save the account
	CustomKeywords.'keywordContainer.PageBaseKeyword.clickOnbutton'(findTestObject('Object Repository/Open new account/Save new account button'))
	
	//step 5: get & store the created account no.
	CustomKeywords.'keywordContainer.PageBaseKeyword.storeInfo'(findTestObject('Object Repository/Open new account/newly created account number'))
	
	//step 6: get success message value from test data sheet
	String AccountCreatedSuccessfully = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Open new account", "Account created success message", GlobalVariable.FirstRowNo)
	
	//step7: verify that the account created successfully
	CustomKeywords.'keywordContainer.PageBaseKeyword.validateTestCaseIsPassed'(findTestObject('Object Repository/Open new account/account added_success message'), time, AccountCreatedSuccessfully)

}catch(Exception e){

// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("customer care scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

