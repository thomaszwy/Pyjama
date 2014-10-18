package jUnitTestSuits.compileTests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import Domain.SettingConstans;
import Domain.Bean.Data;
import Domain.Bean.Result;
import Utility.JSONDatabaseHelper.resultWriterHelper;
import Utility.JavaCompileHelper.JavaCompiler;

import pj.PyjamaToJavaParser;
import pj.Version;

/** 
 * The BARRIER directive synchronizes all threads in the team.
 * When a BARRIER directive is reached, 
 * a thread will wait at that point until all other threads have reached that barrier. 
 * All threads then resume executing in parallel the code that follows the barrier.
 * 
 * The barrier directive supports no Pyjama clauses.
 */
public class BarrierTest {
	
	private static Data Data= new Data();
	
	@Rule
	public Timeout globalTimeout = new Timeout(SettingConstans.TIMEOUT);
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Data.setVersion(Version.compilerVersion);
		resultWriterHelper n = new resultWriterHelper();
		n.write(Data,"JsonResult","Barrier","CompileJunitResults",false);
	}
	
	@Test
	public void PositiveTest1() {
		if(!positiveTest("PositiveTest1","barrier_positive_test1","test1","Barrier directive in parallel construct"))
			fail("Compile Failed");
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Test
	public void NegativeTest1() {
		if(!negativeTest("NegativeTest1","barrier_negative_test1","Barrier directive with variable"))
			fail("Compile Failed");
	}
	
	private boolean positiveTest(String name,String filename,String test,String remark){
		Result result = new Result();		
		result.setTestName(name);
		result.setCompilePJFilePath(SettingConstans.COMPILETARGETTESTCODEPATH+"/PyjamaCode/TestingDirectives/Barrier/"+filename+".pj");
		result.setRemark(remark);
		result.setCompileResult("failed");
		result.setJunitResult("TimeOut");
		Data.addResult(result);
		
		try {
			PyjamaToJavaParser.parse(new File(SettingConstans.COMPILETARGETTESTCODEPATH+"/PyjamaCode/TestingDirectives/Barrier/"+filename+".pj"));
			JavaCompiler builder = new JavaCompiler();
			List<String> error =builder.buildJava(SettingConstans.COMPILETARGETTESTCODEPATH+"/PyjamaCode/TestingDirectives/Barrier/",test);
			if (error.size()>0){
				result.setCompileResult(error.toString());
				result.setJunitResult("notPass");
				Data.ReSetResult(result);
				return false;
			}
			else{
				result.setCompileResult("success");
				result.setJunitResult("Pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(e.getMessage()==null){
				result.setJunitResult("notPass");
			}else{
				result.setCompileResult(e.getMessage());
			
			if(e.getMessage().startsWith("Unsupported"))
				result.setJunitResult("Unsupported");
			else
				result.setJunitResult("notPass");
			}
			Data.ReSetResult(result);
			return false;
		}
		Data.ReSetResult(result);
		return true;
	}
	
	private boolean negativeTest(String name,String filename,String remark){
		Result result = new Result();
		result.setTestName(name);
		result.setCompilePJFilePath(SettingConstans.COMPILETARGETTESTCODEPATH+"/PyjamaCode/TestingDirectives/Barrier/"+filename+".pj");
		result.setRemark(remark);
		result.setCompileResult("failed");
		result.setJunitResult("TimeOut");
		Data.addResult(result);
		
		try {
			PyjamaToJavaParser.parse(new File(SettingConstans.COMPILETARGETTESTCODEPATH+"/PyjamaCode/TestingDirectives/Barrier/"+filename+".pj"));
		} catch (Exception e) {
			result.setCompileResult("Should failed");
			result.setJunitResult("Pass");
			Data.ReSetResult(result);
			e.printStackTrace();
			return true;
		}
		result.setCompileResult("Shouldn't success");
		result.setJunitResult("notPass");
		Data.ReSetResult(result);
		return false;
	}

}
