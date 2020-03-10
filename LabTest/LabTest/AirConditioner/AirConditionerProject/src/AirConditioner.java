
public class AirConditioner {
    private final int MAX_TEMPERATURE = 30 ;
    private final int MIN_TEMPERATURE = 20 ;
    private final int MAX_FAN_SPEED = 2 ;
    private final int MIN_FAN_SPEED = 0 ;
    private boolean airOn ;
    private boolean fanOn ;
    private int targetTemperature ;
    private int fanSpeed ;

    public AirConditioner(int targetTemperature, int fanSpeed) {
        this.targetTemperature = targetTemperature;
        this.fanSpeed = fanSpeed;
    }

    public boolean isAirOn() {
        return airOn;
    }

    public int getTargetTemperature() {
        return targetTemperature;
    }

    @Override
    public String toString() {
        StringBuilder airString = new StringBuilder() ;
        airString.append("Air Condition { Status : ") ;
        if(airOn){
            airString.append(" on ") ;
            airString.append(" ,Temp : ") ;
            airString.append(this.targetTemperature) ;
            airString.append(" ,Fan : ") ;
            switch(fanSpeed){
                case 0 : airString.append("low") ; break ;
                case 1 : airString.append("medium") ; break ;
                case 2 : airString.append("high") ; break ;
            }
        } else {
            airString.append(" Off ") ;
        }
        airString.append(" }\n") ;
        return airString.toString() ;
    }

    public void turnAirOnOff(){
        if(airOn){
            airOn = false ;
            fanOn = false ;
        } else {
            airOn = true ;
            fanOn = true ;        
        }
    }
    
    
    public void increaseTemperature(){
        if(targetTemperature<MAX_TEMPERATURE){
            targetTemperature++ ;
        }
    }
    
    public void decreaseTemperature(){
        if(targetTemperature>MIN_TEMPERATURE){
            targetTemperature-- ;
        }
    }
    
    public void changeFanSpeed(){
        fanSpeed++ ;
        if(fanSpeed >MAX_FAN_SPEED){
            fanSpeed = MIN_FAN_SPEED ;
        }
    }  
    
}
