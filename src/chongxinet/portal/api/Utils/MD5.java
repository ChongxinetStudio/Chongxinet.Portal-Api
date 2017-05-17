package chongxinet.portal.api.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	// 全局数组
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public MD5() {
	}

	// 返回形式为数字跟字符串
	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		// System.out.println("iRet="+iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return strDigits[iD1] + strDigits[iD2];
	}

	// 返回形式只为数字
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// 转换字节数组为16进制字串
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			// sBuffer.append(byteToArrayString(bByte[i]));
			/*
			 * Integer.toHexString的参数是int，如果不进行&0xff，那么当一个byte会转换成int时，由于int是32位，
			 * 而byte只有8位这时会进行补位，
			 * 例如补码11111111的十进制数为-1转换为int时变为11111111111111111111111111111111好多1
			 * .即0xffffffff但是这个数是不对的，这种补位就会造成误差。 和0xff相与后，高24比特就会被清0了，结果就对了。
			 * 
			 * ----
			 * Java中的一个byte，其范围是-128~127的，而Integer.toHexString的参数本来是int，如果不进行
			 * &0xff，那么当一个byte会转换成int时，
			 * 对于负数，会做位扩展，举例来说，一个byte的-1（即0xff），会被转换成int的
			 * -1（即0xffffffff），那么转化出的结果就不是我们想要的了。
			 * 
			 * 而0xff默认是整形，所以，一个byte跟0xff相与会先将那个byte转化成整形运算，这样，结果中的高的24个比特就总会被清0，
			 * 于是结果总是我们想要的。
			 */
			int b = bByte[i] & 0xff;
			String hstr = Integer.toHexString(b);
			sBuffer.append(hstr);
		}
		return sBuffer.toString();
	}

	public static String GetMD5Code(String strObj) {
		String resultString = null;
		try {
			resultString = new String(strObj);
			MessageDigest md = MessageDigest.getInstance("MD5");
			// md.digest() 该函数返回值为存放哈希值结果的byte数组
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

}
