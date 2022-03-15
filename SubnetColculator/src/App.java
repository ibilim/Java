import java.util.Arrays;

public class App {
    public static void main(String[] args) {


        //new IPv4Adress("192.168.178.255");
        //new IPv4Adress("192.168.178.1").toBinaryString();
        //System.out.println(Arrays.toString(new IPv4Adress("0.0.0.1").toBinaryString()));
        //System.out.println(new IPv4Adress("0.0.1.0").toLongFromOctets());
        //System.out.println(new IPv4Adress("255.255.255.255").toLongFromOctets());
        //System.out.println(new IPv4Adress("255.255.255.255"));
        //System.out.println(Arrays.toString(new IPv4Adress(4).toBinaryString()));
        //System.out.println(Arrays.toString(new IPv4Adress(8).toBinaryString()));
        //System.out.println(Arrays.toString(new IPv4Adress(16).toBinaryString()));
        //System.out.println(new IPv4Adress(16));
        //System.out.println(new IPv4Adress(16).fromSubnetMask(30));
        IPv4Adress address=new IPv4Adress("192.168.0.1");
        IPv4Adress subnetadress=address.getSubnetAddress(30);
        System.out.println(address);
        System.out.println(subnetadress);
        System.out.println(subnetadress.toBinaryString());
        
    }
}
