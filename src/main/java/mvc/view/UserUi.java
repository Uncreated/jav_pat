package mvc.view;

import mvc.controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserUi {

    private Controller controller;

    public UserUi(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                Long id = Long.valueOf(bufferedReader.readLine());
                System.out.println(controller.getCashAction(id));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
