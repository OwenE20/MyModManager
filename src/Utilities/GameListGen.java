package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mike-Owen on 7/27/2018.
 */
public class GameListGen {

    private static Stream<Path> returnList;
    public static ArrayList<Path> pathArrayList;
    private static Path startPath;
    private static String directoy;


    public static void  generateList(){
        directoy = "C:\\Program Files (x86)\\Steam\\steamapps\\common";
        startPath = Paths.get(directoy);

        try{
            returnList = Files.walk(startPath,1, FileVisitOption.FOLLOW_LINKS);
            pathArrayList = returnList.collect(Collectors.toCollection(ArrayList::new));
            pathArrayList.remove(0);


        }catch (IOException e){

        }

    }
}
