/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;
/**
 *
 * @author kentan
 */
public class testing {
    
    public static void main(String[]args) throws IOException, InterruptedException
    {

        String s=null;
        System.out.println("Time start now to wait");
        Thread.sleep(1000);
        boolean isWindows=System.getProperty("os.name").toLowerCase().contains("win");
        ProcessBuilder pb=new ProcessBuilder("ping",isWindows? "-n" : "-c", "3","localhost"); // depends on how many packet to call 
        Process process=pb.start();
        BufferedReader stdInput =new BufferedReader(new InputStreamReader(process.getInputStream()));
        BufferedReader stdError=new BufferedReader(new InputStreamReader(process.getErrorStream()));
        
        String roundTripTime="";
        String checkforPackets="";
        while ((s=stdInput.readLine())!=null){
        
        
        if(s.contains("Lost =")){
            checkforPackets=s;
        }
        if(s.contains("Minimum")){
            roundTripTime=s;
        }
        System.out.println(s);
        }
        String[] roundtrip=roundTripTime.split(",");
        StringTokenizer stringtokens= new StringTokenizer(roundTripTime,",");
        StringTokenizer stringtokens2= new StringTokenizer(checkforPackets,",");
        String minimum=roundtrip[0].substring(14);
        System.out.println(minimum);
        System.out.println(stringtokens2);
        
        while ((s=stdError.readLine())!=null){
        System.out.println(s);
        }
        
        
    }
    
    
}
