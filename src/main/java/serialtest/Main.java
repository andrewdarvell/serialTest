package serialtest;


import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



public class Main {


    //private static SerialPort serialPort;

    public static void main(String[] args) throws NoSuchPortException, PortInUseException, IOException, InterruptedException {

        System.setProperty("gnu.io.rxtx.SerialPorts", "/dev/ttyACM0");
        CommPortIdentifier portId = CommPortIdentifier.getPortIdentifier("/dev/ttyACM0");
        SerialPort serialPort =(SerialPort) portId.open("Demo application", 9600);
        String serialMessage = "y";
        OutputStream outstream = serialPort.getOutputStream();
        InputStream inputStream = serialPort.getInputStream();
        Thread.sleep(5000);
        outstream.write("seryep".getBytes());
        Thread.sleep(3000);
        outstream.write("r".getBytes());
        //System.out.print(inputStream.read());

        //outstream.write(serialMessage.getBytes());
        serialPort.close();
    }

}
