package jUnitTestSuits.correctnessTests.schedule;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import pj.Version;
import Domain.SettingConstans;
import Domain.Bean.Data;
import Domain.Bean.Result;
import PyjamaCode.TestingClauses.Schedule.schedule_positive_test2;
import Utility.JSONDatabaseHelper.resultWriterHelper;

public class Schedule_Group4Test {

	private static Data Data = new Data();

	@Rule
	public Timeout globalTimeout = new Timeout(SettingConstans.TIMEOUT);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Data.setVersion(Version.compilerVersion);
		resultWriterHelper n = new resultWriterHelper();
		n.write(Data, "JsonResult", "Schedule", "CorrectnessJunitResults_Group4", false);
	}
	
	@Test
	public void ScheduleTest1() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case1");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=1;
		result.setChunkSize(chunkSize+"");
		int arraySize=10;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest2() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case2");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=2;
		result.setChunkSize(chunkSize+"");
		int arraySize=10;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest3() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case3");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=3;
		result.setChunkSize(chunkSize+"");
		int arraySize=10;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest4() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case4");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=4;
		result.setChunkSize(chunkSize+"");
		int arraySize=10;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest5() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case5");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=1;
		result.setChunkSize(chunkSize+"");
		int arraySize=100;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest6() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case6");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=2;
		result.setChunkSize(chunkSize+"");
		int arraySize=100;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest7() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case7");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=3;
		result.setChunkSize(chunkSize+"");
		int arraySize=100;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest8() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case8");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=4;
		result.setChunkSize(chunkSize+"");
		int arraySize=100;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest9() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case9");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=1;
		result.setChunkSize(chunkSize+"");
		int arraySize=1000;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest10() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case10");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=2;
		result.setChunkSize(chunkSize+"");
		int arraySize=1000;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest11() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case11");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=3;
		result.setChunkSize(chunkSize+"");
		int arraySize=1000;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	@Test
	public void ScheduleTest12() {
		schedule_positive_test2 test = new schedule_positive_test2();
		Result result = new Result();
		result.setTestName("Dynamic_Case12");
		int threadNumber = 4;
		result.setThreadCount(threadNumber);
		int chunkSize=4;
		result.setChunkSize(chunkSize+"");
		int arraySize=1000;
		result.setArraySize(arraySize);
		
		
		int[] actualArray = test.parallel_for_schedule(threadNumber, arraySize,chunkSize);
		int[] expectedArray = new int[threadNumber];
		
		for (int i = 0; i < arraySize; i++) {
			expectedArray[0]+=1;
		}
		
		if (validate(actualArray,expectedArray))
			result.setJunitResult("Success");
		else
			result.setJunitResult("Failed");

		result.setActualArrayValue(actualArray);
		result.setExpectedArrayValue(expectedArray);
		Data.addResult(result);

		if (!validate(actualArray,expectedArray)) fail("Test Failed");
	}
	
	private boolean validate(int[] actualArray,int[] expectedArray){
		boolean flag=true;
		for (int i = 0; i < actualArray.length; i++) {
			if (actualArray[i]!=expectedArray[i]) {
				flag=false;
			}
		}
		return flag;
	} 

}
