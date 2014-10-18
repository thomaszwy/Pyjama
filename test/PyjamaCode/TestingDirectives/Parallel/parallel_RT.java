package PyjamaCode.TestingDirectives.Parallel;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.parser.ast.visitor.DummyClassToDetermineVariableType;//#GEN#[-1]#PJ#
import pj.Pyjama;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
import pj.pr.*;//#GEN#[-1]#PJ#
import pj.PjRuntime;//#GEN#[-1]#PJ#
import pj.Pyjama;//#GEN#[-1]#PJ#
import java.util.concurrent.*;//#GEN#[-1]#PJ#
import java.util.concurrent.atomic.AtomicInteger;//#GEN#[-1]#PJ#
import java.util.concurrent.locks.ReentrantLock;//#GEN#[-1]#PJ#
import javax.swing.SwingUtilities;//#GEN#[-1]#PJ#
import java.lang.reflect.InvocationTargetException;//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
public class parallel_RT {//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    public long[] parallel_region(int threadNumber) {{//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(threadNumber);//#GEN#[-1]#PJ#
        long[] RT = new long[2];//#GEN#[-1]#PJ#
        int[] array = new int[threadNumber];//#GEN#[-1]#PJ#
        RT[0] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_0 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_0 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_0 = icv__OMP_ParallelRegion_0.nthreads_var.get(icv__OMP_ParallelRegion_0.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_0 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_0.put("array",array);
        _OMP_ParallelRegion_0 _OMP_ParallelRegion_0_in = new _OMP_ParallelRegion_0(_threadNum__OMP_ParallelRegion_0,icv__OMP_ParallelRegion_0,inputlist__OMP_ParallelRegion_0,outputlist__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_0_in.runParallelCode();//#GEN#[-1]#PJ#
        array = (int[])outputlist__OMP_ParallelRegion_0.get("array");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_0);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#0) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        RT[1] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        return RT;//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
class _OMP_ParallelRegion_0{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        int[] array = null;
        //#END shared variables defined here
        public _OMP_ParallelRegion_0(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            array = (int[])OMP_inputList.get("array");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("array",array);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    int index = Pyjama.omp_get_thread_num();//#GEN#[-1]#PJ#
                    array[index] = index;//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    /**
	 * Initialise varible outside parallel region
	 * *///#GEN#[-1]#PJ#
    public long[] parallel_region_increment(int threadNumber) {{//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(threadNumber);//#GEN#[-1]#PJ#
        long[] RT = new long[2];//#GEN#[-1]#PJ#
        int counter = 0;//#GEN#[-1]#PJ#
        RT[0] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#1) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_1 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_1 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_1 = icv__OMP_ParallelRegion_1.nthreads_var.get(icv__OMP_ParallelRegion_1.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_1 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_1 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_1.put("counter",counter);
        _OMP_ParallelRegion_1 _OMP_ParallelRegion_1_in = new _OMP_ParallelRegion_1(_threadNum__OMP_ParallelRegion_1,icv__OMP_ParallelRegion_1,inputlist__OMP_ParallelRegion_1,outputlist__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_1_in.runParallelCode();//#GEN#[-1]#PJ#
        counter = (Integer)outputlist__OMP_ParallelRegion_1.get("counter");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_1);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#1) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        RT[1] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        return RT;//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
class _OMP_ParallelRegion_1{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        int counter = 0;
        //#END shared variables defined here
        public _OMP_ParallelRegion_1(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            counter = (Integer)OMP_inputList.get("counter");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("counter",counter);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    counter++;//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
    /**
	 * Initialise array varible outside parallel region
	 * *///#GEN#[-1]#PJ#
    public long[] parallel_region_increment_array(int threadNumber) {{//#GEN#[-1]#PJ#
        Pyjama.omp_set_num_threads(threadNumber);//#GEN#[-1]#PJ#
        long[] RT = new long[2];//#GEN#[-1]#PJ#
        int[] counter = new int[1];//#GEN#[-1]#PJ#
        counter[0] = 0;//#GEN#[-1]#PJ#
        RT[0] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#2) -- START *///#GEN#[-1]#PJ#
        InternalControlVariables icv_previous__OMP_ParallelRegion_2 = PjRuntime.getCurrentThreadICV();//#GEN#[-1]#PJ#
        InternalControlVariables icv__OMP_ParallelRegion_2 = PjRuntime.inheritICV(icv_previous__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        int _threadNum__OMP_ParallelRegion_2 = icv__OMP_ParallelRegion_2.nthreads_var.get(icv__OMP_ParallelRegion_2.levels_var);//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> inputlist__OMP_ParallelRegion_2 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        ConcurrentHashMap<String, Object> outputlist__OMP_ParallelRegion_2 = new ConcurrentHashMap<String,Object>();//#GEN#[-1]#PJ#
        inputlist__OMP_ParallelRegion_2.put("counter",counter);
        _OMP_ParallelRegion_2 _OMP_ParallelRegion_2_in = new _OMP_ParallelRegion_2(_threadNum__OMP_ParallelRegion_2,icv__OMP_ParallelRegion_2,inputlist__OMP_ParallelRegion_2,outputlist__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        _OMP_ParallelRegion_2_in.runParallelCode();//#GEN#[-1]#PJ#
        counter = (int[])outputlist__OMP_ParallelRegion_2.get("counter");
        PjRuntime.recoverParentICV(icv_previous__OMP_ParallelRegion_2);//#GEN#[-1]#PJ#
        /*OpenMP Parallel region (#2) -- END *///#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
        RT[1] = System.currentTimeMillis();//#GEN#[-1]#PJ#
        return RT;//#GEN#[-1]#PJ#
    }//#GEN#[-1]#PJ#
    }
class _OMP_ParallelRegion_2{
        private int OMP_threadNumber = 1;
        private InternalControlVariables icv;
        private ConcurrentHashMap<String, Object> OMP_inputList = new ConcurrentHashMap<String, Object>();
        private ConcurrentHashMap<String, Object> OMP_outputList = new ConcurrentHashMap<String, Object>();
        private CyclicBarrier OMP_barrier;
        private ReentrantLock OMP_lock;

        //#BEGIN shared variables defined here
        int[] counter = null;
        //#END shared variables defined here
        public _OMP_ParallelRegion_2(int thread_num, InternalControlVariables icv, ConcurrentHashMap<String, Object> inputlist, ConcurrentHashMap<String, Object> outputlist) {
            this.icv = icv;
            if ((false == Pyjama.omp_get_nested()) && (Pyjama.omp_get_level() > 0)) {
                this.OMP_threadNumber = 1;
            }else {
                this.OMP_threadNumber = thread_num;
            }
            icv.currentParallelRegionThreadNumber = this.OMP_threadNumber;
            this.OMP_inputList = inputlist;
            this.OMP_outputList = outputlist;
            this.OMP_barrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_CurrentParallelRegionBarrier = new CyclicBarrier(this.OMP_threadNumber);
            icv.OMP_orderCursor = new AtomicInteger(0);
            //#BEGIN shared variables initialised here
            counter = (int[])OMP_inputList.get("counter");
            //#END shared variables initialised here
        }

        private void updateOutputListForSharedVars() {
            //BEGIN update outputlist
            OMP_outputList.put("counter",counter);
            //END update outputlist
        }
        class MyCallable implements Callable<ConcurrentHashMap<String,Object>> {
            private int alias_id;
            private ConcurrentHashMap<String, Object> OMP_inputList;
            private ConcurrentHashMap<String, Object> OMP_outputList;
            //#BEGIN firstprivate reduction variables defined here
            //#END firstprivate reduction variables  defined here
            void setBarrier() {
                try {OMP_barrier.await();}
                catch (InterruptedException e) {e.printStackTrace();}
                catch (BrokenBarrierException e) {e.printStackTrace();}
            }
            MyCallable(int id, ConcurrentHashMap<String,Object> inputlist, ConcurrentHashMap<String,Object> outputlist){
                this.alias_id = id;
                this.OMP_inputList = inputlist;
                this.OMP_outputList = outputlist;
                //#BEGIN firstprivate reduction variables initialised here
                //#END firstprivate reduction variables initialised here
            }

            @Override
            public ConcurrentHashMap<String,Object> call() {
                InternalControlVariables currentThreadICV = new InternalControlVariables(icv);
                currentThreadICV.currentThreadAliasID = this.alias_id;
                PjRuntime.setCurrentThreadICV(currentThreadICV);

                
                /****User Code BEGIN***/
                {//#GEN#[-1]#PJ#
                    counter[0]++;//#GEN#[-1]#PJ#
                }
                /****User Code END***/
                //BEGIN reduction procedure
                //END reduction procedure
                setBarrier();
                if (0 == this.alias_id) {
                    updateOutputListForSharedVars();
                }
                return null;
            }
        }
        public void runParallelCode() {
            for (int i = 1; i <= this.OMP_threadNumber-1; i++) {
                Callable<ConcurrentHashMap<String,Object>> slaveThread = new MyCallable(i, OMP_inputList, OMP_outputList);
                PjRuntime.submit(slaveThread);
            }
            Callable<ConcurrentHashMap<String,Object>> masterThread = new MyCallable(0, OMP_inputList, OMP_outputList);
            try {
                masterThread.call();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
//#GEN#[-1]#PJ#
}//#GEN#[-1]#PJ#
