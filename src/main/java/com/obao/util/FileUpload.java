package com.obao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

public class FileUpload {
	/**
	 * 上传文件
	 *
	 * @param fileName
	 * @param file
	 * @param savePath
	 *            (eg:upload)
	 * @return
	 */
	public static String upload(String fileName, File file, String savePath) {
		String fileNames = StringUtil.onlyString(fileName);
		String savePaths = ServletActionContext.getServletContext().getRealPath("/" + savePath + "/" + fileNames);
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(savePaths);
			System.out.println(savePaths);
			IOUtils.copy(fis, fos);
			fos.flush();
			fos.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileNames;
	}

	public static void delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return;
		} else {
			if (file.isFile())
				file.delete();
		}
	}
}
