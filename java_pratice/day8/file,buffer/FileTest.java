package com.ssafy;

import java.io.File;
import java.io.IOException;

public class FileTest {

		public static void main(String[] args) throws IOException {
			// Check c:\SSAFY Creation
			String dirName = "c:"+File.separator+"SSAFY"+File.separator+"mydir";
			
			File file1 = new File(dirName);

			if( file1.exists() ) {
				System.out.println("Folder Exists!" );
				
			}else {
				boolean success = file1.mkdir();
				if( success ) {
					System.out.println("Folder Created!" );
				}
			}
			
			File file2 = new File(dirName, "test2.txt");
			
//			file2.createNewFile();		
			file2.delete();
		}

}
