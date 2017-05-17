package chongxinet.portal.api.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	// ȫ������
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	public MD5() {
	}

	// ������ʽΪ���ָ��ַ���
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

	// ������ʽֻΪ����
	private static String byteToNum(byte bByte) {
		int iRet = bByte;
		System.out.println("iRet1=" + iRet);
		if (iRet < 0) {
			iRet += 256;
		}
		return String.valueOf(iRet);
	}

	// ת���ֽ�����Ϊ16�����ִ�
	private static String byteToString(byte[] bByte) {
		StringBuffer sBuffer = new StringBuffer();
		for (int i = 0; i < bByte.length; i++) {
			// sBuffer.append(byteToArrayString(bByte[i]));
			/*
			 * Integer.toHexString�Ĳ�����int�����������&0xff����ô��һ��byte��ת����intʱ������int��32λ��
			 * ��byteֻ��8λ��ʱ����в�λ��
			 * ���粹��11111111��ʮ������Ϊ-1ת��Ϊintʱ��Ϊ11111111111111111111111111111111�ö�1
			 * .��0xffffffff����������ǲ��Եģ����ֲ�λ�ͻ������ ��0xff����󣬸�24���ؾͻᱻ��0�ˣ�����Ͷ��ˡ�
			 * 
			 * ----
			 * Java�е�һ��byte���䷶Χ��-128~127�ģ���Integer.toHexString�Ĳ���������int�����������
			 * &0xff����ô��һ��byte��ת����intʱ��
			 * ���ڸ���������λ��չ��������˵��һ��byte��-1����0xff�����ᱻת����int��
			 * -1����0xffffffff������ôת�����Ľ���Ͳ���������Ҫ���ˡ�
			 * 
			 * ��0xffĬ�������Σ����ԣ�һ��byte��0xff������Ƚ��Ǹ�byteת�����������㣬����������еĸߵ�24�����ؾ��ܻᱻ��0��
			 * ���ǽ������������Ҫ�ġ�
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
			// md.digest() �ú�������ֵΪ��Ź�ϣֵ�����byte����
			resultString = byteToString(md.digest(strObj.getBytes()));
		} catch (NoSuchAlgorithmException ex) {
			ex.printStackTrace();
		}
		return resultString;
	}

}
