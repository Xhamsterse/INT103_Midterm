
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class TestDiary {
   
   
   public static void main(String[] args) {
      System.out.println("-----------------Lab#2.1 Create Diary and call setter & getter------------");
      Diary myDiary=new Diary(3);
      myDiary.setDiaryName("My Memo");
      myDiary.setDiaryOwner("Suparb Rakdee");           
  
      System.out.println("My Diary Name: "+myDiary.getDiaryName());
      System.out.println("My Diary Owner: "+myDiary.getDiaryOwner());
      System.out.println("Last Index of Story at position: "+myDiary.getLastIndex());
      System.out.println();
      
      System.out.println("-------------------Lab#2.2 Print Diary Object (toString())---------------");
      System.out.println(myDiary);
      
      System.out.println("-------------------Lab#2.3 Adding Three Stories-------------------------");
      System.out.println("Adding The First Story: "+myDiary.addStory("My First Exam", LocalDate.of(2018, 05, 01), "It is quite hard exam"));
      System.out.println("Adding The Second Story: "+myDiary.addStory("My Second exam", LocalDate.of(2018, 12, 15),"I feel more relaxed"));       
      System.out.println("Adding The Third Story: "+myDiary.addStory("My third Exam", LocalDate.of(2018, 4, 10), "It is very easy"));
      System.out.println("Last Index at: "+myDiary.getLastIndex());
      System.out.println(myDiary);
      System.out.println();
      
      System.out.println("-----------------Lab#2.4 Get First, Last, or any Stories & Set story---------------");
      
      Story firstStory=myDiary.getFirstStory();
      System.out.println("Get First Story: "+firstStory);
      System.out.println();
      
      Story lastStory=myDiary.getLastStory();
      System.out.println("Get Last Story: "+lastStory);
      
      System.out.println();
      Story ss1=myDiary.getStory(1);
      System.out.println("Get Story at position index [1]:"+ss1);
      System.out.println(myDiary);
      
      
      System.out.println("-------Set (Replace) Story-------");
      Story s4=new Story("Review MySelf", LocalDate.now(), "The more you learn, the more you get");
      System.out.println("Replace Story at position index[0], Return previous story : "+myDiary.setStory(0, s4));
      s4.setContent("XXXX");
      System.out.println(myDiary);
    
      System.out.println("-------------------Lab#2.5 Finding Index of Story----------------------");
      System.out.println("Index of \'My Second Exam\' Story: "+myDiary.indexOf(new Story("My Second Exam",null,null )));
      System.out.println("Index of \'2018-05-01\' Story: "+myDiary.indexOf(new Story(null,LocalDate.of(2018, 05, 01),null )));
      System.out.println();
      
     
     
      
      System.out.println("------------------Lab#2.6 Get All Stories & Remove Story------------------");
      Story[] allStories=myDiary.getStories();
      for(Story st: allStories)
         System.out.println(st);
      System.out.println();
   
      System.out.println("--------Remove Story-------");
      Story RemovedS1Story=myDiary.removeStory(1);
      System.out.println("Remove "+RemovedS1Story+" from Diary..." );
      System.out.println(myDiary);
   
      
     
   }
}
