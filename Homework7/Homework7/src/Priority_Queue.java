/**
 * Class that implements a Priority Queue using an array
 *
 * @author Daniel Gries
 */
public class Priority_Queue {

    private final static int MAX_SPACES = 1000;
    private Integer[] priorityQueue = new Integer[MAX_SPACES];
    private int numberofMembers = 0;


//---------------------------------------------------------------------------------------------------------------------
    //Accessor Methods

    //returns number of members
    public int getNumberofMembers(){
        return numberofMembers;
    }


    public int getMaxValue(){
        return priorityQueue[0];
    }
    //the first value in a priority queue is the max value

    //loops through priorityQueue and prints out all the values
    public String toString(){
        StringBuilder printString = new StringBuilder();
        for(int index = 0; index <numberofMembers; index++){
            Integer printValue = priorityQueue[index];
            printString.append(printValue);
            printString.append(" ");
        }
        return printString.toString();
    }

    public boolean isEmpty(){
        return numberofMembers == 0;
    }

//---------------------------------------------------------------------------------------------------------------------
    //Mutator methods


    //removes max value
    public Integer removeMaxValue(){
        Integer maxValue = priorityQueue[0];
        priorityQueue[0] = priorityQueue[numberofMembers -1];
        numberofMembers--;
        downHeap(0);
        return maxValue;
    }

    public void addMember(Integer newMember){
        priorityQueue[numberofMembers] = newMember;
        numberofMembers++;
        upHeap(numberofMembers-1);

    }


    public void createPQ(Integer[]setOfMembers){
        for(int index = 0; index < setOfMembers.length; index++) {
            priorityQueue[index] = setOfMembers[index];
            numberofMembers++;
        }
        sortPriorityQueue(priorityQueue);

    }

    private void sortPriorityQueue(Integer[]unsortedPriorityQueue){
        for(int i = numberofMembers/2 ; i>=0; i--) {
            downHeap(i);
        }
    }



//---------------------------------------------------------------------------------------------------------------------
    //Private Methods

    //return true if left child is larger than righr child
    private boolean largerChild(int indexOfParent){
        int leftChildValue = getLeftChildValue(indexOfParent);
        int rightChildValue = getRightChildValue(indexOfParent);
        return leftChildValue > rightChildValue;
    }

    private int getRightChildValue(int indexOfParent){
        return priorityQueue[(indexOfParent * 2) + 2];
        //index * 2 + 2 results in the index of the right child in a binary heap
    }

    private int getLeftChildValue(int indexOfParent){
        return priorityQueue[(indexOfParent * 2) + 1];
        //index * 2 + 1 results in the index of the right child in a binary heap
    }








    //upheap takes a value and moves it up the heap if it is larger than its' parent
    private void upHeap(int ind){
        if(ind == 0){ // checks if the value is the top value in the array
            return;
        }
        else if(checkIfParentIsSmallerThanChild(ind)) {
            swapChildandParent(ind);
            upHeap((ind - 1) / 2);
        }
        else{
            return;
        }
    }

    private void swapChildandParent(int indexOfChild){
        Integer temp = priorityQueue[indexOfChild];
        priorityQueue[indexOfChild] = priorityQueue[(indexOfChild - 1) / 2];
        priorityQueue[(indexOfChild - 1) / 2] = temp;
    }


    private boolean checkIfParentIsSmallerThanChild(int indexOfChild){
        int childValue = priorityQueue[indexOfChild];
        int parentValue = priorityQueue[(indexOfChild - 1)/2];
        return childValue > parentValue;
    }




    private void downHeap(int ind){

        if (isLeaf(ind)){//checks if value has no children
            return;
        }

        else if(!hasRightChild(ind)){//checks if only has a left child
            if(ifLeftChildIsLargerThanParent(ind)){//checks if left child is larger than parent
                swapParentAndLeftChild(ind);
                downHeap((ind * 2) + 1);
            }
        }
        else{//if value has both children
            if(largerChild(ind)){//checks if left child is larger than right child
                if(ifLeftChildIsLargerThanParent(ind)){//checks if left child is larger than parent
                    swapParentAndLeftChild(ind);
                    downHeap((ind * 2) + 1);
                }
            }
            else{
                if(ifRightChildIsLargerThanParent(ind)) {//checks if right child is larger than parent
                    swapParentAndRightChild(ind);
                }
            }

        }
    }


    private boolean isLeaf(int ind){
        return ((ind * 2) + 1) > numberofMembers;
    }

    private boolean hasRightChild(int indexOfParent){
        return priorityQueue[(indexOfParent * 2) + 2] == null;
    }

    private boolean ifLeftChildIsLargerThanParent(int indexOfParent){
        return priorityQueue[indexOfParent] < priorityQueue[(indexOfParent * 2) + 1];
    }

    private boolean ifRightChildIsLargerThanParent(int indexOfParent){
        return priorityQueue[indexOfParent] < priorityQueue[(indexOfParent *2) + 2];
    }

    private void swapParentAndLeftChild(int indexOfParent){
        Integer temp = priorityQueue[indexOfParent];
        priorityQueue[indexOfParent] = getLeftChildValue(indexOfParent);
        priorityQueue[(indexOfParent * 2) + 1] = temp;
    }

    private void swapParentAndRightChild(int indexOfParent){
        Integer temp = priorityQueue[indexOfParent];
        priorityQueue[indexOfParent] = getLeftChildValue(indexOfParent);
        priorityQueue[(indexOfParent * 2) + 2] = temp;
    }





}
