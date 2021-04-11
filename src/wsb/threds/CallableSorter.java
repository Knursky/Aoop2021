package wsb.threds;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableSorter implements Callable<List<Integer>> {
    private final List<Integer> list = new ArrayList<>();
    public CallableSorter(List<Integer> list) {
        this.list.addAll(list);

    }
    @Override
    public List<Integer> call() throws Exception {
        boolean sorted = false;
        int temp;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < list.size() -1; i++)
            {
                if (list.get(i) > list.get(i + 1)) {
                    temp = list.get(i);
                    list.set(i, list.get(i +1));
                    list.set(i + 1, temp);
                    sorted = false;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        List<CallableSorter> callableSorters = List.of(
                new CallableSorter(List.of(8, 4, 6, 1, 3, 2, 9)),
                new CallableSorter(List.of(8, 3, 2, 9)),
                new CallableSorter(List.of(55, 7, 0, 44, 8, 4, 6, 1, 3, 2, 9)),
                new CallableSorter(List.of(3, 2, 9)));
        List<Future<List<Integer>>> futures = new ArrayList<>();
        callableSorters.forEach(callableSorter -> futures.add(executor.submit(callableSorter)));
        futures.forEach(CallableSorter::time);
    }

    private static void time(Future<List<Integer>> future) {
        Long startTime = System.currentTimeMillis();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        Long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }
}
