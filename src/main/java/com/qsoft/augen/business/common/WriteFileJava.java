package com.qsoft.augen.business.common;

import org.apache.commons.io.FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileJava
{

	public static void WritToFile(String path, String fileName, String content) {
		try {
            makePath(path);
			FileWriter fstream = new FileWriter(path + fileName);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(content);
			out.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}

    public static void makePath(String path)
    {
        String regex = "/";
        String[] subPath = path.split(regex);
        String prePath = subPath[0]+regex+regex;
        for (int i=2; i<subPath.length; i++)
        {
            prePath = prePath.concat(subPath[i] + regex);
            File file = new File(prePath);
            file.mkdir();
        }
    }
}
