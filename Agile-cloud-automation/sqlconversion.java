package com.example;
import java.util.Arrays;

public class MyClass {
  
   public static int[] getSliceOfArray(int[] arr, 
                                     int start, int end)
    {
  
        // Get the slice of the Array
        int[] slice = new int[end - start];
  
        // Copy elements of arr to slice
        for (int i = 0; i < slice.length; i++) {
            slice[i] = arr[start + i];
        }
  
        // return the slice
        return slice;
    }
  
    public static void main(String args[]) {
      String comment = "";
        boolean uml = True;
        boolean pk = False; 
        boolean table = False;
        boolean field = False;
        String[] primary = new String[""];
        String index = "";
        for (String word : data.strip("\\s+")){
            if(!word){
              continue;}
            if(word == "@startuml"){
              uml = True;
              continue;}
             if(!uml){
               continue;
             }
              if(word == "--"){
                continue;
              }
             String[] i = str.split(" ");
             fname = i[0];
             if(fname == ".." || fname == "__")
             {
               continue;
             }
             if(field && (word.contains("--"))){
              String[] arrOfStr = word.split("--", 2);
              for (String a: arrOfStr){
                i = a[0];
                comment = a[1];
             }
                String[] i = str.split(" ");
                           pk = False; 
                           idx = False;
             }
        if(fname[0].contains("+", "#")){
            if(fname[0] == "#"){
                pk = True;}
            else{
                idx = True;
            }
        	fname =getSliceOfArray(fname,1,length(fname)+1);
       		}
           if(l == "@enduml"){
            uml = False;
            continue;}
      }
        if(!uml){
             continue;
          }
        if(l.startswith("class")){
            table = True;
            field = False;
          	List<String> primary = Collections.<String>emptyList();
            //primary = [];
            index = "";
            //Table names are quoted and lower cased to avoid conflict with a mySQL reserved word
            System.out.println("CREATE TABLE IF NOT EXISTS `" + i[1].lower() + "` (");
            continue;
          }
        if(table & !field & l == "=="){ // Seperator after table description
            field = True;
            continue;
                                             }
        if(field & l == "}"){
        	table = False;
            field = False;
            System.out.println("  PRIMARY KEY (%s)" % ", ".join(primary), end="");
            if(index){
                System.out.println(",\n%s",getSliceOfArray(index,2,length(index)+1));
                index = "";
              }
            System.out.println(");\n");
            continue;
        }
        if(field & l == "#id"){
            System.out.println("  %-16s SERIAL," % "id");
        }
        if(field & l != "#id"){
            k=toString(getSliceOfArray(i,2,length(index)+1));
            j= " ".join(k.upper());
            System.out.println(" %-16s " %fname);
            System.out.println("   %s" %j, end="");
            if(comment){
                // Avoid conflict with apostrophes (use double quotation marks)
                System.out.println(" COMMENT \"%s\"" % strip_html_tags(comment.strip()), end="");
            }
            System.out.println(",");
          }
        if(field & pk){
            primary.append(fname);
          }
        if(field & idx){
            index += "  INDEX (%s),\n" % fname;
        }
          }
       }
}
