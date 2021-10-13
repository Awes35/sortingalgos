package sortingproject;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @version Final 
 * @author Kollen Gruizenga and Travis Wahl
 * Sorting Project CS220
 * 
 * this class is the main driver for the program, there are 3 Sorting Algo's each accepting 
 * array, LinkedList and ArrayList as input parameters. Hence, 3 input types for each
 * Sorting Algo = 9 implementations 
 * 
 * Utilizes MyLinkedList class in package for LinkedLists
 */
public class SortingProject {

    //LIST_SIZE to be ran through algo's (across each data structure; array/LinkedList/ArrayList)
    final static int LIST_SIZE = 10;

    /**
     * main method to run execute sorting algo's
     */
    public static void main(String[] args) {
        System.out.println("Testing Sorting Group 1");
        testSort(1);
        System.out.println("\n\n\nTesting Sorting Group 2");
        testSort(2);
        System.out.println("\n\n\nTesting Sorting Group 3");
        testSort(3);

    }

    /**
     * This runs a sorting algorithm on an array, LinkedList, & ArrayList
     * creates lists using createUnsorted<List>() & prints lists
     * 
     * Calls sorting methods using the specified group & re-print lists
     *
     * @param group a number between 1 and 3 inclusive that represents the
     * sorting algorithm
     */
    private static void testSort(int group) {
        //create lists
        int[] listArray = createUnsortedListArray();
        MyLinkedList listLL = createUnsortedListLL();
        ArrayList<Integer> listDynamicArray = createUnsortedListDynamicArray();

        //print lists
        System.out.println("Prior to Sorting:");
        printArray(listArray);
        System.out.println(listLL);
        System.out.println(listDynamicArray);

        //sort lists using group
        if (group == 1) {
            sortListGroupOne(listArray);
            sortListGroupOne(listLL);
            sortListGroupOne(listDynamicArray);
        } else if (group == 2) {
            sortListGroupTwo(listArray, 0, LIST_SIZE-1);
            sortListGroupTwo(listLL, 0, LIST_SIZE-1);
            sortListGroupTwo(listDynamicArray, 0, LIST_SIZE-1);
        } else if (group == 3) {
            sortListGroupThree(listArray);
            sortListGroupThree(listLL);
            sortListGroupThree(listDynamicArray);
        } else {
            System.err.println("Error: no group " + group + " exists.");
        }

        //re-print Lists
        System.out.println("\nAfter Sorting:");
        printArray(listArray);
        System.out.println(listLL);
        System.out.println(listDynamicArray);

    }

    /**
     * creates an array of LIST_SIZE filled with random int 0-999
     *
     * @return
     */
    private static int[] createUnsortedListArray() {
        int[] ary = new int[LIST_SIZE];
        for (int i = 0; i < LIST_SIZE; i++) {
            ary[i] = (int) (Math.random() * 1000);
        }
        return ary;
    }

    /**
     * creates a MyLinkedList of LIST_SIZE filled with random int 0-999
     *
     * @return
     */
    private static MyLinkedList createUnsortedListLL() {
        MyLinkedList linkedList = new MyLinkedList();
        for (int i = 0; i < LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            linkedList.add(value);
        }
        return linkedList;
    }

    /**
     * creates an ArrayList of LIST_SIZE filled with random int 0-999
     *
     * @return
     */
    private static ArrayList<Integer> createUnsortedListDynamicArray() {
        ArrayList<Integer> dyAry = new ArrayList<Integer>();
        for (int i = 0; i < LIST_SIZE; i++) {
            int value = (int) (Math.random() * 1000);
            dyAry.add(value);
        }
        return dyAry;
    }





