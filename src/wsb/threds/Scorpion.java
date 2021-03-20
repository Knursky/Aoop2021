package wsb.threds;

public class Scorpion extends RunnableCounter {
    private void finishHim(){
        System.out.println("You are poisoned Muahahahha!");
    }

    @Override
    public void run() {
super.run();
finishHim();
    }
}
