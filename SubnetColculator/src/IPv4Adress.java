//192.168.2.1
//a.b.c.d    0<= a,b,c,d <=255
//(((256*a)+b)*256+c)*256+d
import java.util.Arrays;

public class IPv4Adress {
    private  int[] octets;
    public  static final int BIT_LENGHT=32;
    public  static final int OCTET_BIT_LENGHT=8;
    public  static final int OCTET_COUNT=BIT_LENGHT/OCTET_BIT_LENGHT;
    public static final String ADDRESS_PATTERN="\\d{1,3}(\\.\\d{1,3}){3}";


    public IPv4Adress(String address) {
        this.octets=parse(address);
        if (!areValidOctets(this.octets)) {
            throw  new IllegalArgumentException("Invalid Octets");
        }
    }

    public IPv4Adress(int bits) {
        if (bits<=0) {
            throw  new IllegalArgumentException("Bits are <0");
        }
        this.octets=toOctetBitPrefix(bits);
        if (!areValidOctets(this.octets)) {
            throw  new IllegalArgumentException("Invalid Octets");
        }
    }

    private static int[] toOctetBitPrefix(int bitCount) {
        long address=createSubnetMask(bitCount);

        return toOctetsFromLong(address);
    }

    private static int[] toOctetsFromLong(long address) {
        int[] octets=new int[OCTET_COUNT];
        for (int i = OCTET_COUNT-1; i >=0 ; --i) {
            octets[i]=(int) (address & 0b1111_1111); // oder statt bx1111_1111 -->0xff
            address>>=OCTET_BIT_LENGHT;
        }
        return octets;
    }

    public IPv4Adress fromSubnetMask(int bits) {
        return new IPv4Adress(bits);
    }
    public IPv4Adress(int octet1,int octet2,int octet3,int octet4) {
        this.octets=new int[] {octet1,octet2,octet3,octet4};
        if (!areValidOctets(this.octets)) {
            throw  new IllegalArgumentException("Not Valid octects");
        }
    }
    public IPv4Adress getSubnetAddress(int subnetMaskLength) {
        long ipAddress= toLongFromOctets();
        long subnetMask=createSubnetMask(subnetMaskLength);
        long networkAddress=ipAddress & subnetMask;
        int[] octets=toOctetsFromLong(networkAddress);
        return new IPv4Adress(octets[0],octets[1],octets[2],octets[3]);
    }

    private static long createSubnetMask(int subnetMaskLength) {
        long subnetMask=(1L<< subnetMaskLength)-1;
        subnetMask<<=BIT_LENGHT- subnetMaskLength;
        return subnetMask;
    }

    private static int[] parse(String address) {
        if (!address.matches(ADDRESS_PATTERN)) {
            throw new IllegalArgumentException("Invalid Adress: %s".formatted(address));
        }
        String[]  parsed_address=address.split("\\.");
        int[] octets=new int[OCTET_COUNT];
        Arrays.setAll(octets,i->Integer.parseInt(parsed_address[i]));
        return octets;
    }

    public  static  boolean areValidOctets(int[] octets)
    {
        if (octets.length != OCTET_COUNT) {
            return false;
        }
        for (int o:octets) {
            if (o<0||o>255) {
                return false;
            }
        }
        return true;
    }

    public String toBinaryString() {
        String[] octet_binary=new String[OCTET_COUNT];
        for (int i=0;i<OCTET_COUNT;i=i+1) {
            String octetbinary=Integer.toBinaryString(this.octets[i]);
            octetbinary="%8s".formatted(octetbinary).replace(" ","0");
            octet_binary[i]=octetbinary;
            }
        return String.join(".",octet_binary);
    }


    public long toLongFromOctets() {
        long address=octets[0];
        for (int i = 0; i < OCTET_COUNT; ++i) {
            address*=256L;
            address+=octets[i];
        }
        return address;
    }

    @Override
    public String toString() {
        String[] parts=new String[OCTET_COUNT];
        Arrays.setAll(parts,i->String.valueOf(this.octets[i]));

        return String.join(".",parts);
    }


}