    /**
     * Sorts the list using RADIX SORT.
     * takes array as input
     * @param listArray
     */
    private static void sortListGroupOne(int[] listArray) {
        //create a list of stacks to represent the "bins"
        Stack<Integer>[] stacks = new Stack[10];
        for (int i=0; i<10; i++){
            stacks[i] = new Stack<Integer>();
        }
        int test = -1;//should never actually end up being -1 in the end
        for (int i=1; i<=3; i++){//loop through each digit (only dealing with 0-999)
            for(int n=0; n<listArray.length; n++){//look at every number in the array
                //determine which digit we are looking at 
                switch(i){
                    case 1: test = listArray[n]%10;
                        break;
                    case 2: test = (listArray[n]/10)%10;
                        break;
                    case 3: test = (listArray[n]/100)%10;
                        break;
                }
                //assign number to correct stack or "bin"
                switch (test){
                    case -1: break;
                    case 0: stacks[0].push(listArray[n]); 
                        break;
                    case 1: stacks[1].push(listArray[n]);
                        break;
                    case 2: stacks[2].push(listArray[n]);
                        break;
                    case 3: stacks[3].push(listArray[n]);
                        break;
                    case 4: stacks[4].push(listArray[n]);
                        break;
                    case 5: stacks[5].push(listArray[n]);
                        break;
                    case 6: stacks[6].push(listArray[n]);
                        break;
                    case 7: stacks[7].push(listArray[n]);
                        break;
                    case 8: stacks[8].push(listArray[n]);
                        break;
                    case 9: stacks[9].push(listArray[n]);
                        break;
                }
            }
            //fill back in to listArray starting with the largest number
            int index = listArray.length-1;//begin at last index 
             //empty each stack or "bin" 
            for(int j=9; j>=0; j--){
                while(!stacks[j].isEmpty()){
                    listArray[index] = stacks[j].pop();//repopulate in correct sequence
                    index--;
                }
            }
            
        }
    }

    /**
     * Sorts the list using RADIX SORT.
     * takes LinkedList as input
     * @param listLL
     */
    private static void sortListGroupOne(MyLinkedList listLL) {
        //create a list of stacks to represent the "bins"
        Stack<Integer>[] stacks = new Stack[10];
        for (int i=0; i<10; i++){
            stacks[i] = new Stack<Integer>();
        }
         int test = -1;//should never actually end up being -1 in the end
        for (int i=1; i<=3; i++){//loop through each digit (only dealing with 0-999)
            for(int n=0; n<LIST_SIZE; n++){//look at every number in the array
                //determine which digit we are looking at 
                switch(i){
                    case 1: test = listLL.getValue(n)%10;
                        break;
                    case 2: test = (listLL.getValue(n)/10)%10;
                        break;
                    case 3: test = (listLL.getValue(n)/100)%10;
                        break;
                }
                //assign number to correct stack or "bin"
                switch (test){
                    case -1: break;
                    case 0: stacks[0].push(listLL.getValue(n)); 
                        break;
                    case 1: stacks[1].push(listLL.getValue(n));
                        break;
                    case 2: stacks[2].push(listLL.getValue(n));
                        break;
                    case 3: stacks[3].push(listLL.getValue(n));
                        break;
                    case 4: stacks[4].push(listLL.getValue(n));
                        break;
                    case 5: stacks[5].push(listLL.getValue(n));
                        break;
                    case 6: stacks[6].push(listLL.getValue(n));
                        break;
                    case 7: stacks[7].push(listLL.getValue(n));
                        break;
                    case 8: stacks[8].push(listLL.getValue(n));
                        break;
                    case 9: stacks[9].push(listLL.getValue(n));
                        break;
                }
            }
            listLL.empty();
            
            //fill back in to listArray starting with the largest number
           
             //empty each stack or "bin" 
             for(int j=9; j>=0; j--){
                while(!stacks[j].isEmpty()){
                    listLL.add(stacks[j].pop());//add element in correct sequence
                }
            }
            
        }
    }

    /**
     * Sorts the list using RADIX SORT.
     * takes ArrayList as input
     * @param listDynamicArray
     */
    private static void sortListGroupOne(ArrayList<Integer> listDynamicArray) {
        //create a list of stacks to represent the "bins"
        Stack<Integer>[] stacks = new Stack[10];
        for (int i=0; i<10; i++){
            stacks[i] = new Stack<Integer>();
        }
        
        int test = -1;//should never actually end up being -1 in the end
        for (int i=1; i<=3; i++){//loop through each digit (only dealing with 0-999)
            for(int n=0; n<listDynamicArray.size(); n++){//look at every number in the array
                //determine which digit we are looking at 
                switch(i){
                    case 1: test = (listDynamicArray.get(n))%10;
                        break;
                    case 2: test = (listDynamicArray.get(n)/10)%10;
                        break;
                    case 3: test = (listDynamicArray.get(n)/100)%10;
                        break;
                }
                //assign number to correct stack or "bin"
                switch (test){
                    case -1: break;
                    case 0: stacks[0].push(listDynamicArray.get(n)); 
                        break;
                    case 1: stacks[1].push(listDynamicArray.get(n));
                        break;
                    case 2: stacks[2].push(listDynamicArray.get(n));
                        break;
                    case 3: stacks[3].push(listDynamicArray.get(n));
                        break;
                    case 4: stacks[4].push(listDynamicArray.get(n));
                        break;
                    case 5: stacks[5].push(listDynamicArray.get(n));
                        break;
                    case 6: stacks[6].push(listDynamicArray.get(n));
                        break;
                    case 7: stacks[7].push(listDynamicArray.get(n));
                        break;
                    case 8: stacks[8].push(listDynamicArray.get(n));
                        break;
                    case 9: stacks[9].push(listDynamicArray.get(n));
                        break;
                }
            }
            //fill back in to listDynamicArray starting with the largest number
            int index = (listDynamicArray.size())-1;//begin at last index 
            //empty each stack or "bin" 
            for(int j=9; j>=0; j--){
                while(!stacks[j].isEmpty()){
                    listDynamicArray.remove(index);//remove initial element at position
                    listDynamicArray.add(index, stacks[j].pop());//add element in correct sequence
                    index--;
                }
            }
            
        }
    }





