public static void main(String[] args) {
        int[] array={6,9,4,8,5,2,3};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void selectSort(int[] array) {
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j]<array[i]){
                    int tmp=array[j];
                    array[j]=array[i];
                    array[i]=tmp;
                }
            }
        }
    }
    public  static void insertSort(int[]array) {
        int tmp=0;
        int j=0;
        for(int i=1;i<array.length;i++) {
            tmp=array[i];
            for (j=i-1;j>=0;j--) {
                if(array[i]<array[j]){
                    array[j+1]=array[j];
                    }
                    else{
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }
    public  static void bubbleSort(int[] array) {
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-1-i;j++) {
                if(array[j]>array[j+1]) {
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                }
            }
        }
    }