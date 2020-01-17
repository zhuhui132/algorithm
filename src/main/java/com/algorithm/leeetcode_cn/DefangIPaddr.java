package com.algorithm.leeetcode_cn;

public class DefangIPaddr {
    public static void main(String[] args) {
        int[] address = new int[]{3,6,5,1,8};
     //   System.out.println(new DefangIPaddr().defangIPaddr(address));
    }
    public String defangIPaddr(String address) {

        return address.replace(".","[.]" );
    }


//    public int defangIPaddr(int[] address) {
//        if (address.length == 0) return 0;
//        int[] reulst = new int[(address.length+1)*(address.length)/2];
//        int[][] hah = new int[address.length][address.length];
//        int sun = 0;
//        int sum = 0;
//        ArrayList<Integer> list = new ArrayList <>();
//        for (int i = 0;i<address.length;i++){
//            for (int j =i;j<address.length;j++){
//                hah[i][j] = sum+address[j];
//                sum =hah[i][j];
//                list.add(hah[i][j]);
//            }
//            sum = 0;
//        }
//        System.out.println(list);
//        ArrayList<Integer> list2 = new ArrayList <>();
//        for (Integer i:list){
//            if (i %3==0){
//                list2.add(i);
//            }
//        }
//        Integer[] algorithm = (Integer[])list2.toArray(new Integer[list2.size()]);
//
//        Arrays.sort(algorithm);
//        return algorithm[algorithm.length-1];
//
//
//
//
//
//       // System.out.println(list.get(list.size()-1));
//       // return (int) list.get(list.size()-1);
//    }
}