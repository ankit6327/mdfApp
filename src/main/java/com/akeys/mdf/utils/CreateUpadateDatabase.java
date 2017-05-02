package com.akeys.mdf.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUpadateDatabase {

    private static final String AMCDataUrl = "http://portal.amfiindia.com/DownloadSchemeData_Po.aspx?mf=0";

    public static void updateAMCData(Connection con) {
	URL url = null;
	try {
	    url = new URL(AMCDataUrl);
	    try (InputStream in = url.openStream()) {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		PreparedStatement st = con.prepareStatement("INSERT INTO SCHEMES VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		int count = 0;
		String arr[] = new String[1000000];
		try {

		    br = new BufferedReader(new InputStreamReader(in));
		    line = br.readLine();
		    while ((line = br.readLine()) != null) {
			String[] data = line.split(cvsSplitBy);
			try {
			    st.setString(1, data[0]);
			    st.setInt(2, Integer.parseInt(data[1]));
			    st.setString(3, data[2]);
			    st.setString(4, data[3]);
			    st.setString(5, data[4]);
			    st.setString(6, data[5]);
			    st.setString(7, data[6]);
			    st.setString(8, data[7]);
			    st.setString(9, data[8]);
			    st.setString(10, data[9]);
			    try {
				st.setString(11, data[10]);
			    } catch (ArrayIndexOutOfBoundsException e) {
				st.setString(11, "");
				st.setString(12, "");
				st.executeUpdate();
				continue;
			    }
			    try {
				st.setString(12, data[11]);
			    } catch (ArrayIndexOutOfBoundsException e) {
				st.setString(12, "");
				st.executeUpdate();
				continue;
			    }

			    /*
			     * data[7]!= null ? data[7] :""); data[8]!= null ?
			     * data[8] :""); data[9]!= null ? data[9] :"");
			     * data[10]!= null ? data[10] :""); data[11]!= null
			     * ? data[11] :"");
			     */

			    st.executeUpdate();
			} catch (SQLException e) {
			    arr[count] = data[5];
			    count++;
			    System.out.println(e);
			}
			// use comma as separator
		    }
		} finally {
		    if (br != null) {
			try {
			    br.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		    }
		    System.out.println(count + "  " + arr[0]);
		}

	    } catch (Exception e) {
		System.out.println(e);
	    }
	} catch (MalformedURLException e) {
	    System.out.println("Url is incorrect");
	}

    }

    public static void getDataFromStream() {
	URL url = null;
	try {
	    url = new URL(AMCDataUrl);
	    try (InputStream in = url.openStream()) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		try {
		    br = new BufferedReader(new InputStreamReader(in));
		    line = br.readLine();
		    while ((line = br.readLine()) != null) {
			System.out.println(line);
			String[] data = line.split(cvsSplitBy);
			System.out.println("LENGTH IS ::: " + data.length);
		    }
		} finally {
		    if (br != null) {
			try {
			    br.close();
			} catch (IOException e) {
			    e.printStackTrace();
			}
		    }
		}

	    } catch (Exception e) {
		System.out.println(e);
	    }
	} catch (MalformedURLException e) {
	    System.out.println("Url is incorrect");
	}

    }

}
