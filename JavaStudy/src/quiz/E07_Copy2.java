package quiz;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	
	public class E07_Copy2 {
	
	    public static void main(String[] args) {
	        CopyDirectory dir3 = new CopyDirectory("./myimage/");
	        
	        System.out.println(dir3);
	        
	        dir3.copy();
	        
	//        CopyDirectory dir1 = new CopyDirectory("./myimage/memo");
	//        CopyDirectory dir2 = new CopyDirectory("./myimage/animals/dog/");
	//        
	//        System.out.println(dir1);
	//        System.out.println(dir2);
	//        
	//        dir1.copy();
	//        dir2.copy();
	    }
	}
	
	class CopyDirectory {
	    String srcPath;
	    String destPath;
	    File srcDir;
	    File destDir;
	    
	    public CopyDirectory(String srcPath) {
	        this.srcPath = srcPath;
	        this.srcDir = new File(srcPath);
	        
	        System.out.println("Parent: " + srcDir.getParent());
	        System.out.println("Name: " + srcDir.getName());
	        
	        this.destPath = srcDir.getName() + "2";
	        this.destDir = new File(srcDir.getParent(), destPath);
	        
	        System.out.println("srcPath: " + srcPath);
	        System.out.println("destPath: " + destPath);
	    }
	    
	    // 텍스트 파일이 아닌 경우 InputStream/OutputStream을 활용해
	    // byte 단위로 복사를 진행해야 한다
	    private void copyFile(File f) {
	        String name = f.getName();
	        
	        FileInputStream in = null;
	        FileOutputStream out = null;
	        
	        // 복사하려는 파일의 경로를 만든다
	        File destFile = new File(destDir, f.getPath().substring(srcDir.getPath().length()));
	        
	        // 복사하려는 경로의 부모 폴더가 아직 없다면 폴더를 생성한다
	        File destParent = destFile.getParentFile();
	        if (!destParent.exists()) {
	            destParent.mkdirs();
	        }
	        
	        try {
	            in = new FileInputStream(f);
	            out = new FileOutputStream(destFile);
	            
	            byte[] buff = new byte[1024];
	            
	            int len;
	            while ((len = in.read(buff)) != -1) {
	                out.write(buff, 0, len);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (in != null) in.close();
	                if (out != null) out.close();
	            } catch (IOException e) {}
	        }
	    }
	    
	    // Reader, Writer는 char단위로 데이터를 꺼내기 때문에
	    // 텍스트 파일 복사에는 문제가 없지만
	    // 그림 데이터를 문자로 바꿔버려서 그림이 깨진다
	    private void copyTextFile(File f) {
	        String name = f.getName();
	        
	        FileReader in = null;
	        FileWriter out = null;
	        
	        // 복사하려는 파일의 경로를 만든다
	        File destFile = new File(destDir, f.getPath().substring(srcDir.getPath().length()));
	        
	        // 복사하려는 경로의 부모 폴더가 아직 없다면 폴더를 생성한다
	        File destParent = destFile.getParentFile();
	        if (!destParent.exists()) {
	            destParent.mkdirs();
	        }
	        
	        try {
	            in = new FileReader(f);
	            out = new FileWriter(destFile);
	            
	            char[] buff = new char[1024];
	            
	            int len;
	            while ((len = in.read(buff)) != -1) {
	                out.write(buff, 0, len);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	                if (out != null) {
	                    out.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    public void copyFolder(File dir) {
	        System.out.println("### " + dir + "의 내용 ###");
	        for (File f : dir.listFiles()) {
	            if (f.isFile()) {
	            	 copyFile(f);
	            } else {
	                File newDestDir = new File(destDir, f.getPath().substring(srcDir.getPath().length()));
	                newDestDir.mkdir();
	                new CopyDirectory(f.getPath()).copyFolder(f);
	            }
	        }
	    }
	    
	    public void copy() {
	        if (!srcDir.exists()) {
	            System.out.println("원본 폴더가 존재하지 않아서 복사할 수 없습니다!");
	            return;
	        }
	        
	        if (!srcDir.isDirectory()) {
	            System.out.println("디렉토리가 아닌 것은 복사할 수 없습니다!");
	            return;
	        }
	        
	        if (!destDir.exists()) {
	            destDir.mkdir();
	        }
	        
	        for (File f : srcDir.listFiles()) {
	            if (f.isFile()) {
	            	copyFile(f);
	            } else {
	                copyFolder(f);
	            }
	        }
	    }
	    
	    @Override
	    public String toString() {
	        return String.format("원본의 경로: %s, 복사본의 경로 %s", srcPath, destPath);
	    }
	}

/*
 	package quiz;
	
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	
	public class E07_Copy2 {
	
		public static void main(String[] args) {
			CopyDirectory dir3 = new CopyDirectory("./myimage/");
			
			System.out.println(dir3);
			
			dir3.copy();
			
	//		CopyDirectory dir1 = new CopyDirectory("./myimage/memo");
	//		CopyDirectory dir2 = new CopyDirectory("./myimage/animals/dog/");
	//		
	//		System.out.println(dir1);
	//		System.out.println(dir2);
	//		
	//		dir1.copy();
	//		dir2.copy();
		}
	}
	
	class CopyDirectory {
		String srcPath;
		String destPath;
		File srcDir;
		File destDir;
		
		public CopyDirectory(String srcPath) {
			this.srcPath = srcPath;
			this.srcDir = new File(srcPath);
			
			System.out.println("Parent: " + srcDir.getParent());
			System.out.println("Name: " + srcDir.getName());
			
			this.destPath = srcDir.getName() + "2";
			this.destDir = new File(srcDir.getParent(), destPath);
			
			System.out.println("srcPath: " + srcPath);
			System.out.println("destPath: " + destPath);
		}
		
		
		
		// 텍스트 파일이 아닌 경우 InputStrem/OutputStream을 활용해
		// byte 단위로 복사를 진행해야 한다
		private void copyFile(File f) {
			String name = f.getName();
			
			FileInputStream in = null;
			FileOutputStream out = null;
			
			// 복사하려는 파일의 경로를 만든다
			File destFile = newFile(destPath, 
					f.getPath().substring(srcPath.length()));
			
			// 복사하려는 경로의 부모 폴더가 아직 없다면 폴더를 생성한다
			File destParent = destFile.getParentFile();
			if (!destParent.exists()) {
				destParent.mkdirs();
			}
			
			try {
				in = new FileInputStream(f);
				out = new FileOutputStream(destFile);
				
				byte[] buff = new byte[1024];
				
				int len;
				while ((len = in.read(buff)) != -1) {
					out.write(buff);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (in != null) in.close();
					if (out != null) out.close();
				} catch (IOException e) {}
			}
		}
		
		// Reader, Writer는 char단위로 데이터를 꺼내기 때문에
		// 텍스트 파일 복사에는 문제가 없지만
		// 그림 데이터를 문자로 바꿔버려서 그림이 깨진다
		private void copyTextFile(File f) {
	//		System.out.printf("파일명: %s, 종류: %s\n", 
	//				f.getName(), f.isDirectory() ? "폴더" : "파일");
			
			String name = f.getName();
			
			FileReader in = null;
			FileWriter out = null;
			
			try {
	            in = new FileReader(new File(srcDir, name));
	            out = new FileWriter(new File(destDir, name));
	            
	            char[] buff = new char[1024];
	            
	            int len;
	            while ((len = in.read(buff)) != -1) {
	                out.write(buff, 0, len);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (in != null) {
	                    in.close();
	                }
	                if (out != null) {
	                    out.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
		}
		
		public void copyFolder(File dir) {
			System.out.println("### " + dir + "의 내용 ###");
			for (File f : dir.listFiles()) {
				if (f.isFile()) {
					copyFile(f);
				} else {
					copyFolder(f);
				}
				
				// .\myimage\memo2\test2.txt
				// .\memo2\test2.txt
	//			System.out.println("name: " + f.getName());
	//			System.out.println("path: " + f.getPath());
	//			System.out.println("sub: " + f.getPath().substring(srcPath.length()));
	//			System.out.println("add parent: " + new File(destPath, 
	//					f.getPath().substring(srcPath.length())));
			}
		}
		
		public void copy() {
			if (!srcDir.exists()) {
				System.out.println("원본 폴더가 존재하지 않아서 복사할 수 없습니다!");
				return;
			}
			
			if (!srcDir.isDirectory()) {
				System.out.println("디렉토리가 아닌 것은 복사할 수 없습니다!");
				return;
			}
			
			if (!destDir.exists()) {
				destDir.mkdir();
			}
			
			for (File f : srcDir.listFiles()) {
				if (f.isFile()) {
					copyFile(f);
				} else {
					
				}
			}
		}
		
		@Override
		public String toString() {
			return String.format("원본의 경로: %s, 복사본의 경로 %s", srcPath, destPath);
		}
	}
 */
	