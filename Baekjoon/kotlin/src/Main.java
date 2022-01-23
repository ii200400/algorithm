import java.util.*;

class Abc{
    private Abc(){}
    public static void work() {}
}

interface Runnable{
    void run();
}
class MyThread implements Runnable{
    public void run(){} // public만 가능
}

class Employee {
    String name = "Hello~";
    public String toString(){return name;}
    public static void main(String[] args){
        Employee e = new Employee();
        System.out.println(e);
    }
}

class Test{
    public static int modify(int n){
        ++n;
        return n;
    }
    public static void main(String[] args){
        int n=50;
        modify(n);
        System.out.println(n);
    }
}

class Employee2 {
    Employee2(){ System.out.println("cc");}
    void work(){System.out.println("ww");}
}

class Pro{
    void info() {
        System.out.println("w1");
    }
}

class TV extends Pro{
    void info() {
        super.info();
        System.out.println("w2");
    }
}

public class Main {

    static boolean t(){
        System.out.println("참");
        return true;
    }
    static boolean f(){
        System.out.println("거짓");
        return true;
    }

    public static void main(String[] args) {
        class Employee{
            void work(){System.out.println("w1");}
        }
        class PartE extends Employee{
            void work(){System.out.println("w2");}
            void work2(){}
        }

        new Employee2();

        int[] k = {1,2,3,4,5};
        for (int a3: k){
            if (a3<3) System.out.println(a3+" ");
        }

        for (int a3: k){
            if (a3<3) {
                System.out.println(a3+" ");
            }
        }

        int jumsu = 89;
        switch (jumsu/10){
            case 10:
            case 9: System.out.print("A");
            case 8: System.out.print("B");
            case 7: System.out.print("C");
            default: System.out.print("F");
        }

        int k1 = 5;
        if (++k1>5 && k1++ == 6){
            k1 = k1+10;
        }
        System.out.println(k1);

        Employee ee = new PartE();
        ee.work();

        double n3 = 4.5+17%4;
        System.out.println(n3);

        Set<String> set = new TreeSet<>();
        set.add("서울");
        set.add("구미");
        set.add("광주");
        set.add("대전");
        set.add("부울경");
        set.add("서울");
        System.out.println(set);

        TV tv = new TV();
        tv.info();

        int a = 10;
        int b = a++;
        int c = b++;
        int d = ++c;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

//        String[] foods = new String[] {"햅", "피", "김"};
//        System.out.println(foods[3]);

        if (t() || f()){
            System.out.println("실");
        }

        int a1 = 100;
        double d1 = 10;
        System.out.println(a1/d1);

        int[] n = {5,6,7,8,9,10};
        int total = 0;
        for(int a2 : n){
            if (a2 % 2 == 0) total += a2;
        }
        System.out.println(total);

//        int n2 = 17/4+3.5;
//        System.out.println(n2);

        System.out.println(method("Im", 123));

        int int1 = 1;
        int x = 5, y = 6, z = 50;
        double double1 = 1.0;
        float float1 = 1.0f;
        char ch = '1';
//        char cha = "1";
        boolean bool = true;
        final int int2 = 1; //  val == final
//        int2 = 2;

        int myInt = 9;
        double myDouble = myInt; // Automatic casting: int to double
        System.out.println(myDouble);

        double myDouble2 = 9.78d;
        int myInt2 = (int) myDouble; // Manual casting: double to int

        System.out.println(myDouble2);   // Outputs 9.78
        System.out.println(myInt2);      // Outputs 9

        System.out.println(Math.max(5, 10));
        System.out.println(Math.sqrt(myDouble));

        Math.abs(-4.7);
        Math.random();

        System.out.println("------------------------");

        int time = 20;
        String result = (time < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

        int day = 4;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("what ever~");
        }

        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
        }
        do {
            System.out.println(i);
            i++;
        }
        while (i < 5);

        for (int ii = 0; ii < 5; ii+=2) {
            System.out.println(ii);
        }

        System.out.println("----------------------------------");

        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"};
        for (String s : cars) {
            System.out.println(s);
        }

        int[] myNum = {10, 20, 30, 40};
        int[][] myNumbers = { {1, 2, 3, 4}, {5, 6, 7} };
        for (int i3 = 0; i3 < myNumbers.length; ++i3) {
            for(int j = 0; j < myNumbers[i3].length; ++j) {
                System.out.println(myNumbers[i3][j]);
            }
        }

        LinkedList<Integer> link = new LinkedList();
        link.add(1);
        link.add(3);
        link.add(5);
        System.out.println(link);

        System.out.println("-input----------------------------------");

        Scanner obj = new Scanner(System.in);
        System.out.println("Enter username");
        String userName = obj.nextLine();
        System.out.println(userName);
        int test = obj.nextInt();
        System.out.println(test);

        HashMap<String, String> capitalCities = new HashMap();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("USA", "Washington DC");

        for (String str2 : capitalCities.keySet()) {
            System.out.println("key: " + str2 + " value: " + capitalCities.get(str2));
        }
    }

    static String method(String str, int i){
        return "str: " + str + " i: " + i;
    }
}