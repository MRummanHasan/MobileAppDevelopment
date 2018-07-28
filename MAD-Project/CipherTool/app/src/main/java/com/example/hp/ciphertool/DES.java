package com.example.hp.ciphertool;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.Arrays;

public class DES {

    public String[] keyGeneration(String key)
    {
        byte[] bytes = key.getBytes();
        StringBuilder PKinBinary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                PKinBinary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }

        String[] keys = new String[16];
        int[] PDTable = {57,49,41,33,25,17,9,1,58,50,42,34,26,18,10,2,59,51,43,35,27,19,11,3,60,52,44,36,63,55,47,39,31,23,15,7,62,54,46,38,30,22,14,6,61,53,45,37,29,21,13,5,28,20,12,4};
        int[] KeyCTable = {14,17,11,24,1,5,3,28,15,6,21,10,23,19,12,4,26,8,16,7,27,20,13,2,41,52,31,37,47,55,30,40,51,45,33,48,44,49,39,56,34,53,46,42,50,36,29,32};
        String dummy1 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder afterPD = new StringBuilder(dummy1);
        for(int i = 0; i < PDTable.length; i++){
            afterPD.setCharAt(i,PKinBinary.charAt(PDTable[i] - 1));
        }
        //System.out.println(afterPD);
        //After Parity Drom
        //Result in afterPD
        /////

        String afterPDLeft = "", afterPDRight = "";
        for(int i = 0; i < 28; i++){
            afterPDLeft = afterPDLeft + afterPD.charAt(i);
        }
        for(int i = 28; i < 56; i++){
            afterPDRight = afterPDRight + afterPD.charAt(i);
        }

        //System.out.println(afterPDLeft);
        //System.out.println(afterPDRight);


        for(int i = 1; i < 17; i++){
            if(i == 1 || i == 2 || i == 9 || i == 16){
                afterPDLeft = afterPDLeft.substring(1,28) + afterPDLeft.charAt(0);
                afterPDRight = afterPDRight.substring(1,28) + afterPDRight.charAt(0);
            }
            else{

                afterPDLeft = afterPDLeft.substring(2,28) + afterPDLeft.substring(0,2);
                afterPDRight = afterPDRight.substring(2,28) + afterPDRight.substring(0,2);
            }
          /*.out.println("/////");
          System.out.println(afterPDLeft);
          System.out.println(afterPDRight);
         System.out.println("/////");*/


            String goingtobekey = (afterPDLeft + afterPDRight);
            String dummy2 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
            StringBuilder finalKey = new StringBuilder(dummy2);
            for(int j = 0; j < KeyCTable.length; j++){
                finalKey.setCharAt(j,goingtobekey.charAt(KeyCTable[j] - 1));
            }
            keys[i - 1] = finalKey.toString();
        }
        return keys;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String encrytion(String PT, String key)
    {
        //Converting PlainText into BinaryCode
        byte[] bytes = PT.getBytes();
        StringBuilder PTinBinary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                PTinBinary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        //Applying Initial Permutation
        int[] IPTable = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
        int[] FPTable = {40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};
        String dummy1 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder afterIP = new StringBuilder(dummy1);
        for(int i = 0; i < IPTable.length; i++)
        {
            afterIP.setCharAt(i,PTinBinary.charAt(IPTable[i] - 1));
        }

        String[] keys = keyGeneration(key);
        String key1 = keys[0];
        String extrabit = "0000000000000000";
        String finalkey = key1 + extrabit;

        String dummy2 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder afterkeyZor = new StringBuilder(dummy2);
        for (int i = 0; i < 64; i++) {
            if(afterIP.charAt(i) == finalkey.charAt(i))
            {
                afterkeyZor.setCharAt(i,'0');
            }
            else
            {
                afterkeyZor.setCharAt(i,'1');
            }
        }


        //Now applying FinalPermutation
        String dummy3 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder encryptedText = new StringBuilder(dummy3);
        for(int i = 0; i < FPTable.length; i++)
        {
            encryptedText.setCharAt(i,afterkeyZor.charAt(FPTable[i] - 1));
        }

        int s = 0;
        int e = 8;
        String output = "";
        for (int i = 0; i < 8; i++ )
        {
            String txt = encryptedText.substring(s,e);
            output = output + convertBinaryStringToString(txt);
            s = s + 8;
            e = e + 8;
        }
        return  output;


    }
    public static String convertBinaryStringToString(String string){
        char[] chars = string.toCharArray();
        char[] transcoded = new char[(chars.length / 9)+1];

        //for each character (plus one for spacing)
        for (int j = 0; j < chars.length; j+=9) {
            int idx = 0;
            int sum = 0;

            //for each bit in reverse
            for (int i = 7; i>= 0; i--) {
                if (chars[i+j] == '1') {
                    sum += 1 << idx;
                }
                idx++;
            }
            transcoded[j/9] = (char) sum;
        }
        return new String(transcoded);
    }
    public String Decrypt(String CipherText, String key)
    {
        int[] IPTable = {58,50,42,34,26,18,10,2,60,52,44,36,28,20,12,4,62,54,46,38,30,22,14,6,64,56,48,40,32,24,16,8,57,49,41,33,25,17,9,1,59,51,43,35,27,19,11,3,61,53,45,37,29,21,13,5,63,55,47,39,31,23,15,7};
        int[] FPTable = {40,8,48,16,56,24,64,32,39,7,47,15,55,23,63,31,38,6,46,14,54,22,62,30,37,5,45,13,53,21,61,29,36,4,44,12,52,20,60,28,35,3,43,11,51,19,59,27,34,2,42,10,50,18,58,26,33,1,41,9,49,17,57,25};

        byte[] bytes = CipherText.getBytes();
        StringBuilder CTinBinary = new StringBuilder();
        for (byte b : bytes)
        {
            int val = b;
            for (int i = 0; i < 8; i++)
            {
                CTinBinary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }

        //Appling FP
        String dummy3 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder FPText = new StringBuilder(dummy3);
        for(int i = 0; i < FPTable.length; i++)
        {
            FPText.setCharAt(i,CTinBinary.charAt(FPTable[i] - 1));
        }

        //Now Zooring

        String[] keys = keyGeneration(key);
        String key1 = keys[0];
        String extrabit = "0000000000000000";
        String finalkey = key1 + extrabit;

        String dummy2 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder afterkeyZor = new StringBuilder(dummy2);
        for (int i = 0; i < 64; i++) {
            if(FPText.charAt(i) == finalkey.charAt(i))
            {
                afterkeyZor.setCharAt(i,'0');
            }
            else
            {
                afterkeyZor.setCharAt(i,'1');
            }
        }

        //applying IP

        String dummy1 = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        StringBuilder afterIP = new StringBuilder(dummy1);
        for(int i = 0; i < IPTable.length; i++)
        {
            afterIP.setCharAt(i,afterkeyZor.charAt(IPTable[i] - 1));
        }

        int s = 0;
        int e = 8;
        String output = "";
        for (int i = 0; i < 8; i++ )
        {
            String txt = afterIP.substring(s,e);
            output = output + convertBinaryStringToString(txt);
            s = s + 8;
            e = e + 8;
        }
        return  output;


    }

}
