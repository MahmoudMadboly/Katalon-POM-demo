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

public class UpdateAccountInfo {

/*	void updateAccountInfoPartially(Map <String , String> partialUpdate) {

		if (partialUpdate.containsKey("firstName")) {
			TestObject firstNameField = findTestObject('Object Repository/Update profile info/First Name field')
			WebUI.setText(firstNameField, partialUpdate.get("firstName"))
		}

		if (partialUpdate.containsKey("lastName")) {
			TestObject lastNameField = findTestObject('Object Repository/Update profile info/Last Name field')
			WebUI.setText(lastNameField, partialUpdate.get("lastName"))
		}
	}*/
	

		//check fields should be updated & update them either partially or fully
	void updateProfileInfo(Map<String, String> profileData) {
		Map<String, String> fields = [
			"First name": profileData.get("firstName"),
			"Last name": profileData.get("lastName"),
			"Adress": profileData.get("address"),
			"City": profileData.get("city"),
			"State": profileData.get("state"),
			"Zip code": profileData.get("zipCode"),
			"Phone": profileData.get("phone")
		]

		fields.each { fieldName, fieldValue ->
			if (fieldValue) {
				TestObject fieldObject = findTestObject("Register/" + fieldName)
				WebUI.clearText(fieldObject)
				WebUI.setText(fieldObject, fieldValue)
			}
		}
		WebUI.click(findTestObject('Object Repository/Update profile info/Update info button'))
	}
}