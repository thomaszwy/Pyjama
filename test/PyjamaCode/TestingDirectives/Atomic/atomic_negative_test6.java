package PyjamaCode.TestingDirectives.Atomic;

import pj.Pyjama;

public class atomic_nagative_test6{

	/**
	 * In OpenMP The expression statement must have one of the following forms: x binop= expr
	 * In Pyjama x operator= expression belong to x=x operator expression, which should use 
	 * critical to implement parallel program
	 * */
	public int parallel_atomic(int threadNumber){	
		Pyjama.omp_set_num_threads(threadNumber);
		
		int counter = 1;
		//#omp parallel
		{
			//#omp atomic
			counter*=2;
		}
		return counter;
	}	
}
