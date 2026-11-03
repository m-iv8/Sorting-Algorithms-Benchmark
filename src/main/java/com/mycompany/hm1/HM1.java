
package com.mycompany.hm1;

public class HM1 {

    public static void selection_sort(int[] data,int n){
        ///////////////////////////////// دالة   selection_sort
        int i, j, smallest;
        int temp;

        if (n < 2) {
        return;
                   }

        for (i = 0; i < n - 1; i++) {

            smallest = i;

        for (j = i + 1; j < n; j++) {

            if (data[smallest] > data[j]) {
                smallest = j;
            }
        }

        temp = data[i];
        data[i] = data[smallest];
        data[smallest] = temp;
    }   
    }
   ////////////////////////////////////////////////////////////دالة insertion_sort
    public static void insertion_sort(int []data,int x){
    
        int i, j;
        int temp;
        
        if (x < 2) return; 
        
            for (i = 1; i < x; ++i) {
            
            temp = data[i];
            
            for (j = i; j > 0 && data[j - 1] > temp; --j) {
                    data[j] = data[j - 1]; 
            }
            
             data[j] = temp;
        }
          
    }
///////////////////////////////////////////////////////////////////دالة bubble_sort
        public static void bubble_sort(int []data,int n){
        
        int i, j;
        int temp;
        boolean swapped = true;

        if (n < 2) {
            return;
        }

        for (i = 0; swapped && i < n - 1; i++) {

            swapped = false;

            for (j = 0; j < n - 1; j++) {

                if (data[j] > data[j + 1]) {

                    temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;

                    swapped = true;
                }
            }
        } 
        
        }  
  ///////////////////////////////////////////////////////////////// دالةquickSort            
    public static void quickSort(int A[], int n) {
      quickSort(A, 0, n - 1);
    }

    public static void quickSort(int A[], int left, int right) {

      if (left >= right)
        return;

      int middle = partition(A, left, right);

      quickSort(A, left, middle - 1);
      quickSort(A, middle + 1, right);
    }

