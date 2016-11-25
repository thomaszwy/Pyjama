package PyjamaCode.TestingDirectives.LoopFor;

public class loopFor_positive_test19 {
	/**
	 * loopFor More
	 * */
	public int[] parallel_loopFor(int threadCount) {
		Pyjama.omp_set_num_threads(threadCount);
		int[] array = new int[1000];

		//#omp parallel for shared(array)
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			array[i]=i;
		}

		return array;
	}

}
