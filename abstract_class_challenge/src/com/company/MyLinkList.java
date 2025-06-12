package com.company;

public class MyLinkList implements NodeList{

    private ListItem root=null;

    public MyLinkList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            //there is no element in list
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparision = (currentItem.compareTo(newItem));
            if (comparision < 0) {
                    //the newitem is bigger than current,we have to move right
                    if (currentItem.next() != null) {
                        currentItem = currentItem.next();
                    } else {
                        //if we are at end of list ,there is no element so we have to add at last
                        currentItem.setNext(newItem);
                        newItem.setPrevious(currentItem);
                        return true;
                    }
                } else if (comparision > 0) {
                    // newItem is less, insert before
                    if (currentItem.previous() != null) {
                        currentItem.previous().setNext(newItem);
                        newItem.setPrevious(currentItem.previous());
                        newItem.setNext(currentItem);
                        currentItem.setPrevious(newItem);
                    } else {
                        //the previous element is root
                        newItem.setNext(this.root);
                        this.root.setPrevious(newItem);
                        this.root = newItem;

                    }
                    return true;
                } else {
                    //comparision=0
                    // equal
                    System.out.println(newItem.getValue() + " is already present, not added.");
                    return false;
                }
            }
            return false;
        }


    @Override
    public boolean removeItem(ListItem item) {
        if(item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while(currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if(comparison == 0) {
                // found the item to delete
                if(currentItem == this.root) {
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if(comparison <0) {
                currentItem = currentItem.next();
                return true;
            } else { // comparison > 0
                // We are at an item greater than the one to be deleted
                // so the item is not in the list
                return false;
            }
        }

        // We have reached the end of the list
        // Without finding the item to delete
        return false;
    }



    @Override
    public void traverse(ListItem root) {
if (root==null){
    System.out.println("list is empty");
}else {
    while (root!=null){
        System.out.println(root.getValue());
        root=root.next();
    }
}
    }


}
