import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

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
import keywordContainer.TransferFundPage

import org.openqa.selenium.Keys as Keys

int time = 5


try{

	//step1: will enter to open transfer fund screen	
	CustomKeywords.'keywordContainer.PageBaseKeyword.navigateToFeature'(findTestObject('Object Repository/Transfer fund/Transfer fund button'), 
		findTestObject('Object Repository/Transfer fund/Transfer fund heading'), 
		time)
	
	
	String transfer_Amount = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Transfer fund","Transfer amount" , GlobalVariable.FirstRowNo)
	
	String scenarioSuccessMessage = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Transfer fund","Transfer fund_success message" , GlobalVariable.FirstRowNo)
	
	TransferFundPage tranferFund = new TransferFundPage()
	
	tranferFund.transferFund(transfer_Amount)
	
	//validate test case is passed
	CustomKeywords.'keywordContainer.PageBaseKeyword.validateTestCaseIsPassed'(findTestObject('Object Repository/Transfer fund/Transfer fund_Success message'),
		 time, 
		 scenarioSuccessMessage)
	

}catch(Exception e){

// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("customer care scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

