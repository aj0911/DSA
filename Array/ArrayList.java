package Array;

public class ArrayList<T>{
    public int def_capacity;
    private int size;
    private T[] arr;

    //constructor ArrayList
    public ArrayList(){
        def_capacity = 2;
        size = 0;
        arr = (T[]) new Object[def_capacity];
    }

    //to return a string
    @Override
    public String toString(){
        String str = "[";
        for(int i=0;i<this.size;i++)str+= arr[i]+(i==size-1?"":",");
        str+="]";
        return str;
    }

    public void add(T element){
        if(size==def_capacity){
            def_capacity = 2*size;
            T[] new_arr = (T[]) new Object[def_capacity];
            for(int i=0;i<size;i++)new_arr[i]=arr[i];
            arr = new_arr;
        }
        arr[size]=element;
        size++;
    }

    //Add element at the specified position
    public void add(int index,T element) throws Exception{
        if(index>=size || index<0) throw new Exception("Index out of bound Error. Accessing Index "+index+" out of "+size);
        if(size==def_capacity){
            def_capacity = 2*size;
            T[] new_arr = (T[]) new Object[def_capacity];
            for(int i=0;i<size;i++)new_arr[i]=arr[i];
            arr = new_arr;
        }
        for(int i=size;i>=index;i--)arr[i]=arr[i-1];
        arr[index]=element;
        size++;
    }

    //update element at a particular index
    public void set(int index,T element) throws Exception{
        if(index>=size || index<0) throw new Exception("Index out of bound Error. Accessing Index "+index+" out of "+size);
        arr[index]=element;
    }

    //returns the size
    public int size(){
        return this.size;
    }

    //return the value at the index
    public T get(int index) throws Exception{
        if(index>=size || index<0) throw new Exception("Index out of bound Error. Accessing Index "+index+" out of "+size);
        return arr[index];
    }

    //remove
    public T remove(int index) throws Exception{
        if(index>=size || index<0) throw new Exception("Index out of bound Error. Accessing Index "+index+" out of "+size);
        T popElement = arr[index];
        for(int i=index;i<size-1;i++)arr[i]=arr[i+1];
        arr[size-1]=null;
        size--;
        if(def_capacity==2)return popElement;
        if(size==def_capacity/2){
            def_capacity /=2;
            T[] new_arr = (T[]) new Object[def_capacity];
            for(int i=0;i<size;i++)new_arr[i]=arr[i];
            arr = new_arr;
        }
        return popElement;
    } 

    //remove all occurance of element
    public void remove(T element) throws Exception{
        while(this.contains(element))this.remove(this.indexOf(element));
    }

    //return the index of an element
    public int indexOf(T element){
        for(int i=0;i<size;i++)if(arr[i]==element)return i;
        return -1;
    }

    //last index of an element
    public int lastIndexOf(T element){
        for(int i=size-1;i>=0;i--)if(arr[i]==element)return i;
        return -1;
    }

    //is the element contains by the list or not
    public boolean contains(T element){
        for(int i=0;i<size;i++)if(arr[i]==element)return true;
        return false;
    }

    //To Check list is empty or not
    public boolean isEmpty(){
        if(size==0)return true;
        return false;
    }

    //Convert to Object array
    public Object[] toArray(){
        Object[] return_arr = new Object[size];
        for(int i=0;i<size;i++)return_arr[i] = arr[i];
        return return_arr;
    }

    //fill the data of the list to any type of array
    public void toArray(T[] a){
        for(int i=0;i<size;i++)a[i] = arr[i];
    }

    //clear all the elements of the array
    public void clear(){
        def_capacity = 2;
        size=0;
        arr = (T[]) new Object[def_capacity];
    }

    //it add all the elements at the end of the list
    public void addAll(ArrayList<T> addList) throws Exception{
        for(int i=0;i<addList.size();i++){
            this.add(addList.get(i));
        }
    }

    //it add all the elements at the end of the list at a specified postion
    public void addAll(int index,ArrayList<T> addList) throws Exception{
        for(int i=0;i<addList.size();i++){
            this.add(index+i,addList.get(i));
        }
    }

    //removes all the element present in the list
    public void removeAll(ArrayList<T> removeList) throws Exception{
        for(int i=0;i<removeList.size();i++){
            this.remove(removeList.get(i));
        }
    }

    //check for all the element present in the list
    public boolean containsAll(ArrayList<T> checkList) throws Exception{
        boolean flag = true;
        for(int i=0;i<checkList.size();i++){
            flag = flag && this.contains(checkList.get(i));
        }
        return flag;
    }

    //retains all element in the list that is contained
    public void retainAll(ArrayList<T> another) throws Exception{
        for(int i=0;i<size;i++){
            if(!another.contains(arr[i])){
                this.remove(arr[i]);
                i--;
            }
        }
    }

}
