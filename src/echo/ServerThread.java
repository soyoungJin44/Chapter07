package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

//출장ㄱ
public class ServerThread extends Thread {

	// 필드
	private Socket socket;

	// 생성자
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try{

	
		System.out.println("[클라이언트가 연결 되었습니다.]");

		// socket에서 가져와야하기때문에
		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");

		BufferedReader br = new BufferedReader(isr);

		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(out, "UTF-8");

		BufferedWriter bw = new BufferedWriter(osw);

		// 메세지 받기

		while (true) {

			String msg = br.readLine();
			System.out.println("받은 메세지: " + msg); // 테스트테스트

			if (msg == null) {
				break;
			}

			// 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		bw.close();
		br.close();
		
	}catch(IOException e){
		System.out.println(e.toString());
		}

	// 메서드 일반
	}

}


