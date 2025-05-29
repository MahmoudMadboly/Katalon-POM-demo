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

public class BillPay {
	
	void payBill(String payee_Name, String address, String city, String state,String zip_Code, String phone,  String account,  String verify_Account, String amount) {
		
		//insert data in the fields
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Payee Name'), payee_Name)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay address'), address)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay city'), city)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay state'), state)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Pay bill zip code'), zip_Code)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay phone'), phone)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Pay bill account'), account)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay Verify Account'), verify_Account)
	
		WebUI.sendKeys(findTestObject('Object Repository/Bill pay/Bill pay amount'), amount)
		
	}
}
