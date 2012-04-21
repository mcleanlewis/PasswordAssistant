import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.NoSuchAlgorithmException;

public class PasswordPrompt {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	public static void main(String[] args) throws IOException,
			NoSuchAlgorithmException {


		String password = "";
		if (args.length < 2) {
			System.out.println("Enter 'exit' to exit");
		}

		while (!password.equals("exit")) {
			if (args.length < 2) {
				System.out.println("EnterWebSite : ");
			}
			DesEncrypter desEncrypter;
			if (args.length >= 2) {
				password = args[1];
			} else {
				InputStreamReader inp = new InputStreamReader(System.in);
				BufferedReader br = new BufferedReader(inp);
				password = br.readLine();
			}
			if (args.length >= 1) {
				desEncrypter = new DesEncrypter(args[0]);
			} else {
				desEncrypter = new DesEncrypter("insert your des passphrase");
			}
			try {
				if (!password.equals("exit")) {
					System.out.println(desEncrypter.encrypt(password)
							.replace("/", "").replace("=", "").trim()
							.substring(0, 10));
				}
				// Close the output stream
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
			if (args.length == 2) {
				password = "exit";
			}
		}

	}
}
