package controller;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class RedesController {
	public static String getSO() {
		return System.getProperty("os.name");
	}

	public static String getIP() {
		String ip = "1";
		if (getSO().contains("Windows")) {
			String cmds[] = { "cmd", "/c", "ipconfig /all" };
			Process process;
			try {
				process = Runtime.getRuntime().exec(cmds);
				LineNumberReader l = new LineNumberReader(new InputStreamReader(process.getInputStream()));
				String s;
				String Adapters = null;
				StringBuffer stringbuffer = new StringBuffer();
				while ((s = l.readLine()) != null) {
					s.trim();
					if (s.length() > 0) {
						if (s.contains("Adaptador")) {
							Adapters = s;
						}
						if (s.contains("IPv4")) {
							stringbuffer.append(Adapters + "\n" + s + "\n");
						}
					}
				}
				return stringbuffer.toString();
			} catch (IOException e) {
				System.out.println("blabla");
			}

		} else {
			String cmds[] = { "cmd", "/c", "ipconfig /all" };
			Process process;
			try {
				process = Runtime.getRuntime().exec(cmds);
				LineNumberReader l = new LineNumberReader(new InputStreamReader(process.getInputStream()));
				String s;
				String Adapters = null;
				StringBuffer stringbuffer = new StringBuffer();
				while ((s = l.readLine()) != null) {
					s.trim();
					if (s.length() > 0) {
						if (s.contains("adapter")) {
							Adapters = s;
						}
						if (s.contains("IPv4")) {
							stringbuffer.append(Adapters + "\n" + s + "\n");
						}
					}
				}
				return stringbuffer.toString();
			} catch (IOException e) {
				System.out.println("blabla");
			}
		}
		return ip;
	}

	public static String getPING() {
		String ping = "1";
		if (getSO().contains("Windows")) {
			String cmds[] = { "cmd", "/c", "ping google.com -n 10" };
			Process process;
			String pingm[];

			int tempo = 0;
			try {
				process = Runtime.getRuntime().exec(cmds);
				LineNumberReader l = new LineNumberReader(new InputStreamReader(process.getInputStream()));
				String s;
				int cont = 0;
				StringBuffer stringbuffer = new StringBuffer();
				while ((s = l.readLine()) != null) {
					s.trim();
					if (s.length() > 0) {
						stringbuffer.append(s + "\n");
						if (s.contains("tempo=")) {
							pingm = s.split(" ");
							tempo = tempo + Integer.parseInt(pingm[4].replaceAll("\\D", ""));
							cont++;
							System.out.println("Ping em "+pingm[4]);
						}
					}
				}
					System.out.println("A média do ping é:" + tempo/cont);
				return stringbuffer.toString();
			} catch (IOException e) {
				System.out.println("blabla");
			}

		} else {

		}
		return ping;
	}
}