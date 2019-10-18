package main.java.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class JDOM {
	public static String write(String id, String n, String p) {
		String path = "D:\\eclipse_java\\diary_software\\src\\main\\resources\\UserInfo.xml";
		File file = new File(path);
		SAXBuilder saxBuilder = new SAXBuilder();
		Document doc;
		try {
			doc = saxBuilder.build(file);
			Element root = doc.getRootElement();
			Element user = new Element("User");
			Element name = new Element("name");
			Element password = new Element("password");
			if (checkId(id, root)) {
				user.setAttribute(new Attribute("id", id));
				name.setText(n);
				password.setText(p);
				user.addContent(name);
				user.addContent(password);
				root.addContent(user);
				XMLOutputter out = new XMLOutputter();
				out.output(doc, new FileOutputStream(file));
				return "register successful";

			} else {
				return "ID already exists, please input again";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "ERROR";
	}

	public static boolean checkId(String id, Element root) {
		boolean flag = true;
		@SuppressWarnings("unchecked")
		List<Element> list = root.getChildren("User");
		Iterator<Element> it = list.iterator();
		while (it.hasNext()) {
			Element element = it.next();
			if (element.getAttribute("id").equals(id)) {
				flag = false;
			}
		}
		return flag;
	}

	public static String read(String id, String password) {
		String path = "D:\\eclipse_java\\diary_software\\src\\main\\resources\\UserInfo.xml";
		File file = new File(path);
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			Document doc = saxBuilder.build(file);
			Element root = doc.getRootElement();
			String info = getPassword(root).get(id);
			if (info == null) {
				return "User does not exist!!";
			}
			String[] buf = info.split("/");
			if (buf[0].equals(password)) {
				return "Successful landing/" + buf[1];
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Wrong password!!";
	}

	@SuppressWarnings("unchecked")
	private static Map<String, String> getPassword(Element root) {
		Map<String, String> map = new TreeMap<String, String>();
		List<Element> list = new ArrayList<Element>();
		list = root.getChildren("User");
		Iterator<Element> it = list.iterator();
		while (it.hasNext()) {
			Element element = it.next();
			String id = element.getAttributeValue("id");
			String name = element.getChildText("name");
			String password = element.getChildText("password");
			map.put(id, getInfo(password, name));
		}
		return map;
	}

	private static String getInfo(String passwd, String name) {

		return passwd + "/" + name;

	}

}
