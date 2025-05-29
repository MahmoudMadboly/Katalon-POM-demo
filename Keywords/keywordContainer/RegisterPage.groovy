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

public class RegisterPage{

	void fulfillRegisterForm(String firsName,String lastName,String address,String City,String State,String Zip_Code,String phone,String ssn,String userName,String pass,String confirmPass) {


		//insert first name in first name field
		WebUI.sendKeys(findTestObject('Object Repository/Register/First name'), firsName)
		//insert last name in last name field
		WebUI.sendKeys(findTestObject('Object Repository/Register/Last name'), lastName)

		//insert address in address field
		WebUI.sendKeys(findTestObject('Object Repository/Register/Adress'), address)

		//insert city in city field
		WebUI.sendKeys(findTestObject('Object Repository/Register/City'), City)

		//insert state in state field
		WebUI.sendKeys(findTestObject('Object Repository/Register/State'), State)

		//insert zip code in zip code field
		WebUI.sendKeys(findTestObject('Object Repository/Register/Zip code'), Zip_Code)

		//insert phone in phone field
		WebUI.sendKeys(findTestObject('Object Repository/Register/Phone'), phone)

		//insert ssn in ssn field
		WebUI.sendKeys(findTestObject('Object Repository/Register/SSN'), ssn)

		//insert username in username field
		WebUI.sendKeys(findTestObject('Object Repository/Register/UserName'), userName)

		//insert pass in pass field
		WebUI.sendKeys(findTestObject('Object Repository/Register/Password'), pass)

		//insert confirm pass in confirm pass field
		WebUI.sendKeys(findTestObject('Object Repository/Register/ConfirmPass'), confirmPass)

		//click on save register button
		WebUI.click(findTestObject('Object Repository/Register/Save register'))
	}
}