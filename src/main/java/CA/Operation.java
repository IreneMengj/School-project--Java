package CA;


public class Operation {
    //declare variables
    int sum=0,avg;

    //output:Display the details of the first entered item
    public void showFirst(SportActivity[] sport) {
        System.out.println("**************************************");
        System.out.print("Name\t");
        System.out.print("Duration(ms)\t");
        System.out.println("place");
        SportActivity sa1 = sport[0];
        System.out.print(sa1.getName() + "\t" + sa1.getDuration() + "\t\t" + sa1.getPlace());
        System.out.println();
    }

    //output:Display the details of the last entered item
    public void showLast(SportActivity[] sport, int index){
        System.out.println("**************************************");
        System.out.print("Name\t");
        System.out.print("Duration(ms)\t");
        System.out.println("place");
        SportActivity sa1 = sport[index-1];
        System.out.print(sa1.getName() + "\t" + sa1.getDuration() + "\t\t" + sa1.getPlace());
        System.out.println();
    }

    //compute and output method(average)
    public Integer avg(SportActivity[] sport,int index){
        for (int i=0; i<index;i++){
            SportActivity sa = sport[i];
            sum += sa.getDuration();
        }
        avg = sum/index;
        return avg;
    }

    //compute and output method(get object with smallest duration)
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

