package Array;

import java.util.Scanner;


public class Array2D {
    int[][] arr;
    Scanner sc = new Scanner(System.in);

    //To Take input
    public Array2D(int row,int col){
        arr = new int[row][col];
        for(int i=0;i<row;i++){
            System.out.println("For "+i+" row:");
            for(int j=0;j<col;j++){
                System.out.print("Enter "+j+" column value:");
                arr[i][j]=sc.nextInt();
            }
            System.out.println();
        }
    }

    public Array2D(String inputString){
        String[] rowArr = inputString.substring(
            1,inputString.length()-1
        ).split(",\n");
        arr = new int[rowArr.length][];
        for(int i=0;i<rowArr.length;i++){
            String[] colArr = rowArr[i].substring(
                1,rowArr[i].length()-1
            ).split(",");
            arr[i] = new int[colArr.length];
            for(int j=0;j<colArr.length;j++)arr[i][j]=Integer.parseInt(colArr[j]);
        }
    }

    //To Dispaly as a string
    @Override
    public String toString(){
        String str = "[";
        for(int i=0;i<arr.length;i++){
            str += "[";
            for(int j=0;j<arr[i].length;j++)
                str+=arr[i][j] + (j==arr[i].length - 1?"]":",");
            str+=(i==arr.length-1)?"]":","+"\n ";
        }
        return str;
    }

    //Wave Print
    public void wavePrint(){
        for(int i=0;i<arr.length;i++){
            if(i%2==0)
                for(int j=0;j<arr[i].length;j++)System.out.print(arr[i][j]+" ");
            else
                for(int j=arr[i].length-1;j>=0;j--)System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }

    //Spiral Print
    public void spiralPrint(){
        int direction = 0;
        int left=0;
        int top = 0;
        int right = arr[top].length-1;
        int bottom = arr.length - 1;
        while(top<=bottom && left<=right){
            if(direction==0){//left to right
                for(int j = left;j<=right;j++){
                    System.out.print(arr[top][j]+" ");
                }
                top++;
            }
            else if(direction==1){//top to bottom
                for(int i = top;i<=bottom;i++){
                    System.out.print(arr[i][right]+" ");
                }
                right--;
            }
            else if(direction==2){//right to left
                for(int j = right;j>=left;j--){
                    System.out.print(arr[bottom][j]+" ");
                }
                bottom--;
            }
            else if(direction==3){//bottom to top
                for(int i = bottom;i>=top;i--){
                    System.out.print(arr[i][left]+" ");
                }
                left++;
            }
            direction = (direction==3)?0:direction+1;
        }
    }
}
