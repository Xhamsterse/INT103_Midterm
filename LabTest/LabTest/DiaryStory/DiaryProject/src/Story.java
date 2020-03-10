import java.time.LocalDate;

public class Story {

   private String storyName;
   private LocalDate writtenDate;
   private String content;

   public Story(Story s) {
      storyName = s.storyName;
      writtenDate = s.writtenDate;
      content = s.content;
   }

   public Story(String storyName, LocalDate writtenDate, String content) {
      this.storyName = storyName;
      this.writtenDate = writtenDate;
      this.content = content;
   }

   public String getStoryName() {
      return storyName;
   }

   public void setStoryName(String storyName) {
      this.storyName = storyName;
   }

   public LocalDate getWrittenDate() {
      return writtenDate;
   }

   public void setWrittenDate(LocalDate writtenDate) {
      this.writtenDate = writtenDate;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   @Override
   public String toString() {
      return "Story{" + "storyName=" + storyName + ", writtenDate=" + writtenDate + ", content=" + content + '}';
   }

   public boolean isMatch(Story s) {
      if(s.storyName==null) 
         return this.writtenDate.isEqual(s.writtenDate);
       
      if(s.writtenDate==null) 
         return this.storyName.equalsIgnoreCase(s.storyName);
              
      return this.storyName.equalsIgnoreCase(s.storyName) && this.writtenDate.isEqual(s.writtenDate);
     
   }
}

