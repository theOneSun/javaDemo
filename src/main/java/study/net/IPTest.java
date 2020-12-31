package study.net;

import org.junit.Test;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author sunjian.
 */
public class IPTest {

    @Test
    public void testGetIpV4() {
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = addresses.nextElement();
                    if (ip instanceof Inet4Address && !ip.isLoopbackAddress() //loopback地址即本机地址，IPv4的loopback范围是127.0.0.0 ~ 127.255.255.255
                            && !ip.getHostAddress()
                                  .contains(":")){
                        System.out.println("本机的IP = " + ip.getHostAddress());
                        System.out.println(ip.getHostAddress());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("null");
    }
}
