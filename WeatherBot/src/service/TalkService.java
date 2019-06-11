package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import model.Talk;

public class TalkService {

	Properties properties = new Properties();

	public TalkService() {
        super();

        InputStream istream;
		try {
			istream = new FileInputStream("main.properties");
	        properties.load(istream);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
    }

	public String TalkToHtml(Talk talk) {
		String html = "";
		String icon = talk.getFrom_user()=="kumozou" ? properties.getProperty("kumozou_icon") : properties.getProperty("user_icon");
		String style_cls = talk.getFrom_user()=="kumozou" ? "kumozou" : "user";
		String name = talk.getFrom_user()=="kumozou" ? "くもぞう" : "あなた";

		html = "<div class=\"talk " + style_cls + "\">\r\n" +
				"	<div class=\"icon\"><img src=\"./images/" + icon + "\" alt=\"" + name + "\" title=\"" + name + "\" /></div>\r\n" +
				"	<div class=\"text\">" + talk.getTalk() + "</div>\r\n" +
				"</div>\r\n";
		return html;
	}
}
