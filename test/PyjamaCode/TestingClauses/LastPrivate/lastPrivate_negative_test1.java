package PyjamaCode.TestingClauses.LastPrivate;

public class lastPrivate_negative_test1{

	public int parallel_lastPrivate(int threadNumber){
		Pyjama.omp_set_num_threads(threadNumber);
		int i = -1;

		//#omp parallel lastprivate(i) 
		{
			i++;
		}
		
		return i;
	}
	
}
