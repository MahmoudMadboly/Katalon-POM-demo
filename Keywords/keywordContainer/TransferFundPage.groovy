package keywordContainer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class TransferFundPage {
	
void transferFund(int amount) {
	
	//enter an amount to be transferred
	WebUI.sendKeys(findTestObject('Object Repository/Transfer fund/Fund amount'), amount)
	
	//open from account list
	WebUI.click(findTestObject('Object Repository/Transfer fund/From account list'))
	 
	//select the first account
	WebUI.click(findTestObject('Object Repository/Transfer fund/Account option_1'))
	
	//open to account list
	WebUI.click(findTestObject('Object Repository/Transfer fund/To account list'))
	 
	//select the newly created account
	WebUI.click(findTestObject('Object Repository/Transfer fund/Account option_2'))
	
	//hit transfer button
	WebUI.click(findTestObject('Object Repository/Transfer fund/Transfer button'))
	
	}	
	
}