    /**
     * Sorts the list using QUICK SORT.
     * takes array as input
     * @param listArray 
     */
    private static void sortListGroupTwo(int[] listArray, int low, int high) {
        //Check if the array is null or empty
        if (listArray == null || listArray.length == 0) return;
        else if (low >= high) return; //base case
        
        //create pivot point in middle of array
        int pivot = listArray[low + (high - low) / 2];
        
        //setting a variable for first element (low) and last element (high)
        int l = low;
        int h = high;
        while (l <= h){
            //loop until we find an out of place int
            while (listArray[l] < pivot) {
                l++;
            }
            
            //loop until we find an out of place int
            while (listArray[h] > pivot){
                h--;
            }
            
            //compare a & b ints
            if (l <= h) {
                //swap values
                int hold = listArray[l];
                listArray[l] = listArray[h];
                listArray[h] = hold;
                l++;
                h--;
            }
        }
        
        //recursive step until all unsorted integers are found
        if (low < h) sortListGroupTwo(listArray, low, h);
        if (high > l)sortListGroupTwo(listArray, l, high);
        
    }

    /**
     * Sorts the list using QUICK SORT.
     * takes LinkedList as input
     * @param listLL 
     */
    private static void sortListGroupTwo(MyLinkedList listLL, int low, int high) {
        if (low >= high) { //base case
            return;
        }
        
        //create the pivot point (middle)
        int pivot = listLL.getValue((low + high)/2);
        int index = split(listLL, low, high, pivot);
        
        //recursive step until all unsorted integers are found
        sortListGroupTwo(listLL, low, index - 1);
        sortListGroupTwo(listLL, index, high);
    }
    
    /**
     * Helper method for sortListGroupTwo(), splits LL 
     * takes LinkedList as input & pivot from sortListGroupTwo()
     * @param listLL 
     */
    public static int split(MyLinkedList listLL, int low, int high, int pivot) {
        while (low <= high) {
            while (listLL.getValue(low) < pivot) {
                low++;
            }
            while (listLL.getValue(high) > pivot) {
                high--;
            }
            if (low <= high) {
                listLL.swap(low, high);
                low++;
                high--;
            }
        }
        return low;
    }
    
    /**
     * Sorts the list using QUICK SORT.
     * takes ArrayList as input
     * @param listDynamicArray 
     */
    private static void sortListGroupTwo(ArrayList<Integer> listDynamicArray, int low, int high) {
         //check for empty or null array
        if (listDynamicArray == null || listDynamicArray.isEmpty()) return;
        else if (low >= high) return;//base case
 
        //make pivot the middle
        int pivot = listDynamicArray.get(low + (high - low) / 2);
 
        int l = low;
        int h = high;
        while (l <= h){
            //search until find one that is out of place
            while (listDynamicArray.get(l) < pivot){
                l++;
            }
            
            //search until find one that is out of place
            while (listDynamicArray.get(h) > pivot){
                h--;
            }
            
            //if we find 2 elements that are out of place, swap them
            if (l <= h){
                int temp = listDynamicArray.get(l);
                int temp2 = listDynamicArray.get(h);
                listDynamicArray.remove(l);
                listDynamicArray.add(l, temp2);
                listDynamicArray.remove(h);
                listDynamicArray.add(h, temp);
                //now move on
                l++;
                h--;
            }
        }
        
        //repeat until we go through all numbers that are out of place
        if (low < h) sortListGroupTwo(listDynamicArray, low, h);
        if (high > l)sortListGroupTwo(listDynamicArray, l, high);
    }




