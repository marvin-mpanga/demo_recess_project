import java.io.*;
import java.net.*;

public class PupilRegistration {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 9000);

        
            PrintWriter output = new PrintWriter(s.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        
         
            // Read input from pupil
            System.out.print("Enter username: ");
            String username = userInput.readLine();

            System.out.print("Enter firstname: ");
            String firstname = userInput.readLine();

            System.out.print("Enter lastname: ");
            String lastname = userInput.readLine();

            System.out.print("Enter email address: ");
            String email = userInput.readLine();

            System.out.print("Enter date of birth (YYYY-MM-DD): ");
            String dob = userInput.readLine();

            // Construct the registration command
            String command = "register " + username + " " + firstname + " " + lastname + " " + email + " " + dob;

            // Send the command to the server
            output.println(command);

            // Read and print server response
            String response = input.readLine();
            System.out.println("Server response: " + response);
        

        s.close();
    }
}
    
    


