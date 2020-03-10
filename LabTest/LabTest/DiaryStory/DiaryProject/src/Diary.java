import java.time.LocalDate;

public class Diary {
   private String diaryName;
   private String diaryOwner;
   private Story stories[];
   private int lastIndex;

   public Diary(int maxStories) {
      stories = new Story[maxStories];
      lastIndex = -1;
   }

   public String getDiaryName() {
      return diaryName;
   }

   public void setDiaryName(String diaryName) {
      this.diaryName = diaryName;
   }

   public String getDiaryOwner() {
      return diaryOwner;
   }

   public void setDiaryOwner(String diaryOwner) {
      this.diaryOwner = diaryOwner;
   }

   public int getLastIndex() {
      return lastIndex;
   }

   @Override
   public String toString() {
      StringBuilder diaryString=new StringBuilder();
      diaryString.append("Diary{Diary Name="+diaryName+", Diary Owner="+ diaryOwner+"\n");
      //String diaryString=String.format("Diary{Diary Name=%s, Diary Owner=%s}%n", diaryName, diaryOwner, "\n");
      for (int index = 0; index <= lastIndex; index++) {
         //diaryString = String.format("%s%s%n",diaryString,stories[index], "\n");
         diaryString.append(stories[index]+"\n");
      }
      return diaryString.toString();
   }

   public boolean addStory(String storyName, LocalDate writtenDate, String content) {
      if (lastIndex >= stories.length - 1) {
         return false;
      }
   
      stories[++lastIndex] = new Story(storyName, writtenDate, content);
      return true;
   }

   public Story getFirstStory() {
        return stories[0];
   }

   public Story getLastStory() {
      if (lastIndex < 0) {
         return null;
      }
      return stories[lastIndex];
   }

   public Story getStory(int index) {
      if (index < 0 || index > lastIndex) {
         return null;
      }
      return stories[index];
   }

   public Story setStory(int index, Story s) {
      if (index < 0 || index > lastIndex) {
         return null;
      }
      Story prevStory = stories[index];
      stories[index] = new Story(s);
      return prevStory;
   }

   public int indexOf(Story s) {
      for (int index = 0; index <= lastIndex; index++) {
         if (stories[index].isMatch(s)) {
            return index;
         }
      }
      return -1;
   }

   public Story[] getStories() {
      if (lastIndex < 0) {
         return null;
      }
      Story[] userStories = new Story[lastIndex + 1];
      for (int index = 0; index <= lastIndex; index++) {
         userStories[index] = stories[index];
      }
      return userStories;
   }

   public Story removeStory(int removedIndex) {
      if (removedIndex < 0 || removedIndex > lastIndex) {
         return null;
      }
      Story removedStory = stories[removedIndex];
      for (int index = removedIndex; index < lastIndex; index++) {
         stories[index] = stories[index + 1];
      }
      stories[lastIndex--] = null;
      return removedStory;
   }

}




