package com.interview.service;

import com.interview.entity.Partition;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFileService {

    public static void writeToFile(Map<String, Partition> output,String path) throws IOException {


        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            String newLine = System.getProperty("line.separator");
                for(Map.Entry<String,Partition> mapp:output.entrySet()){

                        writer.write(mapp.getKey() + "->" + mapp.getValue().getAverage()+newLine);
                        System.out.println(mapp.getKey()+ "->" + mapp.getValue().getAverage());


                }
            writer.close();

        } catch (IOException e) {
            throw new IOException("couldn't write to file");
        }
    }
}
