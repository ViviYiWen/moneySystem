/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monesystem;

/**
 *
 * @author WIN8_USER
 */
public class Personal {
    private String name;   //姓名
    private int passwd;    //密碼
    private int money;     //餘額
	
    public Personal(String name,int passwd,int money){
		this.name = name;
		this.passwd = passwd;
        this.money = money;
    }
	
    public String get_Name() {
		return name;
    }
	
    public int get_Passwd() {
		return passwd;
    }
 
    public int get_Money() {
		return money;
    }
	
    public boolean comparePasswd(int enterPwd){ //輸入金融卡密碼並核對
		if(enterPwd!=passwd){
			return false;
		}else{
			return true;
		}
    }
	
    public boolean saveMoney(int saveMon){ //存款計算餘額
		if(saveMon==0){
			return false;
		}else{
			money = money + saveMon;
			return true;
		}
    }
	
    public boolean countMoney(int pickUpMon){ //提款計算餘額
		if(pickUpMon>money){
			return false;
		}else{
			money = money - pickUpMon;
			return true;
		}
    }
	
    public void show(){ //顯示帳戶資訊
		System.out.println("帳戶:"+name+" 餘額:"+money);
    }
}
