package com.algorithm;


/*
 * we can regard Class Time as a time duration or point-in-time
 */
public class Time{
	private int hour;
	private int minute;
	
	Time(int h,int m){
		if(h>=0 && h<24){
			hour=h;
		}
		
		if(m>=0 && minute<60){
			minute=m;
		}
	}
	
	Time (Time t){
		hour=t.hour;
		minute=t.minute;
	}

	int getHour()	{return hour;}
	int getMinute()	{return minute;}
	void setHour(int h){hour=h;}
	void setMinute(int m){minute=m;}
	
	// return t1+t2
	Time addTime(Time t2){
		Time t1=this;
		Time time=new Time(0,0);
		int minutes=t1.getMinute()+t2.getMinute();
		time.setMinute(minutes%60);
		time.setHour(t1.getHour() + t2.getHour() + (minutes/60));
		return time;
	}
	
	// return t1-t2
	Time substractTime(Time t2){
		Time t1=this;
		Time time =new Time(0,0);
		if(t1.getMinute()>=t2.getMinute()){
			time.setMinute( t1.getMinute()- t2.getMinute());
		}
		else{
			time.setMinute( t1.getMinute()+60- t2.getMinute());
			time.setHour(t1.getHour()-1-t2.getHour());
		}
		return time;
	}
	
	/*
	 * regard calling object time as t1, compare t1 with t
	 * return -1 =>  t1<t
	 * return 0  =>  t1==t
	 * return 1  =>  t1>t 
	 */
	 int compareTime (Time t){
		if(hour < t.getHour()){
			return -1;
		}
		else if(hour > t.getHour()){
			return 1;
		}
		else{
			if(minute < t.getMinute()){
				return -1;
			}
			else if(minute > t.getMinute()){
				return 1;
			}
			else{
				return 0;
			}
		}//if
	 }//function
	 
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hour;
		result = prime * result + minute;
		return result;
	}

	 @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minute != other.minute)
			return false;
		return true;
	}
}
