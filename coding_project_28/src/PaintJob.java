public class PaintJob {

    public static int getBucketCount(double width,double height,double areaPerBucket,int extraBuckets){
        if(width<=0 || height<=0 ||areaPerBucket<=0||extraBuckets<0){
            return -1;
        }
        double numberofbucket=Math.ceil((width*height)/areaPerBucket);
        double bucketrequired=numberofbucket- extraBuckets;
        return (int)bucketrequired;
    }

    public static int getBucketCount(double width,double height,double areaPerBucket){
        if(width<=0||height<=0||areaPerBucket<=0){
            return -1;
        }
        double numberofbucket=Math.ceil((width*height)/areaPerBucket);
        return (int)numberofbucket;
    }

    public static int getBucketCount(double area,double areaPerBucket){
        if (area<=0||areaPerBucket<=0){
            return -1;
        }
        double bucketrequired=Math.ceil(area/areaPerBucket);
        return (int)bucketrequired;
    }
}
