/*
Code to read properties from config file
*/

import java.io.*;
import java.text.*;

public class CommonConfigRead {

  public static final String common_file_name = "common.cfg";
  private static int NumberOfPreferredNeighbors;
  private static int  UnchokingInterval;
  private static int  OptimisticUnchokingInterval;
  private static String FileName;
  private static int FileSize;
  private static int PieceSize;

  public void read_file() throws FileNotFoundException, IOException, NumberFormatException {

    try {
      FileReader fr = new FileReader(common_file_name);
      BufferedReader br = new BufferedReader(fr);

      for (String line; (line = br.readLine()) != null;) {
        String[] single_line = line.split(" ");
        String key = single_line[0];
        String value = single_line[1];

        if (key.equals("NumberOfPreferredNeighbors")) {
          NumberOfPreferredNeighbors = Integer.parseInt(value);
        }

        else if (key.equals("UnchokingInterval")) {
          UnchokingInterval = Integer.parseInt(value);
        }

        else if (key.equals("OptimisticUnchokingInterval")) {
          OptimisticUnchokingInterval = Integer.parseInt(value);
        }

        else if (key.equals("FileName")) {
          FileName = value;
        }

        else if (key.equals("FileSize")) {
          FileSize = Integer.parseInt(value);
        }

        else if (key.equals("PieceSize")) {
          PieceSize = Integer.parseInt(value);
        }
      }
      br.close();
    }

    catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    catch (IOException e) {
      e.printStackTrace();
    }

    catch (NumberFormatException e) {
      e.printStackTrace();
    }
  }



	/**
	* Returns value of common_file_name
	* @return
	*/
	public static String getCommon_file_name() {
		return common_file_name;
	}

	/**
	* Returns value of NumberOfPreferredNeighbors
	* @return
	*/
	public static int getNumberOfPreferredNeighbors() {
		return NumberOfPreferredNeighbors;
	}

	/**
	* Sets new value of NumberOfPreferredNeighbors
	* @param
	*/
	public static void setNumberOfPreferredNeighbors(int NumberOfPreferredNeighbors) {
		CommonConfigRead.NumberOfPreferredNeighbors = NumberOfPreferredNeighbors;
	}

	/**
	* Returns value of UnchokingInterval
	* @return
	*/
	public static int getUnchokingInterval() {
		return UnchokingInterval;
	}

	/**
	* Sets new value of UnchokingInterval
	* @param
	*/
	public static void setUnchokingInterval(int UnchokingInterval) {
		CommonConfigRead.UnchokingInterval = UnchokingInterval;
	}

	/**
	* Returns value of OptimisticUnchokingInterval
	* @return
	*/
	public static int getOptimisticUnchokingInterval() {
		return OptimisticUnchokingInterval;
	}

	/**
	* Sets new value of OptimisticUnchokingInterval
	* @param
	*/
	public static void setOptimisticUnchokingInterval(int OptimisticUnchokingInterval) {
		CommonConfigRead.OptimisticUnchokingInterval = OptimisticUnchokingInterval;
	}

	/**
	* Returns value of FileName
	* @return
	*/
	public static String getFileName() {
		return FileName;
	}

	/**
	* Sets new value of FileName
	* @param
	*/
	public static void setFileName(String FileName) {
		CommonConfigRead.FileName = FileName;
	}

	/**
	* Returns value of FileSize
	* @return
	*/
	public static int getFileSize() {
		return FileSize;
	}

	/**
	* Sets new value of FileSize
	* @param
	*/
	public static void setFileSize(int FileSize) {
		CommonConfigRead.FileSize = FileSize;
	}

	/**
	* Returns value of PieceSize
	* @return
	*/
	public static int getPieceSize() {
		return PieceSize;
	}

	/**
	* Sets new value of PieceSize
	* @param
	*/
	public static void setPieceSize(int PieceSize) {
		CommonConfigRead.PieceSize = PieceSize;
	}


  public static void main(String args[]) throws FileNotFoundException, IOException{
    CommonConfigRead obj = new CommonConfigRead();
    try{
      obj.read_file();
      System.out.println(obj.getFileName());
    }

    catch(FileNotFoundException e) {
      e.printStackTrace();
    }

    catch(IOException e) {
      e.printStackTrace();
    }
  }
}
