package com.demo.File;

import java.io.*;
import java.util.HashMap;

public  class ReadFile {

	/*
	 * 读取配置文件,返回String，String为文件内容
	 */
	public static String ReadProfile(String fileNameString) {
		BufferedReader reader = null;
		String retString = "";
		try {
			FileInputStream file = new FileInputStream(fileNameString);

			// reader = new BufferedReader(new FileReader(file));
			reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			String tempString = null;
			// int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				// line++;
				retString += tempString + "\r\n";
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return retString;
	}

	/*
	 * 读取配置文件,返回String，String为文件内容
	 */
	public static String Readfile(String fileName) {
		BufferedReader reader = null;
		String retString = "";
		try {
			FileInputStream file = new FileInputStream(fileName);

			// reader = new BufferedReader(new FileReader(file));
			reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			String tempString = null;
			// int line = 1;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 显示行号
				// System.out.println("line " + line + ": " + tempString);
				// line++;
				retString += tempString + "\r\n";
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return retString;
	}

	/*
	 * 将命令配置文件读取到mp中
	 */
	public static void ReadToMap(HashMap<String, String> mp, String fileName) {
		BufferedReader reader = null;

		try {
			FileInputStream file = new FileInputStream(fileName);
			reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 添加到mp中
				String tmpString[] = tempString.trim().split(" ");
				if (tmpString[0] != null && tmpString[1] != null) {
					mp.put(tmpString[0], tmpString[1]);
					// System.out.println("put succ");
				}

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

	}

	/*
	 * 将命令配置文件读取到mp中
	 */
	public static void ReadFileTypeToMap(HashMap<String, FileType> mp, String fileName) {
		BufferedReader reader = null;

		try {
			FileInputStream file = new FileInputStream(fileName);
			System.out.println("file availibale " + file.available());
			reader = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			String tempString = null;
			// 一次读入一行，直到读入null为文件结束
			while ((tempString = reader.readLine()) != null) {
				// 添加到mp中
				String tmpString[] = tempString.trim().split(" ");
				if (tmpString[0] != null && tmpString[1] != null
						&& tmpString[2] != null) {
					FileType fileType = new FileType();
					fileType.fileName = tmpString[1];
					fileType.fileType = tmpString[2];
					mp.put(tmpString[0], fileType);
					// System.out.println("put succ");
				}

			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}

	}

	// /**
	// * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
	// */
	// public void readFileByBytes(String fileName) {
	// File file = new File(fileName);
	// InputStream in = null;
	// try {
	// System.out.println("以字节为单位读取文件内容，一次读一个字节：");
	// // 一次读一个字节
	// in = new FileInputStream(file);
	// int tempbyte;
	// while ((tempbyte = in.read()) != -1) {
	// System.out.write(tempbyte);
	// }
	// in.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// return;
	// }
	// try {
	// System.out.println("以字节为单位读取文件内容，一次读多个字节：");
	// // 一次读多个字节
	// byte[] tempbytes = new byte[100];
	// int byteread = 0;
	// in = new FileInputStream(fileName);
	// ReadFile.showAvailableBytes(in);
	// // 读入多个字节到字节数组中，byteread为一次读入的字节数
	// while ((byteread = in.read(tempbytes)) != -1) {
	// System.out.write(tempbytes, 0, byteread);
	// }
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// } finally {
	// if (in != null) {
	// try {
	// in.close();
	// } catch (IOException e1) {
	// }
	// }
	// }
	// }
	//
	// public void ReadFileByBytes(String fileName) {
	// File fileS = new File(fileName);
	// if (!fileS.exists()) {
	// System.out.println("找不到指定文件");
	// return;
	// }
	// FileInputStream fileIS = null;
	// try {
	// fileIS = new FileInputStream(fileS);
	// byte[] byt = new byte[2];
	//
	// int data = fileIS.read(byt);
	// for (; data != -1;) {
	// int a = byt[0];
	// int b = byt[1];
	// if ((a >= 0 && a <= 127) && (b > 127 || b < 0)) {
	// System.out.print((char) a);
	// data = fileIS.read();
	// byt[0] = (byte) b;
	// byt[1] = (byte) data;
	//
	// }
	// String str = new String(byt);
	// System.out.print(str);
	// data = fileIS.read(byt);
	// }
	// System.out.println();
	//
	// } catch (FileNotFoundException ex) {
	// ex.printStackTrace();
	// } catch (IOException ex) {
	// ex.printStackTrace();
	// } finally {
	// if (fileIS != null) {
	// try {
	// fileIS.close();
	// } catch (IOException ex) {
	// ex.printStackTrace();
	// }
	// }
	// }
	// }

	/**
	 * 显示输入流中还剩的字节数
	 */
	@SuppressWarnings("unused")
	private static void showAvailableBytes(InputStream in) {
		try {
			System.out.println("当前字节输入流中的字节数为:" + in.available());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 第二种获取文件内容方式
	public static byte[] ReadFileByBytes(String filePath) {
		byte[] temp = null;
		byte[] bytes = null;
		try {
			FileInputStream in = new FileInputStream(filePath);

			ByteArrayOutputStream out = new ByteArrayOutputStream(1024);

			System.out.println("bytes available:" + in.available());

			temp = new byte[1024];

			int size = 0;

			while ((size = in.read(temp)) != -1) {
				out.write(temp, 0, size);
			}

			in.close();

			bytes = out.toByteArray();
			System.out.println("bytes size got is:" + bytes.length);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bytes;
	}

	// 将byte数组写入文件
	public static void WriteFileByBytes(String path, byte[] content) {

		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(content);
			fos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	public static void WriteFileByBytes(String path, String content) {

		try {
			FileOutputStream fos = new FileOutputStream(path);
			PrintWriter printWriter = new PrintWriter(fos);
			printWriter.write(content);
			printWriter.flush();
			printWriter.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}
	public static void getDirFile(String dirPath) {
		File file = new File(dirPath);
		String [] test;
		test = file.list();
		for (int i = 0; i < test.length; i++) {
			System.out.println(test[i]);
		}
	}
	/*
	 * 测试ReadFile类
	 */
	public static void main(String[] args) {
//		ReadFile readFile = new ReadFile("");
//		HashMap<String, String> mp = new HashMap<String, String>();
//		readFile.ReadToMap(mp, "resources/cmdMap.txt");
//
//		System.out.println(mp.get("3.1"));
//
//		HashMap<String, FileType> mp1 = new HashMap<String, FileType>();
//		readFile.ReadFileTypeToMap(mp1, "resources/cmdFilenameMap.txt");
//
//		FileType fileType = mp1.get("arraylist");
//		System.out.println(fileType.fileName + " " + fileType.fileType);
//		readFile.ReadFileByBytes("resources/cmdMap.txt");
		
		
		/*
		 * 测试图片读取
		 */
//		ReadFile readFile = new ReadFile();
//		byte[] byt = readFile.ReadFileByBytes("image/head.jpg");
//		readFile.WriteFileByBytes("image/head1.jpg", byt);
//		System.out.println("succ");
		//getDirFile("component");

	}

}
