

package com.mycompany.hm1;


public class HM1 {

    public static void insertion(int array[],int x){
    
        int i, j;
        int temp;
        
        if (x < 2) return; 
        
            for (i = 1; i < x; ++i) {
            
            temp = array[i];
            
            
            for (j = i; j > 0 && array[j - 1] > temp; --j) {
                    array[j] = array[j - 1]; 
            }
            
             array[j] = temp;
        }
          
    }

         
    public static void main(String[] args) {
        
        int[] array = java.util.concurrent.ThreadLocalRandom.current()
                    .ints(100000,0,100000) 
                    .toArray();    
        
     long start1=System.nanoTime();
     insertion(array,100000) ;  
     long end1=System.nanoTime();
     long time1=end1 -start1;
     
     long start2=System.nanoTime();
     insertion(array,100000) ;  
     long end2=System.nanoTime();
     long time2=end2 -start2;
     
     
     long timedifference=time1-time2;
     
     System.out.println(time1); 
     System.out.println(time2); 
     System.out.println(timedifference); 
     }
     
 
}
