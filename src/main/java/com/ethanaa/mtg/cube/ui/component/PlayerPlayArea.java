package com.ethanaa.mtg.cube.ui.component;


import com.ethanaa.mtg.cube.model.PlayArea;
import org.springframework.stereotype.Component;

@Component
public class PlayerPlayArea {

    private PlayArea playArea = new PlayArea();

    public PlayArea getPlayArea() {
        return playArea;
    }

}
