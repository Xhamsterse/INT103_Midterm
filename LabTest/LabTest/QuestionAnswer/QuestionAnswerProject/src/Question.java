public class Question {
    private String question;
    private Choice[] choices;
    private Choice correctAnswer;
    private int complexityLevel;
    private int choiceCounting;

   
    public Question(String question, int complexityLevel, int numOfChoices) {
        this.question = question;
        this.choices = new Choice[numOfChoices];
        this.complexityLevel = complexityLevel;
    }

    public String getQuestion() {
        return question;
    }

    public Choice[] getChoices() {
        Choice temp[]=new Choice[choiceCounting];
        for(int index=0;index<choices.length;index++){
            temp[index]= choices[index];
        }
        return temp;
    }

    public int getComplexityLevel() {
        return complexityLevel;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setComplexityLevel(int complexityLevel) {
        this.complexityLevel = complexityLevel;
    }
    
    public void setCorrectAnswer(Choice correctAnswer){
        this.correctAnswer=new Choice(correctAnswer);
    }
    
    public boolean addChoice(int choiceNo, String choiceItem){
        if(choiceCounting>choices.length-1)
            return false;
        choices[choiceCounting++]=new Choice(choiceNo, choiceItem);
        return true;
    }
    
    public Choice replaceChoice(int choiceNo, String choiceItem){
        if (choiceNo<1 || choiceNo>=choiceCounting)
            return null;
        Choice prevChoice=choices[choiceNo-1];
        choices[choiceNo-1]=new Choice(choiceNo, choiceItem);
        return prevChoice;
    }
    
    public boolean checkAnswer(Choice userChoice){
       for(int index=0;index<choiceCounting;index++){
           if(choices[index].isMatch(userChoice))
               return true;
       }
       return false;
    }

    @Override
    public String toString() {
        StringBuilder questionString= new StringBuilder(question + "\n");
        for(int index=0;index<choiceCounting;index++){
            questionString.append(choices[index]+"\n");
            
        }
        questionString.append("complexityLevel=" + complexityLevel+"\n");
        questionString.append("correctAnswer=" + correctAnswer+"\n");
        questionString.append("choiceCounting=" + choiceCounting);
        return questionString.toString();
    }
    
    
    
    
    
}
