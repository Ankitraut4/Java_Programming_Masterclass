package com.company;

public abstract class ListItem {
    protected ListItem rightLink=null;
    protected ListItem leftLink=null;

    protected Object value;//here the field are protected than private  because we need to be able to acess them from our concrete subclass. i.e subclass from another package can acess it.

    public ListItem(Object value) {
        this.value = value;
    }

     abstract ListItem next();//next returns a reference to the next ListItem in the list
     abstract ListItem previous();
     abstract ListItem setNext(ListItem item);//setNext where we passing the parameter listitems sets the reference to the next item to refer to in the parameter which is course item.
     abstract ListItem setPrevious(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    abstract int compareTo(ListItem item);


}
