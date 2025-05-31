import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.beans.Customizer
import java.sql.Date
import java.text.SimpleDateFormat

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
import keywordContainer.FindTransactionPage

import org.openqa.selenium.Keys as Keys


int time = 5

try {

	//navigate to the target screen & wait till screen header appear
	CustomKeywords.'keywordContainer.PageBaseKeyword.navigateToFeature'(findTestObject('Object Repository/Find transaction/Find Transactions button'),
			findTestObject('Object Repository/Find transaction/Find transaction heading'),
			time)

	//select the right acount id
	CustomKeywords.'keywordContainer.PageBaseKeyword.selectAcountIdBeforeFindTransactions'(findTestObject('Object Repository/Find transaction/Find transaction_AccountID'))

	//fetch the related test data
	String fetchedAmount = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Find transaction", "Transfer amount", GlobalVariable.FirstRowNo)

	String scnarioSuccessMessage = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Find transaction", "Account Created Success Message", GlobalVariable.FirstRowNo)


	//verify the fetched data
	if(fetchedAmount == null) {

		throw new RuntimeException("Failed to get test data from Excel")

	}


	//check test data if date format or normal string format
	String finalAmount = CustomKeywords.'keywordContainer.PageBaseKeyword.checkDataIfDate'(fetchedAmount)


	// Verify processed data
	if (finalAmount == null) {

		throw new RuntimeException("Failed to process test data")

	}

	//initiate an object from FindTransactionPage class
	FindTransactionPage transactionCriteria = new FindTransactionPage()

	//enter test data in test field
	transactionCriteria.fillOutTransactionCriteria(findTestObject('Object Repository/Find transaction/Find transaction button_findByAmount'), finalAmount)

	//verify transaction result displayed successfully
	CustomKeywords.'keywordContainer.PageBaseKeyword.validateTestCaseIsPassed'(findTestObject('Object Repository/Bill pay/Bill Payment_success message'), time, scnarioSuccessMessage)

}catch(Exception e) {

	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("find transaction by amount scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

