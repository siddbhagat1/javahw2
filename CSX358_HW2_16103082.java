package HELLO;
import java.io.*;

public class CSX358_HW2_16103082 {
	public static void main (String[] args)throws IOException
{
		BufferedReader br = new BufferedReader(new FileReader("HW2_dictionary.txt"));
		
		BufferedReader br1 = new BufferedReader(new FileReader("HW2_keywords.txt"));
		
		FileWriter fw = new FileWriter("CSX-16103082.txt");
		
		BufferedReader br2 = new BufferedReader(new FileReader("CSX-16103082.txt"));
		
		//storing words in Array of Strings
		String dicarr[] = new String[16000];	
		
		String keyarr[] = new String[84];
		int i = 0, j = 0, m, n;
		int xchanges = 0;
		String str;
		while ((str = br.readLine()) != null) {
			dicarr[i] = str;
			i++;

		}
		while ((str = br1.readLine()) != null) {
			keyarr[j] = str;
			j++;
		}
		// sorting using bubble sort for Dictionary
		for (i = 0; i < 16000; i++) {
			xchanges = 0;
			for (j = 0; j < 16000 - 1 - i; j++) {
				if ((dicarr[j].compareTo(dicarr[j + 1])) > 0) {
					String temp = dicarr[j];
					dicarr[j] = dicarr[j + 1];
					dicarr[j + 1] = temp;
					xchanges++;

				}
			}
			if (xchanges == 0)
				break;

		}
		//sorting using bubble sort for Keywords
		for (m = 0; m < 84; m++) {
			xchanges = 0;
			for (n = 0; n < 84 - 1 - m; n++) {
				if ((keyarr[n].compareTo(keyarr[n + 1])) > 0) {
					String temp = keyarr[n];
					keyarr[n] = keyarr[n + 1];
					keyarr[n + 1] = temp;
					xchanges++;
				}
			}
			if (xchanges == 0)
				break;
		}
		int d, kwnf = 0;
		for (m = 0; m < 84; m++) {
			String kw = keyarr[m];
			d = linearsearch(dicarr, kw);
			if (d == -1) {
				fw.write("key word is not found =" + kw+"\n");
				kwnf++;

			}
		}
		fw.write("\n\n no of keywords not found is =" + kwnf);
		String s = "";
		fw.close();
		while ((s = br2.readLine()) != null) {
			System.out.println(s);
		}

		br.close();
		br1.close();
		br2.close();
		

	}
	//linear search to find the keywords in Dictionary

	public static int linearsearch(String dicarr[],String kw) {
		int k = 0;
		while (k < 16000 && kw.compareToIgnoreCase(dicarr[k]) != 0)
			k++;
		if (k < 16000)
			return 1;
		else
			return -1;
	}

}
