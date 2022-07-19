package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }

    public void run() {

        WiseSayingController wiseSayingController = new WiseSayingController(sc);
        System.out.println("=== Quotes SSG ===");
        outer:
        while (true) {
            System.out.printf("Input) ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "enroll":
                    wiseSayingController.write(rq);
                    break;
                case "delete":
                    wiseSayingController.remove(rq);
                    break;
                case "list":
                    wiseSayingController.list(rq);
                    break;
                case "edit":
                    wiseSayingController.edit(rq);
                    break;
                case "finish":
                    break outer;
            }
        }

        sc.close();
    }
}