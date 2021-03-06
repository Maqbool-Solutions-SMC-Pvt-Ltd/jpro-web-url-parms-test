package com.jpro.hellojpro.page;

import com.jpro.hellojpro.component.Header;
import com.jpro.web.View;
import com.jpro.webapi.WebAPI;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public abstract class DefaultPage extends View {

    WebAPI webAPI;

    public DefaultPage(WebAPI webAPI) {
        this.webAPI = webAPI;
    }

    @Override
    public String title() {
        return "Title: Hello JPro";
    }

    @Override
    public String description() {
        return "I'm the description. Google will find me!";
    }

    @Override
    public boolean fullscreen() {
        return false;
    }

    @Override
    public Node content() {
        VBox innerVBox = new VBox(pageContent());
        innerVBox.getStyleClass().add("page-inner-vbox");
        VBox root = new VBox();
        root.getStyleClass().add("page-outer-vbox");
        root.getChildren().add(new Header(url()));
        root.getChildren().add(innerVBox);

//        Platform.runLater(() -> {
        System.out.println("Params: " + webAPI.getURLQueryParams());
        System.out.println("----------------------------------------");
//        });

        return root;
    }

    abstract public Node pageContent();
}
