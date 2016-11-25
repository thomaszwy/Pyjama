package PyjamaCode.TestingClauses.Schedule;
import pj.Pyjama;
public class schedule_positive_test1 {

	public int[] parallel_for_schedule(int threadNumber, int arraySize) {
		Pyjama.omp_set_num_threads(threadNumber);

		int[] array = new int[threadNumber];

		//#omp parallel for shared(array, arraySize) schedule(static)
		for (int i = 0; i < arraySize; i++) {
			int threadId = Pyjama.omp_get_thread_num();
			array[threadId] += 1;
		}
		return array;
	}

	public int[] parallel_for_schedule(int threadNumber, int arraySize,
			int chunkSize) {
		Pyjama.omp_set_num_threads(threadNumber);

		int[] array = new int[threadNumber];

		//#omp parallel for shared(array, arraySize) private(chunkSize) schedule(static,chunkSize)
		for (int i = 0; i < arraySize; i++) {
			int threadId = Pyjama.omp_get_thread_num();
			array[threadId] += 1;
		}

		return array;
	}

}
