class MyThread extends Thread {

    String name;
    float arr[];
    int differ;


    MyThread(String name, float[] arr) {
        this.name = name;
        this.arr = arr;

  }

    @Override
    public void run() {
        if (name == "a1") differ = 0;
        else if (name == "a2") differ = 5000000;
        for(int i = 0; i<arr.length; i++) {
            arr[i]=(float)(arr[i] * Math.sin(0.2f+ (i+differ)/5)* Math.cos(0.2f+ (i+differ)/5) * Math.cos(0.4f + (i+differ)/2));
        }
        System.out.println("a half of array 2 completed");
    }

}
