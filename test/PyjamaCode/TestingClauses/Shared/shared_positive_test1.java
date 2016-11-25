package PyjamaCode.TestingClauses.Shared;

import pj.Pyjama;

public class shared_positive_test1{

	public int[] parallel_shared(int threadNumber){
		Pyjama.omp_set_num_threads(threadNumber);
		
		int i = 1;
		int[] array = new int[threadNumber];

		//#omp parallel private(i) shared(array)
		{
			int index =  Pyjama.omp_get_thread_num();
			
			array[index]=i;
		}
		return array;
	}
	
}
