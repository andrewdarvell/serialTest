package serialtest;


import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import java.io.*;


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

        outstream.write("s100200p".getBytes());
        Thread.sleep(3000);
        //outstream.write("r".getBytes());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String cons = "";
        while (!cons.equals("exit")){
            cons = bufferedReader.readLine();
            //String comm = cons.substring(0,1);
            //String par = cons.substring(1,4);
            switch (cons){
                case "w":outstream.write(("s"+"mvf240p").getBytes());
                    break;
                case "s":outstream.write(("s"+"mvb240p").getBytes());
                    break;
                case "a":outstream.write(("s"+"mvl240p").getBytes());
                    break;
                case "d":outstream.write(("s"+"mvr240p").getBytes());
                    break;
                case "e":outstream.write(("smvo100p").getBytes());
                    break;
                default:outstream.write(("smvo100p").getBytes());
                    break;
            }
        }


        serialPort.close();
    }


}
