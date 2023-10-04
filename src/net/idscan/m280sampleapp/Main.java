package net.idscan.m280sampleapp;

import com.fazecast.jSerialComm.*;
import java.util.*;
import java.io.*;


public class Main {
	
	 public static void main(String[] args) {


	 for (SerialPort port: SerialPort.getCommPorts()) {
		System.out.println((port.getSystemPortName()));
	}
		 SerialPort comPort = SerialPort.getCommPorts()[0];
		 comPort.openPort();
		 System.out.println((comPort.getSystemPortName()));

		 try {
		    while (true)
		    {
		    	
		       while (comPort.bytesAvailable() == 0) {
		    	   Thread.sleep(1000);
		       }
	
		       byte[] readBuffer = new byte[comPort.bytesAvailable()];
		       int numRead = comPort.readBytes(readBuffer, readBuffer.length);
		       String str = new String(readBuffer);
		       System.out.println(str);
		       
		       
		    }
		 } 
		 catch (Exception e) { 
			 e.printStackTrace(); 
		 }
		 
		 comPort.closePort();
	 }
}




