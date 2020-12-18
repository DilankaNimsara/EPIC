package isoActvity;

import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.packager.GenericPackager;

import java.nio.charset.StandardCharsets;

public class PackISOmessage {
    public static void main(String[] args) {
        try {
            ISOPackager packager = new GenericPackager("src/XMLfile/iso8583binary.xml");
            ISOMsg isoMsg = new ISOMsg();
            isoMsg.setPackager(packager);
            isoMsg.setMTI("0200");
            isoMsg.set(3, "000000");
            isoMsg.set(4, "000000010000");
            isoMsg.set(11, "000009");
            isoMsg.set(22, "052");
            isoMsg.set(24, "071");
            isoMsg.set(25, "00");
            isoMsg.set(35, "5413330002001031=2512201014590756");
            isoMsg.set(41, "40100000");
            isoMsg.set(42, "000001000003000");
            isoMsg.set(55, "820258008407A0000000041010950502000080009A032012149C01005F2A0201449F02060000000100009F03060000000000009F090200029F10080101A0000020DAC09F1A0201449F1E0831303130323339379F2608675CD6A91DC7298A9F2701809F3303E0B0C89F34031E00009F3501229F360200019F3704196708649F4104000000029F5301525F340100");
            isoMsg.set(62, "000007");
            byte[] msg = isoMsg.pack();

            StringBuilder strBuilder = new StringBuilder();
            for (byte val : msg) {
                strBuilder.append(String.format("%02X", val & 0xff));
            }
            System.out.println(strBuilder.toString());
        } catch (Exception e) {
        }
    }
}
