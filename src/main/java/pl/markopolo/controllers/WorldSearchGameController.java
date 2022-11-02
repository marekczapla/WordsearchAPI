package pl.markopolo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.markopolo.services.WordGridService;

import java.util.Arrays;
import java.util.List;


@RestController("/")
public class WorldSearchGameController {

    @Autowired
    WordGridService wordGridService;

    @GetMapping("/wordgrid")
    @CrossOrigin(origins = "http://localhost:1234")
    public String createWordGrid(@RequestParam int gridSize, @RequestParam(required=false) String wordList) {
        List<String> words = Arrays.asList(wordList.split(","));
        char[][] grid = wordGridService.generateGrid(gridSize, words);
        String gridToString = "";
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                gridToString += grid[i][j] + " ";
            }
            gridToString += "\r\n";
        }
        return gridToString;
    }
}
