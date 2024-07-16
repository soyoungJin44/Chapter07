package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {

	// 연결할 다른 컴터라고 생각
	public static void main(String[] args) throws IOException {

		// 입력용 스캐너
		//Scanner sc = new Scanner(System.in);

		Socket socket = new Socket(); // 전화기 들고 시작
		System.out.println("클라이언트 시작");

		System.out.println("서버에 연결을 요청합니다.");
		socket.connect(new InetSocketAddress("192.168.0.52", 10001)); // 이 ip로 찾아가라

		System.out.println("서버에 연결 되었습니다.");

		// 소켓이 주소트림을 만들어서 달라고 하면됨ㅇㅇ
		OutputStream out = socket.getOutputStream();
		OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8");

		BufferedWriter bw = new BufferedWriter(osr);

		InputStream in = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");

		BufferedReader br = new BufferedReader(isr);
		
		//스캐너 준비
		InputStream scin = System.in;
		InputStreamReader scisr = new InputStreamReader(scin, "UTF-8");
		BufferedReader sbr = new BufferedReader(scisr);

		while (true) {
			System.out.print("입력해주세요:");
			//String str = sc.nextLine();
			String scbr = sbr.readLine();
			
			if ("/q".equals(scbr)) {
				break;
			}

			bw.write(scbr);
			bw.newLine();
			bw.flush(); // buffered 공간이 다 안차도 보내주세요.

			String msg1 = br.readLine();
			System.out.println("돌려받은받은 메세지: " + msg1);
		}
			System.out.println("===============");
			System.out.println("끄으응읏");
		
		bw.close();
		br.close();
		socket.close();
	}

}
