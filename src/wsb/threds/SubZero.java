package wsb.threds;

public class SubZero extends RunnableCounter {
    private void finishHim(){
        System.out.println("you are frozen!(without a fancy dress");
    }

    @Override
    public void run() {
super.run();
        finishHim();
    }
}
