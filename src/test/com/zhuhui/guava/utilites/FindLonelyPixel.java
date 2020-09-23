package com.zhuhui.guava.utilites;

public class FindLonelyPixel {
    public int findLonelyPixel(char[][] picture) {
        int rowsCnt = 0, colsCnt = 0;

        // 遍历每一行，统计符合要求的行数
        int rows = picture.length, cols = picture[0].length;
        for (int i = 0; i < rows; i++) {
            boolean flag = false;
            for (int j = 0; j < cols; j++) {
                if (picture[i][j] == 'B') {
                    if (flag) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
            }
            if (flag) {
                rowsCnt++;
            }
        }
        // 遍历每一列，统计符合要求的列数
        for (int j = 0; j < cols; j++) {
            boolean flag = false;
            for (int i = 0; i  < rows; i++) {
                if (picture[i][j] == 'B') {
                    if (flag) {
                        flag = false;
                        break;
                    }
                    flag = true;
                }
            }
            if (flag) {
                colsCnt++;
            }
        }

        // 返回符合要求的行数、列数的小的那个值
        return Math.min(colsCnt, rowsCnt);
    }
}

//    }
//        int row = picture.length,colo = picture[0].length;
//        Boolean flag =true;
//        int count = 0;
//        for (int i=0;i <row;i++){
//            for (int j =0;j<colo;j++){
//                if (picture[i][j] == 'B'){
//                    for (int k = 0;k<row;k++ ){
//                        if (k != i && picture[k][j] =='B'){
//                            flag =false;
//                            break;
//                        }
//                    }
//                    if (false == true){
//                        count++;
//                    }
//
//                }
//            }
//        }
//        return count;
//    }
