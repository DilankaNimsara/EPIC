/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isoActvity;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.ISOUtil;
import org.jpos.iso.packager.*;

/**
 * @author dilanka_a
 */
public class BreakeISOmessage {

    public static void main(String[] args) {


        String message = "02003020058020C002040000000000000100000000090052007100335413330002001031D2512201014590756034303130303030303030303030313030303030333030300141820258008407A0000000041010950502000080009A032012149C01005F2A0201449F02060000000100009F03060000000000009F090200029F10080101A0000020DAC09F1A0201449F1E0831303130323339379F2608675CD6A91DC7298A9F2701809F3303E0B0C89F34031E00009F3501229F360200019F3704196708649F4104000000029F5301525F3401000006303030303037";

        System.out.println("Message : " + message);

        try {
            ISOPackager packager = new GenericPackager("src/XMLfile/iso8583binary.xml");
            ISOMsg imMsg = new ISOMsg();
            imMsg.setPackager(packager);
            imMsg.unpack(ISOUtil.hex2byte(message));
            System.out.println("MTI = " + imMsg.getMTI());

            for (int i = 1; i <= imMsg.getMaxField(); i++) {
                if (imMsg.hasField(i)) {
                    System.out.println("Field (" + i + ") = " + imMsg.getString(i));
                }
            }
        } catch (ISOException e) {
        }
    }

}
