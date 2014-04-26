package serialtest;

import jssc.SerialPort;
import jssc.SerialPortList;

public class Main {

    public static void main(String[] args) {
        String[] portNames = SerialPortList.getPortNames();
        for(int i = 0; i < portNames.length; i++){
            System.out.println(portNames[i]);
        }



        try{
            SerialPort serialPort = new SerialPort("/dev/ttyACM0");
            serialPort.openPort();
            serialPort.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);

            while (1==1){
                String data = serialPort.readString();
                //И снова отправляем запрос
                //serialPort.writeString("Get data");
                System.out.println(data);

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
