package com;

public class Diditest {

    public static void main(String[] args) {
        Diditest diditest = new Diditest();

        int[] a = new int[]{1,4,1};
        int[] b = new int[]{2,4,6};

        int[] temp = diditest.merge(a,b);
        for (int y: temp) {
            System.out.println(y);
        }

    }
    //俩个无序数据
    public int[] merge(int[] arrA ,int[] arrB){
        if (arrA.length ==0 || arrB.length  == 0) return  null;
        int[] resut = new int[arrA.length +arrB.length];
        System.arraycopy(arrA,0, resut,0,arrA.length);
        System.arraycopy(arrB ,0,resut,arrA.length,arrB.length);
//        for (int y: resut) {
//            System.out.println(y);
//        }
        for (int i = 0;i<resut.length;i++){
            for (int j = 0; j < resut.length; j++) {
                if (resut[i]>=resut[j]){
                    int temp = resut[i];
                    resut[i] = resut[j];
                    resut[j] = temp;
                }
            }
        }
      return resut;
    }
}
