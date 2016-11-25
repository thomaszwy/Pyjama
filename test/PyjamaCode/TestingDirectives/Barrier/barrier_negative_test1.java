package PyjamaCode.TestingDirectives.Barrier;

import pj.Pyjama;

public class barrier_negative_test1{
	/**
	 * result[0+1+2+..+threadNumber,0+1+2+..+threadNumber,0+1+2+..+threadNumber,...]
	 * */	
	public int[] parallel_barrier(int threadNumber){
		Pyjama.omp_set_num_threads(threadNumber);

		int[] array= new int[threadNumber];
		int sum=0;
		int[] result=new int[threadNumber];

		//#omp parallel 
		{ 
			int ThreadID =  Pyjama.omp_get_thread_num();
			array[ThreadID]=ThreadID;
			
			//#omp barrier (sum)	
			{
				for(int i=0; i<threadNumber;i++){
					sum+=array[i];
				}
				result[ThreadID]=sum;
			}
		}
		return result;
	}
}
