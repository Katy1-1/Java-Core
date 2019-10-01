public class methods {
    private static final int size = 10000000;
    private static final int h = size/2;
    private static float arr[] = new float[size];

        public static void main(String[] args) {
            for(int i = 0; i<arr.length; i++) {
                arr[i]=1;
            }
            method1();
            method2();
        }

        public static void method1 () {
            long a, b;

            a = System.currentTimeMillis();

            for(int i = 0; i<arr.length; i++) {
                arr[i]=(float)(arr[i] * Math.sin(0.2f+ i/5)* Math.cos(0.2f+ i/5) * Math.cos(0.4f + i/2));
            }

            b = System.currentTimeMillis();

            System.out.println("array 1 completed");
            System.out.println("Время выполнения первого метода " + (b-a));
        }

        public static void method2 () {
            float a1[] = new float[h];
            float a2[] = new float[h];
            long a, b;

            a = System.currentTimeMillis();

            System.arraycopy(arr,0,a1,0,h);
            System.arraycopy(arr,h,a2,0, h);

            try {
                MyThread mt1 = new MyThread("a1", a1);
                MyThread mt2 = new MyThread("a2", a2);
                mt1.start();
                mt2.start();
                mt1.join();
                mt2.join();
            }
            catch (InterruptedException e) {
                System.out.println("Ошибка");
            }

            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);

            b = System.currentTimeMillis();

            System.out.println("Время выполнения второго метода " + (b-a));
        }
    }
