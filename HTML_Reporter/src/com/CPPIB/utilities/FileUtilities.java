package com.CPPIB.utilities;

import java.io.File;

/**
 * This statically accessed utility class is supplied to 
 * reduce code redundancy.
 */
public class FileUtilities 
{
	/**
	 * Loads a single file using the supplied filePath
	 * @param filePath the path to the File to load
	 * @return A File loaded from the supplied filePath
	 */
	public static final File loadFileFromPath(String filePath)
	{
		return new File(filePath);
	}
	
	/**
	 * Loads a list of all the files in a given folder using the 
	 * supplied folderPath.
	 * @param folderPath = the path from which to load the files from
	 * @return = a list of all files within the supplied folderPath
	 */
	public static final File[] loadFilesFromPath(String folderPath)
	{
		File[] temp = new File(folderPath).listFiles();
		return temp;
	}
	
	public static final String[] split(String sequence, String delimiter)
	{
		String[] result = sequence.split(delimiter);
		return result;
	}
	
	public static final String removeExtension(String fileName)
	{
		return fileName.split(".")[0];
	}
}
