package Utilities;

import sun.security.tools.PathList;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mike-Owen on 8/1/2018.
 */
public class FindAndExecute {

    private Path execPath;
    private Stream<Path> pathStream;
    private ArrayList<Path> pathArrayList;
    private PathMatcher matcher;



    public FindAndExecute(){
        pathArrayList = new ArrayList<>();
        matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.exe");

    }


    public void findExecPath(Path startPath){

        System.out.println(startPath);

        try {
            pathStream = Files.walk(startPath,1, FileVisitOption.FOLLOW_LINKS);
            pathArrayList = pathStream.collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException e){

        }

        for (Path path: pathArrayList ){
            System.out.println(path);

            if(matcher.matches(path)){
                System.out.println(path + "GANG GNAG");
                setExecPath(path);
                return;
            }

        }


    }

    public void execute(){

        String dir = getExecPath().toString();

        try {
            Process p = Runtime.getRuntime().exec(dir);
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    private void setExecPath(Path path){execPath = path;}

    public Path getExecPath(){return execPath;}






}
