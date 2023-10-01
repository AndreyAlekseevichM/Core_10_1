public class JvmComprehension { // класс JvmComprehension передается в Metaspace используя ClassLoader'ы.

    public static void main(String[] args) { // в стэке создается фрейм main.
        int i = 1;                      // 1 в фрейме main создается переменная i со значением 1.
        Object o = new Object();        // 2 в куче создается объект Object, а во фрейме main создается переменная Object o со ссылкой на Object в куче.
        Integer ii = 2;                 // 3 в куче создается переменная ii со значением 2.
        printAll(o, i, ii);             // 4 в стэке создается фрейм printAll. В него будет передана int i, а также запишутся ссылки на Object o и Integer ii из кучи.
        System.out.println("finished"); // 7 в стэке создается фрейм println со ссылкой на созданный в куче объект String со значением "finished".
    }
    // В процессе выполнения программы Garbage Collection периодически собирает объекты из памяти которые больше не используются.
    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 в куче создается Integer со значением 700, а во фрейме printAll создается переменная uselessVar со ссылкой на кучу (где находится созданный Integer со значением 700).
        System.out.println(o.toString() + i + ii);  // 6 в стэке создается фрейм println, передается int i и ссылки на Object o и Integer ii. В стэке созается фрейм toString.
    }
}