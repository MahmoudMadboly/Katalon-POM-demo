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
import internal.GlobalVariable as GlobalVariable
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
	String fetchedData_dateFrom = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Find transaction", "Transaction date from", GlobalVariable.FirstRowNo)


	//verify the fetched data
	if(fetchedData_dateFrom == null) {

		throw new RuntimeException("Failed to get test data from Excel")

	}

	String fetchedData_dateTo = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Find transaction", "Transaction date to", GlobalVariable.FirstRowNo)

	//verify the fetched data
	if(fetchedData_dateTo == null) {

		throw new RuntimeException("Failed to get test data from Excel")

	}

	//check test data if date format or normal string format
	String finalData_dateFrom = CustomKeywords.'keywordContainer.PageBaseKeyword.checkDataIfDate'(fetchedData_dateFrom)

	String finalData_dateTo = CustomKeywords.'keywordContainer.PageBaseKeyword.checkDataIfDate'(fetchedData_dateTo)

	// Verify processed data
	if (finalData_dateFrom == null) {

		throw new RuntimeException("Failed to process test data")

	}

	if (finalData_dateTo == null) {

		throw new RuntimeException("Failed to process test data")

	}

	//enter test data in test field
	WebUI.sendKeys(findTestObject('Object Repository/Find transaction/Find by Date Range_fromDate'), finalData_dateFrom)

	WebUI.sendKeys(findTestObject('Object Repository/Find transaction/Find by Date Range_toDate'), finalData_dateTo)

	String scnarioSuccessMessage = CustomKeywords.'keywordContainer.PageBaseKeyword.getTestData'("Find transaction", "Account Created Success Message", GlobalVariable.FirstRowNo)

	//verify transaction result displayed successfully
	CustomKeywords.'keywordContainer.PageBaseKeyword.validateTestCaseIsPassed'(findTestObject('Object Repository/Bill pay/Bill Payment_success message'), time, scnarioSuccessMessage)

}catch(Exception e) {

	// Log the failure message in the Katalon report with the exception details
	KeywordUtil.markFailed("find transaction by date range scenario is failed: " + e.getMessage())

	// Take a screenshot of the current browser state to help with debugging
	WebUI.takeScreenshot()

}

