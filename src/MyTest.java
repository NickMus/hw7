

public class MyTest {
    @Test(value = 1)
    static void test1() {
        System.out.println("test 1 value 1");
    }

    @Test(value = 3)
    static void test2() {
        System.out.println("test2 value 3");
    }

    @Test(value = 6)
    static void test3() {
        System.out.println("test3 value 6");
    }

    @BeforeSuite
    static void test4() {
        System.out.println("test4 before suite");
    }

    @AfterSuite
    static void test5() {
        System.out.println("test5 after suite");
    }

    @Test(value = 2)
    static void test6() {
        System.out.println("test6 value 2");
    }
}
