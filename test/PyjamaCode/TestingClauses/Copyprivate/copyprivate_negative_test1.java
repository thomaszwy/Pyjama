package PyjamaCode.TestingClauses.Copyprivate;

import pj.Pyjama;

public class copyprivate_negative_test1 {
	public int[] parallel_copyPrivate(int threadNumber) {
		Pyjama.omp_set_num_threads(threadNumber);
		int i = threadNumber;
		int[] array = new int[threadNumber];

		//#omp parallel copyprivate(i) shared(array)
		{
			int index = Pyjama.omp_get_thread_num();
			
			array[index] = i;
			

			i++;
		}

		return array;
	}
}
