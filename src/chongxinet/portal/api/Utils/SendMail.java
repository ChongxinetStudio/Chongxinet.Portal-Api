package chongxinet.portal.api.Utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendMail {

	// �����˵� ���� �� ���루�滻Ϊ�Լ�����������룩
	// PS: ĳЩ���������Ϊ���������䱾������İ�ȫ�ԣ��� SMTP �ͻ��������˶������루�е������Ϊ����Ȩ�롱��,
	// ���ڿ����˶������������, ����������������ʹ������������루��Ȩ�룩��
	public static String myEmailAccount = "kaysen007@163.com";
	public static String myEmailPassword = "kaysen007";

	// ����������� SMTP ��������ַ, ����׼ȷ, ��ͬ�ʼ���������ַ��ͬ, һ��(ֻ��һ��, ���Ǿ���)��ʽΪ: smtp.xxx.com
	// ����163����� SMTP ��������ַΪ: smtp.163.com
	public static String myEmailSMTPHost = "smtp.163.com";

	// �ռ������䣨�滻Ϊ�Լ�֪������Ч���䣩
	public static String receiveMailAccount = "chang.li@chongxinet.com";

	public static void main(String[] args) throws Exception {
		// 1. ������������, ���������ʼ��������Ĳ�������
		Properties props = new Properties(); // ��������
		props.setProperty("mail.transport.protocol", "smtp"); // ʹ�õ�Э�飨JavaMail�淶Ҫ��
		props.setProperty("mail.smtp.host", myEmailSMTPHost); // �����˵������ SMTP
																// ��������ַ
		props.setProperty("mail.smtp.auth", "true"); // ��Ҫ������֤

		// 2. �������ô����Ự����, ���ں��ʼ�����������
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // ����Ϊdebugģʽ, ���Բ鿴��ϸ�ķ��� log

		// 3. ����һ���ʼ�
		MimeMessage message = createMimeMessage(session, myEmailAccount,
				receiveMailAccount);

		// 4. ���� Session ��ȡ�ʼ��������
		Transport transport = session.getTransport();

		// 5. ʹ�� �����˺� �� ���� �����ʼ�������, ������֤����������� message �еķ���������һ��, ���򱨴�
		transport.connect(myEmailAccount, myEmailPassword);

		// 6. �����ʼ�, �������е��ռ���ַ, message.getAllRecipients() ��ȡ�������ڴ����ʼ�����ʱ���ӵ������ռ���,
		// ������, ������
		transport.sendMessage(message, message.getAllRecipients());

		// 7. �ر�����
		transport.close();
	}

	/**
	 * ����һ��ֻ�����ı��ļ��ʼ�
	 * 
	 * @param session
	 *            �ͷ����������ĻỰ
	 * @param sendMail
	 *            ����������
	 * @param receiveMail
	 *            �ռ�������
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session,
			String sendMail, String receiveMail) throws Exception {
		// 1. ����һ���ʼ�
		MimeMessage message = new MimeMessage(session);

		// 2. From: ������
		message.setFrom(new InternetAddress(sendMail, "����˧", "UTF-8"));

		// 3. To: �ռ��ˣ��������Ӷ���ռ��ˡ����͡����ͣ�
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(
				receiveMail, "ͷ��", "UTF-8"));

		// 4. Subject: �ʼ�����
		message.setSubject("���Գɹ�", "UTF-8");

		// 5. Content: �ʼ����ģ�����ʹ��html��ǩ��
		message.setContent("ͷ�����ҵ�java���ʼ�����д����", "text/html;charset=UTF-8");

		// 6. ���÷���ʱ��
		message.setSentDate(new Date());

		// 7. ��������
		message.saveChanges();

		return message;
	}

}