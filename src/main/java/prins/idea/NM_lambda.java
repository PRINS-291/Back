package prins.idea;

/**
 * 这个是 回忆 匿名内部类 lambda的用法 还有方法引用
 */
abstract class Human{
    String name;
    abstract void say();
}

class Father extends Human
{
    Father(String name)
    {
        this.name = name;
    }
    @Override
    void say() {
        System.out.println(name);
    }

    void add(int a, int b)
    {
        System.out.println(a+b);
    }
}

interface Fun
{
    void say();
}

interface FunWithArgs
{
    void say(int a, int b);
}

interface Fun2
{
    void say();
    void say2(int a,int b);
}

public class NM_lambda {


    public static void main(String[] args) {
        Human h = new Father("wg"); // 这是多态
        h.say();

        Father father= new Father("wzih"){
            void say()
            {
                System.out.println("匿名内部类 实质是声明类的继承 使用了多态");
            }
        };

        father.say();

        Fun f = new Fun() {
            @Override
            public void say() {
                System.out.println("也是匿名内部类  但是 实现的接口  声明为接口类型");
            }
        };
        f.say();
        System.out.println(f.getClass());

        Fun ff = () -> System.out.println("lambda表达式 用于函数式编程   实现的接口  声明为接口类型");
        ff.say();

        Fun2 ff2 = new Fun2() {
            @Override
            public void say() {
                System.out.println("两个方法的接口 匿名内部类 照常用");
            }

            @Override
            public void say2(int a,int b) {

            }
        };
        ff2.say();

        //Fun2 ff22 = () -> System.out.println();  多个方法肯定不行 lambda就方便找一个格式一样的
        //Fun2 f3 = (a,b) -> System.out.println(a*b);  没用的 多个就是不行  哪怕参数量不一样

        FunWithArgs f4 = (a,b) -> System.out.println(a*b);
        f4.say(4,5);

        // 下面是对lambda的思考
        // 1. 他是 实现函数式接口（就是一个抽象方法） 的新写法
        interface Run
        {
            void add(int a,int b);
        }
        Run r = (m,n) -> {
            for (int i=0;i<=5;i++)
            {
                m += n*i;
            }
            System.out.println(m+" "+n);
        };
        r.add(5,6);


        // 方法引用 是lambda的简化  情况是：想使用一个已存在的方法（当然 肯定在某个类里）;; 但是 声明的类型得自己定义一个 与要用的方法格式一样

        class Test
        {
            static void add(int a,int b)
            {
                System.out.println(a+b);
            }

            void sub(int a,int b)
            {
                System.out.println(a-b);
            }
        }

        interface My
        {
            void oi(int a, int b);
        }
        // 静态方法 的方法引用
        My my1 = (a, b) -> Test.add(a,b);
        My my2 = Test::add;

        //卡在这个 方法引用怎么使用 自己写的类的实例方法上


        interface KO
        {
            void show();
        }

        KO ko = new KO() {
            @Override
            public void show() {
                System.out.println("虽然长成 接口名 m = new 接口名（）..." +
                        "\n但是这是匿名内部类的写法  可不是跟类一样直接实例化对象");
            }
        };
        ko.show();



    }
}
