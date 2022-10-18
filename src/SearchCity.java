import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
class Location3{
    private String city;
    private int latitude,longitude;

    public Location3(String city,int longitude,int latitude) {
        this.latitude=latitude;
        this.longitude=longitude;
        this.city=city;
    }
    public void show() {
        System.out.println(city+"\t"+longitude+"\t"+latitude);
    }

}
public class SearchCity {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc=new Scanner(System.in);
        HashMap<String, Location3> h=new HashMap<String,Location3>();
        System.out.println("도시,경도,위도를 입력하세요.");
        for(int i=0;i<3;i++) {
            System.out.print(">> ");
            String st=sc.next();

            StringTokenizer t=new StringTokenizer(st,",");
            String city=t.nextToken().trim();
            int longitude=Integer.parseInt(t.nextToken().trim());
            int latitude=Integer.parseInt(t.nextToken().trim());
            h.put(city,new Location3(city,longitude,latitude));
        }
        Set<String> keys=h.keySet();
        Iterator<String> it=keys.iterator();
        System.out.println("--------------------------");
        while(it.hasNext()) {
            String n=it.next();
            Location3 l=h.get(n);
            l.show();
        }
        System.out.println("--------------------------");

        while(true) {
            System.out.print("도시 이름 >> ");
            String st=sc.next();
            if(st.equals("그만")) {
                break;
            }
            if(h.get(st)!=null) {
                h.get(st).show();
            }
            else {
                System.out.println(st+"는 없습니다.");
            }
        }
        sc.close();
    }
}