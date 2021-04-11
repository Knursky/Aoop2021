package wsb;
import wsb.creatures.*;
import wsb.database.Connector;
import wsb.devices.*;
import wsb.food.FoodType;

import wsb.threds.CallableCounter;
import wsb.threds.RunnableCounter;
import wsb.threds.Finisher;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) throws Exception {
//TASK8
        AnonymousComparator();}
    private static void AnonymousComparator() throws SQLException {
            List<Animal> animals = new ArrayList<>(List.of(
                    new Human(5, 1, FoodType.ALL),
                    new Human(1, 1, FoodType.ALL),
                    new Human(2, 1, FoodType.ALL),
                    new Pet("Dog", FoodType.ALL),
                    new FarmAnimal("Cow", FoodType.CROPS)
            ));

            //task11
        animals.sort((Comparator.comparingDouble(Animal::getWeight)));
        animals.forEach(System.out::println);
        }

}
   /* //task9f
    public static void main(String[] args) throws Exception {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        CallableCounter cage = new CallableCounter();
        CallableCounter liuKang = new CallableCounter();

        System.out.println("test1");
       Future<Double> cageHP = executor.submit(cage);
       Future<Double> liuKangHP = executor.submit(liuKang);
        System.out.println("test2");
        System.out.println("test2");
        System.out.println("test2");
        System.out.println("test2");
        System.out.println(cageHP.get());
        System.out.println("test3");
        System.out.println(liuKangHP.get());

executor.shutdown();


*/
}}
    /*
//task9d
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    RunnableCounter subZero = new RunnableCounter();
    subZero.finisher = () -> System.out.println("you are frozen and ugly");

    RunnableCounter scorpion = new RunnableCounter();
    scorpion.finisher =  ()-> System.out.println("you are poisoned");
        executor.submit(subZero);
    executor.submit(scorpion);
    executor.shutdown();
        }
}

*/

    //task9c
    /*
    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
    RunnableCounter subZero = new RunnableCounter();
    subZero.finisher = new Finisher() {
        @Override
        public void finishHim() {
            System.out.println("you are frozen and ugly");
        }
    };
    RunnableCounter scorpion = new RunnableCounter();
    scorpion.finisher = new Finisher() {
        @Override
        public void finishHim() {
            System.out.println("you are poisoned");
        }
    };


    executor.submit(subZero);
    executor.submit(scorpion);
    executor.shutdown();
}


}*/

/*Task9b
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        executor.submit(new SubZero());
        executor.submit(new Scorpion());
        executor.shutdown();
    }
}*/
/*task9a
    public static void main(String[] args) {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);

        executor.submit(new RunnableCounter());
        executor.submit(new RunnableCounter());
        executor.submit(new RunnableCounter());
        executor.shutdown();

    }
}*/

    /*
    public static void main(String[] args) throws Exception {

        Map<String, Car> carMap = new HashMap<>();
        carMap.put("Polonez", new DieselCar("FSO", "Caro", 1976, 1.5));
        carMap.put("Mercedes", new DieselCar("Mercedes", "okular", 1998, 2.5));
        carMap.put("Audi", new DieselCar("Audi", "A4", 2002, 4.0));
        carMap.put("BMW", new DieselCar("BMW", "M5", 2020, 5.0));

        carMap.values().stream().map(Car::getModel).sorted().forEach(System.out::println);
    }


    //Create a HashMap with String model as key and Car as value
    //	2. Add a few cars into a map.
    //	3. Print it in alphabetical order of models.
    private static void pileOfCode() throws Exception {
        Connector.connect();

        Pet dog = new Pet("dog", FoodType.MEAT);
        dog.name = "Akita";

        Phone iphone = new Phone("Apple", "6s", 4.7, Phone.OperatingSystem.iOS);

        Human me = new Human(3, Gender.MALE, FoodType.ALL);
        me.firstName = "Kacper";
        me.lastName = "Warda";
        me.pet = dog;
        me.mobile = iphone;


        Car dirtyOne = new DieselCar("fiat", "bravo", 2014, 1.6);
        dirtyOne.plates = "GDA2314";
        me.setCar(dirtyOne, 0);
        System.out.println(me.getCar(0).producer + " " + me.getCar(0).model + " " + me.getCar(0).plates);


        iphone.turnOn();
        dirtyOne.turnOn();


        Human myWife = new Human(4, Gender.FEMALE, FoodType.ALL);
        myWife.firstName = "Karolina";
        myWife.lastName = "Warda";
        myWife.setCar(new ElectricCar("Tesla", "S", 2019), 0);


        System.out.println(me.getCar(0));
        System.out.println(me);

        Human brotherInLaw = new Human(2, Gender.MALE, FoodType.ALL);
        brotherInLaw.firstName = "Mateusz";
        brotherInLaw.lastName = "Skiba";

//        me.getCar(0).sell(brotherInLaw, me, 100.0);
        System.out.println("Now I have " + me.cash + "$");
        System.out.println("Now he has " + brotherInLaw.cash + "$");
        System.out.println("My car is now: " + me.getCar(0));
        System.out.println("His car is now: " + brotherInLaw.getCar(0));


        String[] names = {"Kacper", "Jakub", "Artur"};
        for (String name : names) {
            System.out.println("my name is " + name);
        }

        names = new String[4];

        Set<Object> humans = new TreeSet<>();

        humans.add(me);
        humans.add(myWife);
        humans.add(me);
        humans.add(brotherInLaw);
        humans.add(new Animal("dog", FoodType.ALL));


        System.out.println(me.getCar(0).value);

        App facebook = new App("facebook", "latest", 0.0);
        App spotify = new App("spotify", "2.3.41", 14.0);
        App messenger = new App("messenger", "latest", 0.0);

        me.mobile.installAnApp(facebook, me);
        me.mobile.installAnApp(spotify, me);
        System.out.println(me.mobile.applications);

        System.out.println(me.mobile.isInstalled(facebook));
        System.out.println(me.mobile.isInstalled(messenger));
        System.out.println(me.mobile.isInstalled("facebook"));
        System.out.println(me.mobile.isInstalled("messenger"));
    }
}*/