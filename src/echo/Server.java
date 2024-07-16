package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	public static void main(String[] args) throws IOException {
		// 소켓생성
		ServerSocket serverSocket = new ServerSocket();

		// 이걸로 ip, 포트번호 한번 싸서 bind값 넣어줘야함.>> new InetSocketAdress("192.168.0.52",10001);
		// **걍외우셈
		serverSocket.bind(new InetSocketAddress("192.168.0.52", 10001)); // 포트 세팅 완료 (서버켜짐 대기중 이라고 생각)

		System.out.println("<서버 스따뜨>");
		System.out.println("===============");
		
		
		//////////////////출장
		while(true) {
			System.out.println("[연결을 기다리고있슴당]");

			Socket socket = serverSocket.accept(); // socket은 종이컵 전화기라고 생각 대기상태에 있다가 누가 오면 알려줌
			
			Thread thread = new ServerThread(socket);
			thread.start();
		
	
		}
	}
}