package main;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Main {

    public static final String CONFIG_FILE = "config.json";

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(oracle.jdbc.driver.OracleDriver.class.getName());
        dataSource.setUrl("jdbc:oracle:thin:@aloe.cs.arizona.edu:1521:oracle");

        JSONObject config = takeUsernameAndPassword();
        if (config != null) {
            try {
                dataSource.setUsername(config.getString("username"));
                dataSource.setPassword(config.getString("password"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return dataSource;
    }

    /**
     * if there is a json file {@value CONFIG_FILE} under the root folder, this method will read that file and get
     * the username and password information. If there is any error occurred on reading, or the file does not exist,
     * this method will ask the user to input the username and password, and write it into the json file.
     *
     * @return a json object that including the database username and password information.
     */
    private JSONObject takeUsernameAndPassword() {
        File file = new File(CONFIG_FILE);
        if (file.exists()) {
            try (FileReader reader = new FileReader(file)) {
                StringBuilder sb = new StringBuilder();
                int c;
                while ((c = reader.read()) != -1) {
                    sb.append((char) c);
                }
                return new JSONObject(sb.toString());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                assert false;
            } catch (IOException | JSONException e) {
                e.printStackTrace();
                boolean success = file.delete();
                if (success) {
                    return takeUsernameAndPassword();
                }
            }
        } else {
            String username;
            String password;
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Please enter your oracle username: ");
                username = scanner.nextLine();
                System.out.print("Please enter your oracle password: ");
                password = scanner.nextLine();
            }
            if (username == null || password == null) {
                return null;
            }

            boolean success = false;
            try {
                success = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONObject config = new JSONObject();
            try {
                config.put("username", username);
                config.put("password", password);
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }

            if (success) {
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(config.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error: failed to create config file");
            }

            return config;
        }
        return null;
    }
}
