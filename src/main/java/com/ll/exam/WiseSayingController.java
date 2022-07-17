package com.ll.exam;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService; //Course ukw

    WiseSayingController(Scanner sc) {
        this.sc =sc;
        wiseSayingService = new WiseSayingService(); // inserted the repo in Controller
    }

    public void edit(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        if (paramId ==0) {
            System.out.println("Please enter the ID.");
            return;
        }


        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);
        if (foundWiseSaying == null) {
            System.out.printf("No.%d does not exist in this system.\n", paramId);
            return;
        }

        System.out.printf("Registered quote) %s\n", foundWiseSaying.content);
        System.out.printf("A new quote: ");

        //Leave it up to the subordinate here also!*
        //foundWiseSaying.content = sc.nextLine();
        String content = sc.nextLine().trim();

        System.out.printf("Registered Author) %s\n", foundWiseSaying.author);
        System.out.printf("Author: ");
        String author = sc.nextLine().trim();

        wiseSayingService.edit(paramId, content, author);


        System.out.printf("No.%d quote has been revised, successfully.\n", paramId);
    }

    public void list(Rq rq) {
        System.out.println("-------------------------------------");
        System.out.println("No. / Quote                  / Author");
        System.out.println("-------------------------------------");
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();

        for (int i = wiseSayings.size() - 1; i >= 0;  i--){
            WiseSaying wiseSaying_ = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", wiseSaying_.id, wiseSaying_.content, wiseSaying_.author);
        }
    }

    public void write(Rq rq) {
        System.out.printf("Quote: ");
        String content = sc.nextLine().trim();
        System.out.printf("Author: ");
        String author = sc.nextLine().trim();
        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.printf("No.%d quote is registered, successfully.\n", wiseSaying.id);
    }

    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        if (paramId ==0) {
            System.out.println("Please enter the ID.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingService.findById(paramId);

        if (foundWiseSaying == null) {
            System.out.printf("No.%d does not exist in this system.\n", paramId);
            return;
        }

        wiseSayingService.remove(paramId);
        System.out.printf("No.%d quote has been deleted, successfully.\n", paramId);
    }
}

