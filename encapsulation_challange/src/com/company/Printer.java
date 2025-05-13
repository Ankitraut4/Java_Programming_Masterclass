package com.company;

public class Printer {
    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel ,boolean duplex) {
        if (tonerLevel>0 && tonerLevel<=100) {
            this.tonerLevel = tonerLevel;
        }else {
            this.tonerLevel=-1;
        }

        this.duplex = duplex;

        this.numberOfPagesPrinted = 0;
    }

    public int fillLevel(int level) {
        if (level > 0 && level <= 100) {
            if (this.tonerLevel + level > 0 && this.tonerLevel + level <= 100) {
                 this.tonerLevel += level;
                 return this.getTonerLevel();
            } else {
                return  -1;
            }
        } else {
            return -1;
        }
    }

    public int PagesPrinted(int pages){

        int PagesPrinted =pages;
        if (this.duplex){
            PagesPrinted = (pages/2)+(pages%2);
            System.out.println("it is duplex printer");


        }
         this.numberOfPagesPrinted+=PagesPrinted;
        return PagesPrinted;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }





}
