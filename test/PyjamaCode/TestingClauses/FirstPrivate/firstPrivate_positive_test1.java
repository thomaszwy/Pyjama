package PyjamaCode.TestingClauses.FirstPrivate;

import pj.Pyjama;

public class firstPrivate_positive_test1{

	public int[] parallel_firstPrivate(int threadNumber){
		Pyjama.omp_set_num_threads(threadNumber);
		int kk = threadNumber;
		int[] array = new int[threadNumber];

		//#omp parallel firstprivate(kk) shared(array)
		{
			int index = Pyjama.omp_get_thread_num();
			array[index]=kk;
			kk=0;
		}
		
		return array;
	}
	
}
