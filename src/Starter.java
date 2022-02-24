import java.util.Random;
//T.aoyan 2022-2-24
//冒泡排序法以及优化版的冒泡排序法
//bubbleSort1 和 bubbleSort2
public class Starter {
    public static void main(String[] args) {
           //生成一个随机数机器
           Random random = new Random();
           //定义一个数组
           int[] a = new int[50000];
           //给数组的每一个元素赋值,从0-199随机取一个值
           for(int i = 0; i < a.length; i++) {a[i] = random.nextInt(200000);}
           //打印数组元素
           for (int element:a) {System.out.println(element);}
           //进行排序
           //bubbleSort1(a);
           //使用优化后的冒泡排序法进行排序
           int count = bubbleSort2(a);
           //打印排序后的数组a
           for (int element:a) {System.out.println(element);}
           System.out.println("一共比较了" + count + "轮！");

    }
    //第一种冒泡排序法
    public static void bubbleSort1(int[] a){
        //表示已经开始排序
        System.out.println("进行冒泡排序算法！");
        //设置一个临时交换数据的整型变量
        int temp;
        //进行算法遍历
        for(int i = 0; i < a.length; i++){
            //进行数组元素的两两比较 即第j个元素和第j+1个元素进行比较
            //因为第二个元素取得是j+1所以j的取值要长度减一，避免j+1越界
            //例如数组有5个元素，那么下标是0-4，如果取j < a.length，即j<5的话
            //j取4时,j+1 = 5，越界，那么为什么还要减i呢，因为每完成一次两两比较
            //必然把比较范围中最大的那个数字放在了最后，比较一次放1个数，比较2次放第2个数
            for(int j = 0; j < a.length - 1 - i; j++){
                //如果第j个元素大于第j+1个元素，这两个元素交换
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    //第二种优化后的冒泡排序法
    public static int bubbleSort2(int[] a){
        //声明算法开始
        System.out.println("冒泡排序算法开始!");
        //设置一个计数器，用于计算外循环进行了多少次
        int count = 0;
        //设置一个整型变量用于交换数据使用
        int temp;
        //设置一个排序是否完成的标志,如果某一轮两两比较中，没有进行交换，说明排序已经完成，退出循环。
        boolean ifEnd = true;
        //开始排序
        for(int i = 0; i < a.length; i++){
            count = count + 1;
            ifEnd = true;//每次开始两两比较之前，假设已经排序完成
            for(int j = 0; j < a.length - 1 - i; j++){
                if(a[j] > a[j + 1]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    //如果进行了交换，说明排序还没有完成
                    ifEnd = false;
                }
            }
            //一轮两两比较结束后进行判断是否退出循环
            if(ifEnd == true){break;}
        }
        return count;
    }
}
