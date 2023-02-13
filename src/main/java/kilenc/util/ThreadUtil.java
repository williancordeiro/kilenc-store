package kilenc.util;

public class ThreadUtil extends Thread {
	
	private static final String WATING = "Aguarde...";
	private static final String COMPLITE = "Finalizado!";
	
	public String getWating() {
		return WATING;
	}
	
	public String getComplite() {
		return COMPLITE;
	}
	
	public void run() {
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
