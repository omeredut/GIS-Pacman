package file_format;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Set;

import game.GameElement;

public class CsvWriter {
	public static int gameNum=1;
	public Date date;
	
	public void write(String header, Set<GameElement> set) throws FileNotFoundException {
		
		String fileName=date.getDate()+"."+date.getMonth()+"."+date.getYear()+"-"+gameNum+".csv";
		PrintWriter pw = new PrintWriter(new File(fileName));
		StringBuilder sb = new StringBuilder();
		sb.append(header);
		for (GameElement gameElement : set) {
			sb.append('\n');
			sb.append(gameElement.toString());
		}

		pw.write(sb.toString());
		pw.close();
		gameNum++;
	}
}