    public static int partition(int A[], int left, int right) {
    
    int randomIndex = left + new java.util.Random().nextInt(right - left + 1);
    int tempR = A[randomIndex];
    A[randomIndex] = A[left];
    A[left] = tempR;
    
    int x = A[left];
    int i = left;

    for (int j = left + 1; j <= right; j++) {

        if (A[j] < x) {
            i++;

        int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    int temp = A[i];
      A[i] = A[left];
      A[left] = temp;

      return i;
    }   
///////////////////////////////////////////////////////////دالة mergeSort

    public static void mergeSort(int A[], int n) {
       mergeSort(A, 0, n - 1);
    }

    public static void mergeSort(int A[], int left, int right) {

      if (left >= right)
          return;

      int middle = (left + right) / 2;

      mergeSort(A, left, middle);
      mergeSort(A, middle + 1, right);

      merge(A, left, middle, right);
}

    public static void merge(int A[], int left, int middle, int right) {

       int n1 = middle - left + 1;
       int n2 = right - middle;

       int L[] = new int[n1];
       int R[] = new int[n2];

       for (int i = 0; i < n1; i++)
           L[i] = A[left + i];

       for (int j = 0; j < n2; j++)
           R[j] = A[middle + 1 + j];

       int i = 0, j = 0, k = left;

       while (i < n1 && j < n2) {

           if (L[i] < R[j])
             A[k++] = L[i++];
           else
             A[k++] = R[j++];
    }

        while (i < n1)
           A[k++] = L[i++];

        while (j < n2)
           A[k++] = R[j++];
    }
     
   ////////////////////////////////////////////////////////////////////////////             
    public static void main(String[] args) {
        ///////////////////////////////////////مصفوفة عشواىية 
            int[] array = java.util.concurrent.ThreadLocalRandom.current()
              .ints(0,100000)
              .distinct()
              .limit(100000)
              .toArray();  
        
        ////////////////////////////////////////////////////////مصفوفة مرتبة تصاعديا
                   
            int[] sortedArray = java.util.stream.IntStream.range(0, 100000)
              .toArray();
    
        ////////////////////////////////////////////////////////مصفوفة مرتبة عكسيا
        
            int[] reversedArray = java.util.stream.IntStream.range(0, 100000)
              .boxed()
              .sorted(java.util.Collections.reverseOrder())
              .mapToInt(Integer::intValue)
              .toArray();
        
        ///////////////////////////////////////////////////////////////////////مصفوفة مرتبة جزىيا
        
            int[] partiallySortedArray = java.util.stream.IntStream.range(0, 100000).toArray();

            java.util.Random rand = new java.util.Random();
            for (int i = 99999; i >= 80000; i--) {
            int randomIndex = 80000 + rand.nextInt(i - 80000 + 1);
    
            int temp = partiallySortedArray[i];
            partiallySortedArray[i] = partiallySortedArray[randomIndex];
            partiallySortedArray[randomIndex] = temp;
                                                      }
            long start,end;
            //////////////////////////استدعات الدوال
            //////////////يتم استدعاء الدالة اربعة مرات كل مرة مصفوفة مختلفة تمثل سيناريو
          System.out.println("+++++++++++++++++++++++(Implementing the first algorithm selectionsort)+++++++++++++++++++++++++++");
           
          start=System.nanoTime();
            selection_sort(array.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the first scenario (random matrix)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
           selection_sort(sortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the second scenario (array sorted in ascending order)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
           selection_sort(reversedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the third scenario (reversely sorted array)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
           
          start=System.nanoTime();
           selection_sort(partiallySortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the fourth scenario (partially sorted array, 80%)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s"); 
           
          
           System.out.println("  ");
           System.out.println("  ");
           
           System.out.println("+++++++++++++++++++++++(Implementing the second algorithm(insertionsort))+++++++++++++++++++++++++++");
          
           start=System.nanoTime();
             insertion_sort(array.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the first scenario (random matrix)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
            insertion_sort(sortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the second scenario (array sorted in ascending order)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
           insertion_sort(reversedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the third scenario (reversely sorted array)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
           
          start=System.nanoTime();
           insertion_sort(partiallySortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the fourth scenario (partially sorted array, 80%)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s"); 
           
          System.out.println("  ");
          System.out.println("  ");
           
          System.out.println("+++++++++++++++++++++++(Implementing the third algorithm(bubblesort))+++++++++++++++++++++++++++");
          
          start=System.nanoTime();
             bubble_sort(array.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the first scenario (random matrix)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
             bubble_sort(sortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the second scenario (array sorted in ascending order)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
            bubble_sort(reversedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the third scenario (reversely sorted array)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
           
          start=System.nanoTime();
            bubble_sort(partiallySortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the fourth scenario (partially sorted array, 80%)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s"); 
           
          
          System.out.println("  ");
          System.out.println("  ");
           
          System.out.println("+++++++++++++++++++++++(Implementing the fourth algorithm(quickSort))+++++++++++++++++++++++++++");
          
          start=System.nanoTime();
              quickSort(array.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the first scenario (random matrix)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
              quickSort(sortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the second scenario (array sorted in ascending order)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
             quickSort(reversedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the third scenario (reversely sorted array)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
           
          start=System.nanoTime();
             quickSort(partiallySortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the fourth scenario (partially sorted array, 80%)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s"); 
           
          
          System.out.println("  ");
          System.out.println("  ");
           
          System.out.println("+++++++++++++++++++++++(Implementing the fifth algorithm(mergeSort))+++++++++++++++++++++++++++");
          
           
           start=System.nanoTime();
              mergeSort(array.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the first scenario (random matrix)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
               mergeSort(sortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the second scenario (array sorted in ascending order)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
          
          start=System.nanoTime();
              mergeSort(reversedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the third scenario (reversely sorted array)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s");
           
          start=System.nanoTime();
              mergeSort(partiallySortedArray.clone(),100000);
          end=System.nanoTime();
          System.out.println("Execution time using the fourth scenario (partially sorted array, 80%)=  "+(end-start)/1000+"ms    "+(end-start)/1000000000.0+"s"); 
                
     }
     
}