    /**
     * Sorts the list using an IMPROVED SELECTION SORT.
     * takes array as input
     * @param listArray 
     */
    private static void sortListGroupThree(int[] listArray) {
         int n = listArray.length-1; 

         for (int i = 0, j = n; i < j; i++, j--){
            int min = listArray[i];
            int max = listArray[i];
            int minIndex = i;
            int maxIndex = i;
            for (int k = i; k <= j; k++)  { 
                if (listArray[k] > listArray[maxIndex]) {
                    max = listArray[k];
                    maxIndex = k;
                } 
                else if (listArray[k] < listArray[minIndex]) {
                    min = listArray[k];
                    minIndex = k;
                }
            }

            //move the min 
            int temp = listArray[i]; 
            listArray[i] = listArray[minIndex]; 
            listArray[minIndex] = temp; 
            
            //move the max 
            if (listArray[minIndex] == max){
                int temp2 = listArray[j]; 
                listArray[j] = listArray[minIndex]; 
                listArray[minIndex] = temp2; 
         }else{
                int temp3 = listArray[j]; 
                listArray[j] = listArray[maxIndex]; 
                listArray[maxIndex] = temp3; 
          }

        }
    }

    /**
     * Sorts the list using an IMPROVED SELECTION SORT.
     * takes LinkedList as input
     * @param listLL 
     */
    private static void sortListGroupThree(MyLinkedList listLL) {
        int n = LIST_SIZE - 1;
        
        for (int i = 0, j = n; i < j; i++, j--){
            int min = listLL.getValue(i);
            int max = listLL.getValue(i);
            int minIndex = i;
            int maxIndex = i;
            for (int k = i; k <= j; k++) {
                if (listLL.getValue(k) > listLL.getValue(maxIndex)) {
                    max = listLL.getValue(k);
                    maxIndex = k;
                }
                else if (listLL.getValue(k) < listLL.getValue(minIndex)) {
                    min = listLL.getValue(k);
                    minIndex = k;
                }
            }
            
            //move the min
            listLL.swap(i, minIndex);
            
            //move the max
            if (listLL.getValue(minIndex) == max) {
                listLL.swap(j, minIndex);
            } else {
                listLL.swap(j, maxIndex);
            }
        }
    }

    /**
     * Sorts the list using an IMPROVED SELECTION SORT.
     * takes ArrayList as input
     * @param listDynamicArray 
     */
    private static void sortListGroupThree(ArrayList<Integer> listDynamicArray) {
        int n = listDynamicArray.size() - 1;
        
        for (int i = 0, j = n; i < j; i++, j--) {
            int min = listDynamicArray.get(i);
            int max = listDynamicArray.get(i);
            int minIndex = i;
            int maxIndex = i;
            for (int k = i; k <= j; k++) {
                if (listDynamicArray.get(k) > listDynamicArray.get(maxIndex)) {
                    max = listDynamicArray.get(k);
                    maxIndex = k;
                }
                else if (listDynamicArray.get(k) < listDynamicArray.get(minIndex)) {
                    min = listDynamicArray.get(k);
                    minIndex = k;
                }
            }
            
            //move the min
            int temp = listDynamicArray.get(i);
            int temp2 = listDynamicArray.get(minIndex);
            listDynamicArray.remove(i);
            listDynamicArray.add(i, temp2);
            listDynamicArray.remove(minIndex);
            listDynamicArray.add(minIndex, temp);
            
            //move the max
            if (listDynamicArray.get(minIndex) == max) {
                int temp3 = listDynamicArray.get(j);
                int temp4 = listDynamicArray.get(minIndex);
                listDynamicArray.remove(j);
                listDynamicArray.add(j, temp4);
                listDynamicArray.remove(minIndex);
                listDynamicArray.add(minIndex, temp3);
            } else {
                int temp3 = listDynamicArray.get(j);
                int temp4 = listDynamicArray.get(maxIndex);
                listDynamicArray.remove(j);
                listDynamicArray.add(j, temp4);
                listDynamicArray.remove(maxIndex);
                listDynamicArray.add(maxIndex, temp3);
            }            
        }
    }





    /**
     * prints out the contents of the array via Console
     * takes int array as input
     * @param ary
     */
    private static void printArray(int[] ary) {
        System.out.print("[ ");
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[i] + " ");
        }
        System.out.println("]");
    }
}
