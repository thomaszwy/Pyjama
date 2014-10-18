package jUnitTestSuits.correctnessTests.reduction.group10;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import pj.Version;
import Domain.SettingConstans;
import Domain.Bean.Data;
import Domain.Bean.Result;
import PyjamaCode.TestingClauses.Reduction.reduction_positive_test10;
import Utility.JSONDatabaseHelper.resultWriterHelper;

public class Reduction_Group10_1Test {

	private int threadNumber,arraySize;
	private static Data Data = new Data();
	private int processNum = SettingConstans.PROCESSNUM;

	@Rule
	public Timeout globalTimeout = new Timeout(SettingConstans.TIMEOUT);

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Data.setVersion(Version.compilerVersion);
		resultWriterHelper n = new resultWriterHelper();
		n.write(Data, "JsonResult", "Reduction","CorrectnessJunitResults_Group1", false);
	}

	@Test
	public synchronized void ReductionTest1() {
		threadNumber = 2;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case1");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}

	@Test
	public synchronized void ReductionTest2() {
		threadNumber = 3;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case2");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public synchronized void ReductionTest3() {
		threadNumber = 4;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case3");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public synchronized void ReductionTest4() {
		threadNumber = 5;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case4");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public synchronized void ReductionTest5() {
		threadNumber = 6;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case5");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public synchronized void ReductionTest6() {
		threadNumber = 7;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case6");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}
	
	@Test
	public synchronized void ReductionTest7() {
		threadNumber = 8;
		arraySize=10;
		Assume.assumeTrue(processNum > threadNumber - 2);
		
		reduction_positive_test10 test = new reduction_positive_test10();
		Result result = new Result();
		try {
			result.setTestName("parallel_for_Case7");
			result.setThreadCount(threadNumber);
			result.setArraySize(arraySize);
			result.setJunitResult("TimeOut");
			Data.addResult(result);
			
			//
			int actual = test.parallel_for_reduction(threadNumber, arraySize);
			int expected = (arraySize - 1) * arraySize / 2;
			if (actual == expected)
				result.setJunitResult("Success");
			else
				result.setJunitResult("Failed");

			result.setExpectedValue(expected);
			result.setActualValue(actual);
			Data.ReSetResult(result);
			assertEquals(expected, actual);
		} catch (Exception e) {
			result.setJunitResult("Failed");
			Data.ReSetResult(result);
			fail("Compile Failed");
			e.printStackTrace();
		}
	}

}
