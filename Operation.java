
/*
 *Operation.java
 *@author JiayuMeng
 *13/11/2022
 */

public class Operation {
    //declare variables
    int sum=0,avg;

    //method:Display the details of the first entered item
    public void showFirst(SportActivity[] sport) {
        System.out.println("**************************************");
        System.out.print("Name\t");
        System.out.print("Duration(ms)\t");
        System.out.println("place");
        SportActivity sa1 = sport[0];
        System.out.print(sa1.getName() + "\t" + sa1.getDuration() + "\t\t" + sa1.getPlace());
        System.out.println();
    }

    //method:Display the details of the last entered item
    public void showLast(SportActivity[] sport, int index){
        System.out.println("**************************************");
        System.out.print("Name\t");
        System.out.print("Duration(ms)\t");
        System.out.println("place");
        SportActivity sa1 = sport[index-1];
        System.out.print(sa1.getName() + "\t" + sa1.getDuration() + "\t\t" + sa1.getPlace());
        System.out.println();
    }

    //Calculate the average value
    public Integer avg(SportActivity[] sport,int index){
        for (int i=0; i<index;i++){
            SportActivity sa = sport[i];
            sum += sa.getDuration();
        }
        avg = sum/index;
        return avg;
    }

    //compute and display(get object with the lowest duration)
    public void getMin(SportActivity[] sport, int index){
        SportActivity saMin = sport[0];
        for (int i = 1; i < index; i++) {
            if (saMin.getDuration() >= sport[i].getDuration()) {
                saMin=sport[i];
            }
        }
        System.out.println("**************************************");
        System.out.print("Name\t");
        System.out.print("Duration(ms)\t");
        System.out.println("place");
        System.out.println(saMin.getName()+"\t"+saMin.getDuration()+"\t\t"+saMin.getPlace());
    }
}

