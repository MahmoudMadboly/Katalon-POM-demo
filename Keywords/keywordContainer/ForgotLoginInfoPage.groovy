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

public class ForgotLoginInfoPage {
	
	void fillOutUserInfo(String firsName,String lastName,String address,String city,String state,String zipCode,String ssn) {
		
		//insert test data in test fields
		WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), firsName)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), lastName)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), address)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/City'), city)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/State'), state)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), zipCode)
		
		WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)
	
	}	
}