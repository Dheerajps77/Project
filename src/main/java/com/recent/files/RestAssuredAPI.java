package com.recent.files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.IOUtils;


import com.investaSolutions.base.*;

public class RestAssuredAPI {

	PropertiesManager properties = PropertiesManager.getInstance();

	/*
	 * public void postMethodResponse200(String endPointURL, String jsonFilePath)
	 * throws Exception { try { String Valid_id="b890800a80da4aa58f640f7f8fca33";
	 * String Valid_pass="blah";
	 * 
	 * RestAssured.baseURI=endPointURL; RequestSpecification
	 * request=RestAssured.given(); FileInputStream fis=new FileInputStream(new
	 * File(jsonFilePath));
	 * 
	 * given().auth().preemptive().basic(Valid_id, Valid_pass)
	 * .body(IOUtils.toString(fis, "UTF-8")) .contentType(ContentType.JSON) .when()
	 * .post(endPointURL) .then() .statusCode(200).and().log().all();
	 * 
	 * request.header("Content-Type", "application/json");
	 * request.body(IOUtils.toString(fis, "UTF-8")); response =
	 * request.post("/posts");
	 * 
	 * int statusCode = response.getStatusCode(); String successCode =
	 * response.jsonPath().get("SuccessCode"); Assert.assertEquals(statusCode,
	 * "201"); Assert.assertEquals( "Correct Success code was returned",
	 * successCode, "OPERATION_SUCCESS");
	 * 
	 * } catch (Exception e) { throw e; } }
	 */

	/*
	 * public void postMethodResponse201(String endPointURL, String jsonFilePath)
	 * throws Exception { try { String Valid_id="b890800a80da4aa58f640f7f8fca33";
	 * String Valid_pass="blah";
	 * 
	 * RestAssured.baseURI=endPointURL; RequestSpecification
	 * request=RestAssured.given(); FileInputStream fis=new FileInputStream(new
	 * File(jsonFilePath));
	 * 
	 * given().auth().preemptive().basic(Valid_id, Valid_pass)
	 * .body(IOUtils.toString(fis, "UTF-8")) .contentType(ContentType.JSON) .when()
	 * .post(endPointURL) .then() .statusCode(201).and().log().all(); } catch
	 * (Exception e) { throw e; } }
	 */

	/***
	 * This method will get the response from API
	 * 
	 * @param endPointURL
	 * @param jsonFilePath
	 * @return Response
	 * @throws Exception
	 */
	public Response getResponseOfPOSTCall(String endPointURL, String jsonFilePath) throws Exception {
		String Valid_id = "";
		String Valid_pass = "";
		Response response;
		FileInputStream fis = null;
		try {
			Valid_id = properties.getConstant("id");
			Valid_pass = properties.getConstant("pass");
			RestAssured.baseURI = endPointURL;
			fis = new FileInputStream(new File(jsonFilePath));
			response = given().auth().preemptive().basic(Valid_id, Valid_pass).body(IOUtils.toString(fis, "UTF-8"))
					.contentType(ContentType.JSON).when().post(endPointURL);
		} catch (Exception e) {
			throw e;
		}
		return response;
	}

	/***
	 * This will verify the response code of API
	 * 
	 * @param endPointURL
	 * @param jsonFilePath
	 * @return Response Code
	 * @throws Exception
	 */
	public boolean verifyAPICallResponse(String endPointURL, String jsonFilePath) throws Exception {
		int responseCode;
		String responseCodeInString;
		String responseMsg;
		String responseBody;
		boolean flag = false;
		Response response;
		try {
			response = getResponseOfPOSTCall(endPointURL, jsonFilePath);
			responseCode = response.getStatusCode();
			responseMsg = response.getStatusLine();
			responseCodeInString = Integer.toString(responseCode);
			responseBody = response.asString();
			if (responseCode == 200 || responseCode == 201) {
				flag = true;
				TestBase.logInfo(String.format(properties.getConstant("VerifyAPICallTestResultPassed"),responseCodeInString, responseMsg, responseBody));
			} else {
				TestBase.logError(String.format(properties.getConstant("VerifyAPICallTestResultFailed"),responseCodeInString, responseMsg, responseBody));
			}
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

}
