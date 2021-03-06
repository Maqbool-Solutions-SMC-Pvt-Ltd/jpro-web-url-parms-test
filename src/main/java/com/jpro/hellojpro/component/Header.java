package com.jpro.hellojpro.component;

import com.jpro.web.Util;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Header extends HBox {

    String currentURL;

    public Header(String currentURL) {
        this.currentURL = currentURL;
        getStyleClass().add("header");

        getChildren().add(new Link("Header", "/landing?category=xyz"));
        getChildren().add(new Link("Info", "/info?content=abc"));
        getChildren().add(new Link("FXML", "/fxml"));
    }

    class Link extends Label {

        Link(String txt, String link) {
            super(txt);

            Util.setLink(this, link, txt);
            getStyleClass().add("header-link");
            System.out.println("currentURL: \"" + currentURL + "\"");
            System.out.println("link: \"" + link + "\"");
            if (link.equals(currentURL)) {
                System.out.println("Was true!");
                getStyleClass().add("header-link-selected");
            }
        }
    }
}
